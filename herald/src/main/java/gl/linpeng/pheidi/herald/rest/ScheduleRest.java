package gl.linpeng.pheidi.herald.rest;

import gl.linpeng.pheidi.herald.exception.CommonException;
import gl.linpeng.pheidi.herald.model.ScheduleModel;
import gl.linpeng.pheidi.herald.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Schedule Rest Api
 *
 * @author lin.peng
 * @since 0.0.1
 */
@RestController
@RequestMapping("/v1/user/{auth_id}/schedule")
public class ScheduleRest {

    @Autowired
    private ScheduleService scheduleService;

    /**
     * Push device schedule data to Pheidi
     *
     * @param auth         user auth key, auth key should be secret and unique
     * @param scheduleJson device schedule data
     * @return http status should be `200` if no exception
     */
    @PostMapping
    public ResponseEntity push(@PathVariable(value = "auth_id") String auth,
                               @RequestBody String scheduleJson) {
        scheduleService.save(auth, scheduleJson);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * Pull schedule data to device by timestamp
     *
     * @param auth      user auth key, auth key should be secret and unique
     * @param timestamp schedule data split by timestamp
     * @return Pheidi should return all data between now to timestamp
     */
    @GetMapping
    public ResponseEntity<List<ScheduleModel>> pull(@PathVariable(value = "auth_id") String auth,
                                                    @RequestParam(value = "timestamp") Long timestamp) {
        return Optional.ofNullable(scheduleService.query(auth, timestamp))
                .map(target -> new ResponseEntity<>(target, HttpStatus.OK))
                .orElseThrow(() -> new CommonException("error.pull.schedule"));
    }
}

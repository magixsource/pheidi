package gl.linpeng.pheidi.herald.service.impl;

import gl.linpeng.pheidi.herald.exception.CommonException;
import gl.linpeng.pheidi.herald.model.ScheduleModel;
import gl.linpeng.pheidi.herald.service.ScheduleMessagePublisher;
import gl.linpeng.pheidi.herald.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Schedule service
 *
 * @author lin.peng
 * @since 0.0.1
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    @Value("pheidi.auth")
    private String pheidiAuth;

    @Autowired
    private ScheduleMessagePublisher scheduleMessagePublisher;

    @Override
    public void save(String auth, String scheduleJson) {
        // validate
        checkAuth(auth);
        checkScheduleJson(scheduleJson);
        // send to conversion
        scheduleMessagePublisher.publish(scheduleJson);
    }


    @Override
    public List<ScheduleModel> query(String auth, Long timestamp) {
        checkAuth(auth);
        return null;
    }

    /**
     * Check is auth valid
     *
     * @param auth user auth
     */
    private void checkAuth(String auth) {
        if (StringUtils.isEmpty(auth)) {
            throw new CommonException("error.auth.empty");
        }
        if (!auth.equalsIgnoreCase(pheidiAuth)) {
            throw new CommonException("error.auth.invalid");
        }
    }

    /**
     * Check is schedule json valid
     *
     * @param scheduleJson schedule json string
     */
    private void checkScheduleJson(String scheduleJson) {
        if (StringUtils.isEmpty(scheduleJson)) {
            throw new CommonException("error.schedule.empty");
        }
    }
}

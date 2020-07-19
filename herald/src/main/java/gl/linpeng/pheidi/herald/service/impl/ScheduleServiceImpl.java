package gl.linpeng.pheidi.herald.service.impl;

import gl.linpeng.pheidi.herald.exception.CommonException;
import gl.linpeng.pheidi.herald.model.AuthModel;
import gl.linpeng.pheidi.herald.model.ScheduleModel;
import gl.linpeng.pheidi.herald.repository.AuthRepository;
import gl.linpeng.pheidi.herald.repository.ScheduleRepository;
import gl.linpeng.pheidi.herald.service.ScheduleMessagePublisher;
import gl.linpeng.pheidi.herald.service.ScheduleService;
import gl.linpeng.pheidi.herald.utils.AuthStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
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

    @Autowired
    private ScheduleMessagePublisher scheduleMessagePublisher;
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

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
        Date date = new Date(timestamp);
        return scheduleRepository.findByAuthAndSyncDateTime(auth, date);
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
        if (!isAuthValid(auth)) {
            throw new CommonException("error.auth.invalid");
        }
    }

    /**
     * Determine is auth valid
     *
     * @param auth user auth
     * @return valid return true
     */
    private boolean isAuthValid(String auth) {
        AuthModel model = new AuthModel();
        model.setCode(auth);
        model.setStatus(AuthStatus.ENABLED.getStatus());
        Example<AuthModel> example = Example.of(model);
        return authRepository.exists(example);
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

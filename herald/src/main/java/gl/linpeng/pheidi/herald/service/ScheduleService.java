package gl.linpeng.pheidi.herald.service;

import gl.linpeng.pheidi.herald.model.ScheduleModel;

import java.util.List;

/**
 * Schedule service interface
 *
 * @author lin.peng
 * @since 0.0.1
 */
public interface ScheduleService {
    /**
     * Save schedule data
     *
     * @param auth         user auth
     * @param scheduleJson schedule json string
     */
    void save(String auth, String scheduleJson);

    /**
     * Query all schedule data from timestamp to now
     *
     * @param auth      user auth
     * @param timestamp fetch timestamp
     * @return schedule data from timestamp to now
     */
    List<ScheduleModel> query(String auth, Long timestamp);
}

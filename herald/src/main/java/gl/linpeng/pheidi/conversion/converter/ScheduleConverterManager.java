package gl.linpeng.pheidi.conversion.converter;

import gl.linpeng.pheidi.herald.model.ScheduleModel;

/**
 * Schedule converter manager interface
 *
 * @author lin.peng
 * @since 0.0.1
 */
public interface ScheduleConverterManager {

    /**
     * delegate convert raw object to schedule model
     *
     * @param rawObject raw object from source
     * @return schedule model object
     */
    ScheduleModel convert(Object rawObject);
}

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
     * Registers schedule converter to manager
     *
     * @param scheduleConverter schedule converter object
     * @return true if operation success
     */
    boolean registersConverter(ScheduleConverter scheduleConverter);

    /**
     * delegate convert raw object to schedule model
     *
     * @param rawObject raw object from source
     * @return schedule model object
     */
    ScheduleModel convert(Object rawObject);
}

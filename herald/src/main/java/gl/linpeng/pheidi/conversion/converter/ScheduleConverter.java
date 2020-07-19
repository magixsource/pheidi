package gl.linpeng.pheidi.conversion.converter;

import gl.linpeng.pheidi.herald.model.ScheduleModel;

/**
 * Schedule converter interface
 *
 * @author lin.peng
 * @since 0.0.1
 */
public interface ScheduleConverter {

    /**
     * Determine weather support convert rawObject to schedule model
     *
     * @param rawObject raw object from source
     * @return true if converter can
     */
    boolean isSupported(Object rawObject);

    /**
     * Convert raw object from source to schedule model
     *
     * @param rawObject raw object from source
     * @return a schedule model object if convert success
     */
    ScheduleModel convert(Object rawObject);
}

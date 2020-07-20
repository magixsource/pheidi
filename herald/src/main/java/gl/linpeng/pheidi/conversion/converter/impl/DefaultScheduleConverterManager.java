package gl.linpeng.pheidi.conversion.converter.impl;

import gl.linpeng.pheidi.conversion.converter.ScheduleConverter;
import gl.linpeng.pheidi.conversion.converter.ScheduleConverterManager;
import gl.linpeng.pheidi.herald.model.ScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default schedule converter manager
 *
 * @author lin.peng
 * @since 0.0.1
 */
@Service
public class DefaultScheduleConverterManager implements ScheduleConverterManager {

    @Autowired
    private List<? extends ScheduleConverter> scheduleConverters;

    @Override
    public ScheduleModel convert(Object rawObject) {
        for (ScheduleConverter scheduleConverter : scheduleConverters) {
            if (scheduleConverter.isSupported(rawObject)) {
                return scheduleConverter.convert(rawObject);
            }
        }
        return null;
    }
}

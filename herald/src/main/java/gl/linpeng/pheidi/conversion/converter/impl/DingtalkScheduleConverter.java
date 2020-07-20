package gl.linpeng.pheidi.conversion.converter.impl;

import gl.linpeng.pheidi.conversion.converter.ScheduleConverter;
import gl.linpeng.pheidi.herald.model.ScheduleModel;
import org.springframework.stereotype.Service;

/**
 * Dingtalk schedule converter
 *
 * @author lin.peng
 * @since 0.0.1
 */
@Service
public class DingtalkScheduleConverter implements ScheduleConverter {

    @Override
    public boolean isSupported(Object rawObject) {
        if (rawObject instanceof String) {
            String json = rawObject.toString();
            // json path get dingtalk flag
        }
        return false;
    }

    @Override
    public ScheduleModel convert(Object rawObject) {
        return null;
    }
}

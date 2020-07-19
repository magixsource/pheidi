package gl.linpeng.pheidi.conversion.listener;

import gl.linpeng.pheidi.conversion.converter.ScheduleConverterManager;
import gl.linpeng.pheidi.herald.model.ScheduleModel;
import gl.linpeng.pheidi.herald.repository.ScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Conversion message listener
 *
 * @author lin.peng
 * @since 0.0.1
 */
@Service
public class ScheduleMessageListener implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(ScheduleMessageListener.class);
    @Autowired
    private ScheduleConverterManager scheduleConverterManager;
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String raw = Arrays.toString(message.getBody());
        logger.info("从频道订阅中接收消息 {}", raw);
        // convert message to stand spec schedule data struct
        ScheduleModel scheduleModel = scheduleConverterManager.convert(raw);
        // store stand spec schedule data to db
        scheduleRepository.save(scheduleModel);
    }
}

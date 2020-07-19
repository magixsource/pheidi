package gl.linpeng.pheidi.conversion.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Conversion message listener
 *
 * @author lin.peng
 * @since 0.0.1
 */
@Service
public class ScheduleMessageListener implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(ScheduleMessageListener.class);
    public static List<String> messageList = new ArrayList<>();

    @Override
    public void onMessage(Message message, byte[] bytes) {
        messageList.add(message.toString());
        logger.info("从频道订阅中接收消息 {}", message.toString());
        // convert message to stand spec schedule data struct
        //TODO there is to many schedule data from real world, so here i need a extendable architecture

        // store stand spec schedule data to time serial db
        // TODO now time serial db only `influx` one choice :( , is there any more lightweight ?
    }
}

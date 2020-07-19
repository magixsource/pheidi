package gl.linpeng.pheidi.herald.service.impl;

import gl.linpeng.pheidi.herald.service.ScheduleMessagePublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

/**
 * Schedule message publisher
 *
 * @author lin.peng
 * @since 0.0.1
 */
@Service
public class ScheduleMessagePublisherImpl implements ScheduleMessagePublisher {
    private Logger logger = LoggerFactory.getLogger(ScheduleMessagePublisherImpl.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ChannelTopic topic;

    public ScheduleMessagePublisherImpl(
            RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    @Override
    public void publish(String message) {
        logger.info("发布消息 {} {}", topic.getTopic(), message);
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}

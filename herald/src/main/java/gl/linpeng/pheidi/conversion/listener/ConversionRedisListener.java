package gl.linpeng.pheidi.conversion.listener;

import io.lettuce.core.pubsub.RedisPubSubListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Conversion redis listener
 *
 * @author lin.peng
 * @since 0.0.1
 */
public class ConversionRedisListener implements RedisPubSubListener<String, String> {
    private Logger logger = LoggerFactory.getLogger(ConversionRedisListener.class);

    @Override
    public void message(String channel, String message) {
        logger.info("从频道订阅中接收消息 {} {}", channel, message);
    }

    @Override
    public void message(String pattern, String channel, String message) {
        logger.info("从给定模式频道订阅中接收消息 {} {} {}", pattern, channel, message);
    }

    @Override
    public void subscribed(String channel, long count) {
        logger.info("订阅频道 {} {}", channel, count);
    }

    @Override
    public void psubscribed(String pattern, long count) {
        logger.info("订阅给定模式频道 {} {}", pattern, count);
    }

    @Override
    public void unsubscribed(String channel, long count) {
        logger.info("取消订阅频道 {} {}", channel, count);
    }

    @Override
    public void punsubscribed(String pattern, long count) {
        logger.info("取消订阅给定模式频道 {} {}", pattern, count);
    }
}

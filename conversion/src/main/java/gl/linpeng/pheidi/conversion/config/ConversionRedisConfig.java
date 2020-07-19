package gl.linpeng.pheidi.conversion.config;

import gl.linpeng.pheidi.conversion.listener.ScheduleMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * Redis config
 *
 * @author lin.peng
 * @since 0.0.1
 */
@Configuration
@EnableRedisRepositories
@Order(2)
public class ConversionRedisConfig {

    @Autowired
    private ChannelTopic channelTopic;

    @Bean
    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new ScheduleMessageListener());
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, channelTopic);
        return container;
    }


}

package gl.linpeng.pheidi.herald.config;

import gl.linpeng.pheidi.herald.utils.HeraldConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * Redis config
 *
 * @author lin.peng
 * @since 0.0.1
 */
@Configuration
@EnableRedisRepositories
public class HeraldRedisConfig {

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic(HeraldConst.CHANNEL_PHEIDI_SCHEDULE);
    }

}

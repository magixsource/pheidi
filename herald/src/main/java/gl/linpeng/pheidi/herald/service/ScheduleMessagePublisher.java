package gl.linpeng.pheidi.herald.service;

/**
 * Schedule message publisher
 *
 * @author lin.peng
 * @since 0.0.1
 */
public interface ScheduleMessagePublisher {
    /**
     * publish message to REDIS
     *
     * @param message raw message
     */
    void publish(String message);
}

package gl.linpeng.pheidi.herald.repository;

import gl.linpeng.pheidi.herald.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User repository
 *
 * @author lin.peng
 * @since 0.0.1
 */
public interface UserRepository extends JpaRepository<UserModel, Long> {
}

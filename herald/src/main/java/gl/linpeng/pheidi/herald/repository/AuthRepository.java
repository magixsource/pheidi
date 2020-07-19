package gl.linpeng.pheidi.herald.repository;

import gl.linpeng.pheidi.herald.model.AuthModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Auth repository
 *
 * @author lin.peng
 * @since 0.0.1
 */
public interface AuthRepository extends JpaRepository<AuthModel, Long> {
}

package gl.linpeng.pheidi.herald.repository;

import gl.linpeng.pheidi.herald.model.ScheduleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Schedule repository
 *
 * @author lin.peng
 * @since 0.0.1
 */
public interface ScheduleRepository extends JpaRepository<ScheduleModel, Long> {

    @Query(value = "SELECT t.* FROM pheidi_schedule t,pheidi_auth t2 WHERE t.AUTH_ID = t2.ID AND t2.`CODE` = ?1 AND t.CREATION_DATE > ?2 ORDER BY t.CREATION_DATE",nativeQuery = true)
    List<ScheduleModel> findByAuthAndSyncDateTime(String auth, Date date);
}

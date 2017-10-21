package log.repository;

import log.entity.AccessLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mher on 12/22/2015.
 */
@Repository
public interface AccessLogRepository extends CrudRepository<AccessLog, Long> {
}

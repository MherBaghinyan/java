package com.ef.repository;

import com.ef.entity.RequestData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mher on 12/22/2015.
 */
@Repository
public interface AccessLogRepository extends CrudRepository<RequestData, Long> {
}

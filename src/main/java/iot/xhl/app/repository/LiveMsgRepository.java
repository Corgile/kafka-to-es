package iot.xhl.app.repository;

import iot.xhl.app.domain.LiveMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiveMsgRepository extends ElasticsearchRepository<LiveMessage, String> {
}

package iot.xhl.app.repository;

import iot.xhl.app.domain.LiveMessage;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Optional;

@Repository
public interface LiveMsgRepository extends ElasticsearchRepository<LiveMessage, String> {

	Page<LiveMessage> findBySrcIp(String srcIp, Pageable pageable);

	Page<LiveMessage> findDistinctTopBySrcIpEqualsAndDstIpEquals(String srcEq, String dstEq, Pageable pageable);
}

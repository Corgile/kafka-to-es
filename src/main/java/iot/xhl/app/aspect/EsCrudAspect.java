package iot.xhl.app.aspect;

import iot.xhl.app.domain.LiveMessage;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@EnableAspectJAutoProxy
@Slf4j
public class EsCrudAspect {

	@Before("execution(* org.springframework.data.repository.CrudRepository.saveAll(..))&&args(currentBuffer)")
	public void beforeSaveAll(JoinPoint joinPoint, List<LiveMessage> currentBuffer) {
		int size = currentBuffer.size();
		if (size > 0) {
			log.info("SaveAll方法开始执行(将【{}】条告警消息写入ES)", size);
		}
	}

	@After("execution(* org.springframework.data.repository.CrudRepository.saveAll(..))&&args(currentBuffer)")
	public void afterSaveAll(JoinPoint joinPoint, List<LiveMessage> currentBuffer) {
		if (!currentBuffer.isEmpty()) {
			log.info("SaveAll方法执行完成");
		}
	}
}

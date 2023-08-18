package iot.xhl.app.aspect;

import iot.xhl.app.domain.LiveMessage;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Aspect
@Component
@EnableAspectJAutoProxy
@Slf4j
public class SaveAllLoggingAspect {

	@Before("execution(* org.springframework.data.repository.CrudRepository.saveAll(..))&&args(currentBuffer)")
	public void beforeSaveAll(JoinPoint joinPoint, Queue<LiveMessage> currentBuffer) {
		log.info("\u001B[32m开始执行 {} \u001B[0m", joinPoint.getSignature().toString());
		int size = currentBuffer.size();
		if (size > 0) {
			log.info("SaveAll方法开始执行(将【{}】条告警消息写入ES)", size);
		}
	}

	@After("execution(* org.springframework.data.repository.CrudRepository.saveAll(..))&&args(currentBuffer)")
	public void afterSaveAll(JoinPoint joinPoint, Queue<LiveMessage> currentBuffer) {
		if (!currentBuffer.isEmpty()) {
			log.info("SaveAll方法执行完成");
		}
		log.info("\u001B[32m执行 {} 完成\u001B[0m", joinPoint.getSignature().toString());
	}
}

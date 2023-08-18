package iot.xhl.app.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import iot.xhl.app.domain.LiveMessage;
import iot.xhl.app.repository.LiveMsgRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;


@Component
public class LiveMessageConsumer {

	@Resource(name = "objectMapper")
	private ObjectMapper objectMapper;

	@Resource
	private LiveMsgRepository msgRepository;

	// 双缓冲队列
	private final AtomicReference<Queue<LiveMessage>> buffer1 = new AtomicReference<>(new ConcurrentLinkedQueue<>());
	private final AtomicReference<Queue<LiveMessage>> buffer2 = new AtomicReference<>(new ConcurrentLinkedQueue<>());


	@KafkaListener(topics = {"warn"})
	public void onMessageArrive(ConsumerRecord<String, String> record) throws IOException {
		// 转成实体
		String jsonMessage = record.value();
		LiveMessage message = objectMapper.readValue(jsonMessage, LiveMessage.class);
		Queue<LiveMessage> currentBuffer = buffer1.get();
		currentBuffer.add(message);
	}

	@Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
	public void run() {
		Queue<LiveMessage> currentBuffer = buffer1.getAndSet(buffer2.get());
		this.msgRepository.saveAll(currentBuffer);
		currentBuffer.clear();
		buffer2.set(currentBuffer);
	}
}

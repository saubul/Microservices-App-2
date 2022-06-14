package ru.saubul.kafkalog.listener;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import ru.saubul.kafkalog.entity.CustomerEntity;

@Component
public class MicroservicesTopicListener {
	
	private final Logger logger = Logger.getLogger("logger");
	
	public MicroservicesTopicListener() throws SecurityException, IOException {
		FileHandler fileHandler = new FileHandler("customer.log", true);
		logger.addHandler(fileHandler);
	}
	
	@KafkaListener(topics = "microservicesTopic", groupId = "groupId")
	public void microservicesTopicListen(ConsumerRecord<String, CustomerEntity> record) {
		logger.info("Time: " + record.timestamp() + ", value: " + record.value());
	}
	
}

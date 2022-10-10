package com.vezinet.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendDataToTopic(String kafkaTopic, String data) {
		kafkaTemplate.send(kafkaTopic, data);
	}

}

package com.vezinet.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DefaultKafkaListner {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultKafkaListner.class);

	@KafkaListener(topics = "default_topic", groupId = "group_id")
	public void consume(String message) {
		LOG.info(message);
	}

}

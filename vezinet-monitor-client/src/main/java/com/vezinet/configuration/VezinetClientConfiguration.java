package com.vezinet.configuration;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vezinet.kafka.KafkaProducer;

//@Component
public class VezinetClientConfiguration implements CommandLineRunner {

	@Autowired
	private KafkaProducer kafkaProducer;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		Map<String, String> mysqlData = new HashMap<>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String data = objectMapper.writeValueAsString(mysqlData);
			kafkaProducer.sendDataToTopic("test", data);
		} catch (Exception e) {

		}
		// kafkaProducer.sendDataToTopic("test", data);

	}

}

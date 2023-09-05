package com.review.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.customer.entity.CustomerEvent;

@Service
public class Consumer {
	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${sping.kafka.consumer.group-id}")

	public void consume(CustomerEvent event) {

		logger.info(String.format("customer event received in stock event=> %s", event.toString()));

		// save customer event into database

	}

}

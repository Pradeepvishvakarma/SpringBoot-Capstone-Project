package com.customer.serviceimpl;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.customer.entity.CustomerEvent;

@Service
public class ProducerCustomer {

	private static final Logger logger = LoggerFactory.getLogger(ProducerCustomer.class);

	private NewTopic topic;

	private KafkaTemplate<String, CustomerEvent> kafkaTemplate;

	public ProducerCustomer(NewTopic topic, KafkaTemplate<String, CustomerEvent> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(CustomerEvent event) {

		logger.info(String.format("Customer event => %s", event.toString()));

		// create message

		Message<CustomerEvent> message = MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC, topic.name())
				.build();

		kafkaTemplate.send(message);

	}

}

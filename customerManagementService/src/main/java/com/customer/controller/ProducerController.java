package com.customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customer;
import com.customer.entity.CustomerEvent;
import com.customer.serviceimpl.ProducerCustomer;

@RestController
@RequestMapping("/api/v1")
public class ProducerController {

	private ProducerCustomer producerCustomer;

	public ProducerController(ProducerCustomer producerCustomer) {
		super();
		this.producerCustomer = producerCustomer;
	}

	@PostMapping("/customers")

	public String placeOrder(@RequestBody Customer customer) {

		CustomerEvent customerEvent = new CustomerEvent();

		customerEvent.setStatus("Pending");

		customerEvent.setMessage("order status is in pending state");

		customerEvent.setCustomer(customer);

		producerCustomer.sendMessage(customerEvent);

		return "Customer's Review updated Successfully";

	}

}

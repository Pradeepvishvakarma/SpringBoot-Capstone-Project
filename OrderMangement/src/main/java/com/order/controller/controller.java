package com.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.order.dto.Requestdto;
import com.order.entity.Order;
import com.order.exeption.ResourceNotFoundException;
import com.order.repository.OrderItemRepository;
import com.order.repository.OrderRepository;
import com.order.serviceimpl.OrderServiceimpl;

@RestController
@RequestMapping("/orderr")
public class controller {
	@Autowired
	private OrderServiceimpl orderServiceimpl;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	private Map<String, Object> response;

	@PostMapping("/placeOrder")
	public Order placeOrder(@RequestBody Requestdto request) {
		return orderRepository.save(request.getOrderr());
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Map<String, Object>> UpdateOrderbyId(@RequestBody Order order, @PathVariable long id)
			throws ResourceNotFoundException {
		response = new HashMap<>();
		response.put("message", "Order update Successfully");
		response.put("status", HttpStatus.OK);
		response.put("body", orderServiceimpl.updateOrderbyId(order, id));
		response.put("Error", false);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}



	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> cancelOrder(@PathVariable long id) {
		orderServiceimpl.deleteByOrder(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

}

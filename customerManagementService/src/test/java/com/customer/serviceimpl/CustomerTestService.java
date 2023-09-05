package com.customer.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.entity.Customer;
import com.customer.exception.CustomerNotFoundException;
import com.customer.repository.CustomerRepository;

@SpringBootTest
public class CustomerTestService {
	@Mock

	private CustomerRepository customerRepository;

	@InjectMocks

	private CustomerServiceimpl customerService;

	@Test

	public void testUpdateCustomer() throws CustomerNotFoundException {

		// Arrange

		long customerId = 123; // Replace with an appropriate customer ID

		Customer existingCustomer = new Customer();

		existingCustomer.setid(customerId);

		existingCustomer.setCustomerName("Existing Customer");

		Customer updatedCustomer = new Customer();

		updatedCustomer.setid(customerId);

		updatedCustomer.setCustomerName("Updated Customer Name");

		when(customerRepository.findById(customerId)).thenReturn(Optional.of(existingCustomer));

		when(customerRepository.save(any())).thenReturn(updatedCustomer);

		// Act

		Customer result = customerService.UpdateCustomer(updatedCustomer, customerId);

		// Assert

		assertEquals(updatedCustomer.getCustomerName(), result.getCustomerName());

		verify(customerRepository, times(1)).findById(customerId);

		verify(customerRepository, times(1)).save(any());

	}

}

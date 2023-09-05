package com.customer.controller;



import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import com.customer.entity.Customer;
import com.customer.serviceimpl.CustomerServiceimpl;

import java.util.HashMap;

import java.util.Map;


class ControllerTest {


    @Mock

    private CustomerServiceimpl customerService;


    @InjectMocks

    private CustomerController customerController;


    @BeforeEach

    void setUp() {

        MockitoAnnotations.openMocks(this);

    }


    @Test

    void testCreateCustomer() throws Exception {

        // Mocking

        Customer customer = new Customer();

        when(customerService.createCustomer(any())).thenReturn(customer);


        // Test

        ResponseEntity<Map<String, Object>> responseEntity = customerController.createCustomer(customer);


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertEquals("Order placed Successfully", responseEntity.getBody().get("message"));

        assertFalse((boolean) responseEntity.getBody().get("Error"));

    }


    @Test

    void testUpdateCustomer() throws Exception {

        // Mocking

        long customerId = 123;

        Customer customer = new Customer();

        when(customerService.UpdateCustomer(any(), eq(customerId))).thenReturn(customer);


        // Test

        ResponseEntity<Map<String, Object>> responseEntity = customerController.UpdateCustomerbyId(customer, customerId);


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertEquals("Order placed Successfully", responseEntity.getBody().get("message"));

        assertFalse((boolean) responseEntity.getBody().get("Error"));

    }


    @Test

    void testDeleteCustomer() throws Exception {

        // Test

        ResponseEntity<String> responseEntity = customerController.cancelCustomer(123);


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertEquals("Deleted Successfully", responseEntity.getBody());


        verify(customerService).deleteCustomer(123);

    }

}

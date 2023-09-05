package com.customer.entity;

public class CustomerEvent {
	
	private String message;
	private String status;
	private Customer customer;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerEvent(String message, String status, Customer customer) {
		super();
		this.message = message;
		this.status = status;
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerEvent [message=" + message + ", status=" + status + ", customer=" + customer + "]";
	}
	public CustomerEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

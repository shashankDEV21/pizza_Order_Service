package com.accenture.lkm.business.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class PizzaOrderBean {
	
	private Integer orderId;
	
	@NotNull(message="Please select a valid Pizza")
	private Integer pizzaId;
	
	@Size(min=3,max=30, message="Customer Name should have length between 3 and 30")
	private String customerName;
	
	@Size(min=10,max=10, message="Contact Number should have length 10")
	private String contactNumber;
	
	private Double bill;
	
	@Min(value=1,message="Minimum Value for the Quantity is One")
	@NotNull(message="Quantity should not be empty")
	private Integer numberOfPiecesOrdered;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	public Integer getNumberOfPiecesOrdered() {
		return numberOfPiecesOrdered;
	}
	public void setNumberOfPiecesOrdered(Integer numberOfPiecesOrdered) {
		this.numberOfPiecesOrdered = numberOfPiecesOrdered;
	}
	@Override
	public String toString() {
		return "PizzaOrderBean [orderId=" + orderId + ", pizzaId=" + pizzaId
				+ ", customerName=" + customerName + ", contactNumber="
				+ contactNumber + ", bill=" + bill + ", numberOfPiecesOrdered="
				+ numberOfPiecesOrdered + "]";
	}
	
	
}

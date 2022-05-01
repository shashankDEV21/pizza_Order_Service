package com.accenture.lkm.service;

import java.util.List;
import java.util.Map;

import com.accenture.lkm.business.bean.PizzaOrderBean;


public interface PizzaService {	
	public List<PizzaOrderBean> getOrderDetails(Double fromBill, Double toBill) throws Exception;
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaBean) throws Exception;
	public Map<Integer,String> findAllPizzaDetails()throws Exception;
}
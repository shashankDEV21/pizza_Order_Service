package com.accenture.lkm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.PizzaBean;
import com.accenture.lkm.business.bean.PizzaOrderBean;
import com.accenture.lkm.dao.PizzaDAOWrapper;

@Service
public class PizzaServiceImpl implements PizzaService{
	
	@Autowired
	private  PizzaDAOWrapper pizzaDAOWrapper;

	
	public List<PizzaOrderBean> getOrderDetails(Double fromBill,Double toBill) throws Exception {
		List<PizzaOrderBean> list= pizzaDAOWrapper.getOrderDetails(fromBill, toBill);
		if(list==null||list.size()==0){
			throw new Exception("No records were found for the entered Bill Range");
		}
		return list;
	}
	

	
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean)throws Exception {
		double price= pizzaDAOWrapper.getPizzaPrice(pizzaOrderBean.getPizzaId());
		Double bill=pizzaOrderBean.getNumberOfPiecesOrdered() * price;
		pizzaOrderBean.setBill(bill);
		return   pizzaDAOWrapper.addPizzaOrderDetails(pizzaOrderBean);
	}

	
	
	public Map<Integer,String> findAllPizzaDetails() throws Exception {
		List<PizzaBean> pizzaList=pizzaDAOWrapper.findAllPizzaDetails();
		Map<Integer,String> pizzaMap=new HashMap<Integer,String>();
		for(PizzaBean item:pizzaList){
			pizzaMap.put(item.getPizzaId(), item.getPizzaName());
		}
		return pizzaMap;
		
	}
}

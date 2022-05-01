package com.accenture.lkm.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.PizzaOrderBean;
import com.accenture.lkm.service.PizzaService;

@Controller
public class PizzaOrderController {

	@Autowired
	private PizzaService pizzaService;
	
	// Create Pizza
	@RequestMapping(value = "/LoadPizzaOrder", method = RequestMethod.GET)
	public ModelAndView loadSavePizza() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PizzaOrder");
		modelAndView.addObject("pizzaOrderObj",new PizzaOrderBean());
		return modelAndView;

	}
		
	@RequestMapping(value = "/SavePizzaOrder", method = RequestMethod.POST)
	public ModelAndView addPizzaOrderDetails(@Valid @ModelAttribute("pizzaOrderObj") PizzaOrderBean pizzaOrderBean
			,BindingResult bindingResult ) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(bindingResult.hasErrors())
		{
			modelAndView.setViewName("PizzaOrder");
		}
		else{
		PizzaOrderBean retPizzaOrderBean= pizzaService.addPizzaOrderDetails(pizzaOrderBean);	
		modelAndView.setViewName("PizzaOrderSuccess");
		modelAndView.addObject("message","Hi: "+retPizzaOrderBean.getCustomerName()
											   +", your order is placed with orderId: "
											   +retPizzaOrderBean.getOrderId()
											   +", Bill to be paid is: "+retPizzaOrderBean.getBill());
		}
		
		return modelAndView;
	}	
	
	@ModelAttribute("pizzaNamesAndId")
	public Map<Integer,String> populatePizzaNames() throws Exception{
		return pizzaService.findAllPizzaDetails();
	}
	
	//Error Handler:
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		return modelAndView;
	}
	
}

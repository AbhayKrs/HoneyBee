package com.abhay.HoneyBee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abhay.HoneyBee.util.FileUploadUtility;
import com.abhay.HoneyBee.validator.ProductValidator;
import com.abhay.shoppingbackend.dao.CategoryDAO;
import com.abhay.shoppingbackend.dao.ProductDAO;
import com.abhay.shoppingbackend.dto.Category;
import com.abhay.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products",method=RequestMethod.GET) 
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		Product new_product = new Product();
		
		new_product.setSupplierId(1);
		new_product.setActive(true);
		
		mv.addObject("product",new_product);
		
		if(operation!=null) {
			if(operation.equals("product")) {
				mv.addObject("message","Product Submitted Successfully!");
			}
		}
		
		return mv;
	}
	//Handling Product Submission
	@RequestMapping(value="/products",method=RequestMethod.POST) 
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mod_product, BindingResult results, Model model, HttpServletRequest request) {
		new ProductValidator().validate(mod_product,results);
		
		
		//Check for any errors
		if(results.hasErrors()) {
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			model.addAttribute("message","Validation Failed! Try Again!!");
			return "page";
		}
		
		logger.info(mod_product.toString());
		
		//Creating new product record
		productDAO.add(mod_product);
		
		if(!mod_product.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request,mod_product.getFile(), mod_product.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	//Returning categories for all request mappings
	@ModelAttribute("categories") 
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
}

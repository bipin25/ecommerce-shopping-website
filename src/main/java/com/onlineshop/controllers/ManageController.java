package com.onlineshop.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.entity.Category;
import com.onlineshop.entity.Product;
import com.onlineshop.entity.UserDetail;
import com.onlineshop.service.Categoryservice;
import com.onlineshop.service.ProductService;

@Controller
@RequestMapping("manage")
public class ManageController {

	@Autowired
	Categoryservice categoryService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/product")
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation) {
		ModelAndView mav = new ModelAndView("manageProducts");
		if(operation!=null) {
			if(operation.equalsIgnoreCase("product")) {
				mav.addObject("message", "product Added Successfully");
			}
		}
		Product product = new Product();
		UserDetail user = new UserDetail();
		user.setId(2);
		product.setUserDetails(user);
		mav.addObject("product", product);
		return mav;
	}

	//submission of product
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public String productSubmission(@Valid @ModelAttribute("product") Product product,BindingResult results,Model model,
			HttpServletRequest request) {
		if(results.hasErrors()) {
			System.out.println(request.getSession().getServletContext().getRealPath("/assets/image"));
			model.addAttribute("errorMessage", "Validation Failed !!!");
			return "manageProducts";
		}
		productService.saveOrUpdateProduct(product);
		return "redirect:/manage/product?operation=product";
	}
	
	
	//method level modelattrubute, returing categories for all request
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryService.getAllCategory();
	}
	
}

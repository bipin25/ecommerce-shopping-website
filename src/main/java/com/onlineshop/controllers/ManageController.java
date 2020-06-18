package com.onlineshop.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.entity.Category;
import com.onlineshop.entity.Product;
import com.onlineshop.entity.UserDetail;
import com.onlineshop.service.Categoryservice;
import com.onlineshop.service.ProductService;
import com.onlineshop.utility.FileUploadUtility;
import com.onlineshop.validator.CategoryValidator;
import com.onlineshop.validator.ProductValidator;

@Controller
@RequestMapping("manage")
public class ManageController {

	@Autowired
	Categoryservice categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductValidator productValidator;
	
	@Autowired
	CategoryValidator categoryValidator;
	
	@RequestMapping(value="/product")
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation) {
		ModelAndView mav = new ModelAndView("manageProducts");
		if(operation!=null) {
			if(operation.equalsIgnoreCase("product")) {
				mav.addObject("message", "product Added Successfully");
			}else if (operation.equalsIgnoreCase("category")) {
				mav.addObject("message", "Category Added Successfully");
			}
		}
		Product product = new Product();
		UserDetail user = new UserDetail();
		user.setId(2);
		product.setUserDetails(user);
		mav.addObject("product", product);
		mav.addObject("category", new Category());
		mav.addObject("productList", productService.getAllProduct());
		return mav;
	}

	//save product
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("product") Product product,BindingResult results,Model model,
			HttpServletRequest request) throws IllegalStateException, IOException {
		
		//Spring Validator Api
		if(product.getId()==0) {
			//file validate
			productValidator.validate(product, results);	
		}else {
			if(!product.getFile().isEmpty())
				productValidator.validate(product, results);
		}
		//Hibernate Validator Api
		if(results.hasErrors()) {
			model.addAttribute("validationError", "Validation Failed !!!");
			model.addAttribute("category", new Category());
			model.addAttribute("productList", productService.getAllProduct());
			return "manageProducts";
		}
		
		productService.saveOrUpdateProduct(product);
		if(!product.getFile().isEmpty())
			FileUploadUtility.uploadFile(product.getFile(),product.getCode(),request);
		return "redirect:/manage/product?operation=product";
	}

	//edit product by id
	@RequestMapping(value="/product/{productId}")
	public ModelAndView editProducts(@PathVariable("productId") long id) throws Exception {
		ModelAndView mav = new ModelAndView("manageProducts");		
		mav.addObject("product", productService.getProductById(id));
		mav.addObject("productList", productService.getAllProduct());
		mav.addObject("category", new Category());
		return mav;
	}
	
	@PostMapping(value="/category")
	public String saveNewCategory(@ModelAttribute("category") Category category,BindingResult results,Model model) {
		
		//Spring Validation api
		this.categoryValidator.validate(category, results);
		if(results.hasErrors()) {
			model.addAttribute("validationError", "Validation Failed");
			model.addAttribute("product", new Product());
			model.addAttribute("productList", productService.getAllProduct());
			return "manageProducts";
		}
		//categoryService.saveorUpdateCategory(category);
		return "redirect:/manage/product?operation=category";
	}
	
	//method level modelattrubute, returing categories for all request
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryService.getAllCategory();
	}
	
	//model attribute required at modal
	/*@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}*/
}

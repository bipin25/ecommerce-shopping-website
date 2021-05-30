package com.onlineshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.entity.Product;
import com.onlineshop.service.Categoryservice;
import com.onlineshop.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	Categoryservice categoryService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value= {"/","/home","index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("categoryList", categoryService.getAllCategory());
		//mv.addObje.ct("productList", productService.listActiveProduct());
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping(value= {"/issue1"})
	public ModelAndView index1() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("categoryList", categoryService.getAllCategory());
		//mv.addObje.ct("productList", productService.listActiveProduct());
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping(value= "/productlist")
	public ModelAndView productlist() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("categoryList", categoryService.getAllCategory());
		mv.addObject("productList", productService.listActiveProduct());
		mv.setViewName("products");
		return mv;
	}
	
	
	@RequestMapping(value="/productbyid/{productid}")
	public ModelAndView showProductById(@PathVariable("productid") long id) throws Exception {
		ModelAndView mv = new ModelAndView();
		Product product = productService.getProductById(id);
		//increasing count
		product.setViews(product.getViews()+1);
		productService.saveOrUpdateProduct(product);
		
		mv.addObject("product", product);
		mv.setViewName("singleProduct");
		return mv;
	}	
	@RequestMapping(value= "/productbycategoryid/{categoryid}")
	public ModelAndView productByCategoryId(@PathVariable(name="categoryid") long categoryId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("categoryList", categoryService.getAllCategory());
		mv.addObject("productList", productService.listActiveProductByCategory(categoryId));
		mv.setViewName("products");
		return mv;
	}
	@RequestMapping(value= "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("about");
		return mv;
	}
	@RequestMapping(value= "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("contact");
		return mv;
	}
}

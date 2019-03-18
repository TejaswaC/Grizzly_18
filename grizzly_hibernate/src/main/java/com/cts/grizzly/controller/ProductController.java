package com.cts.grizzly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzly.bean.Category;
import com.cts.grizzly.bean.Login;
import com.cts.grizzly.bean.Product;
import com.cts.grizzly.bean.Profile;
import com.cts.grizzly.service.CategoryService;
import com.cts.grizzly.service.ProductService;


@Controller
public class ProductController {
	@Autowired
	//@Qualifier("loginService")
	ProductService productService;
	
	
	
	@RequestMapping(value="AddProduct.html")                //GetMapping(value="login.html", method= RequestMethod.GET) could also be done
	public String getLoginPage(){
		return "login";
	}
	
	@RequestMapping(value="AddProduct.html", method= RequestMethod.POST)						//PostMapping(value="login.html", method= RequestMethod.GET)
	public ModelAndView validateUser(@ModelAttribute Product product){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(product);
		productService.addProduct(product);
			System.out.println("Product Inserted");

			modelAndView.setViewName("Admin-ListProducts");
			


			return modelAndView;
			}
	
	@RequestMapping(value="viewproduct.html")						//PostMapping(value="login.html", method= RequestMethod.GET)
	public ModelAndView viewProducts(@RequestParam("id") String id){
		ModelAndView modelAndView = new ModelAndView();
		
		Product product = productService.getProductByID(id);
		
		modelAndView.addObject("product",product);

			

		modelAndView.setViewName("Admin-ViewProduct");

			return modelAndView;
			}
	
	@RequestMapping(value="deleteproduct.html")						//PostMapping(value="login.html", method= RequestMethod.GET)
	public ModelAndView deleteProducts(@RequestParam("id") String id){
		ModelAndView modelAndView = new ModelAndView();
		
		productService.deleteProductByID(id);
		
System.out.println("Produt Deleted");
			


			return modelAndView;
			}
			
			

			
	}
	



package com.test.psk.product.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.psk.product.service.ProductServiceImpl;

@Controller
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("product");

		return mav;
	}
}

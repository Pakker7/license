package com.test.psk;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView test(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("test");

		return mav;
	}

	@RequestMapping(value = "/sample/create", method = RequestMethod.GET)
	public ModelAndView create(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("sample/create");

		return mav;
	}

	@RequestMapping(value = "/sample/list", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("sample/list");

		return mav;
	}

}

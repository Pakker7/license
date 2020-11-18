package com.test.psk.history.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.psk.history.service.DistributeHistoryServiceImpl;

@Controller
public class DistributeHistoryController {

	@Autowired
	private DistributeHistoryServiceImpl distributeHistoryService;

	@RequestMapping(value = "/history/distribute", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("history/distribute");

		return mav;
	}
}

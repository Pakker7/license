package com.test.psk.issue.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.psk.issue.service.IssueServiceImpl;

@Controller
public class IssueController {

	@Autowired
	private IssueServiceImpl issueService;

	@RequestMapping(value = "/issueList", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("issueList");

		return mav;
	}

	@RequestMapping(value = "/issue/create", method = RequestMethod.GET)
	public ModelAndView create(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("issue/create");
		return mav;
	}

}

package com.test.psk.history.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.psk.history.service.IssueHistoryServiceImpl;

@Controller
public class IssueHistoryController {

	@Autowired
	private IssueHistoryServiceImpl issueHistoryService;

	@RequestMapping(value = "/history/issue", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("history/issue");

		return mav;
	}
}

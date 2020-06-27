package com.test.psk.issue.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.psk.common.util.Common;
import com.test.psk.customer.service.CustomerServiceImpl;
import com.test.psk.customer.vo.CustomerVO;
import com.test.psk.history.vo.IssueHistoryVO;
import com.test.psk.issue.service.LicenseServiceImpl;
import com.test.psk.issue.vo.LicenseVO;
import com.test.psk.product.service.ProductServiceImpl;
import com.test.psk.product.vo.ProductVO;

@Controller
public class LicenseController {

	@Autowired
	private LicenseServiceImpl issueService;
	@Autowired
	private ProductServiceImpl productService;
	@Autowired
	private CustomerServiceImpl customerService;

	@RequestMapping(value = "/issueList", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("issueList");

		return mav;
	}

	@RequestMapping(value = "/issue/create", method = RequestMethod.GET)
	public ModelAndView create(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("products", productService.selectList(new ProductVO()));
		mav.addObject("customers", customerService.selectList(new CustomerVO()));

		mav.setViewName("issue/create");

		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/issue/license.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public String issue(LicenseVO licenseVo, IssueHistoryVO issueHistoryVo) {

		String result = issueService.issueLicense(licenseVo, issueHistoryVo);
		return Common.makeJsonData(result);
	}

	@ResponseBody
	@RequestMapping(value = "/issue/licenseFileDownload.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public void licenseFileDownload(Locale locale, Model model) {

	}

}

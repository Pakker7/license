package com.test.psk.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.psk.customer.mapper.CustomerMapper;
import com.test.psk.customer.vo.CustomerVO;

@Service
public class CustomerServiceImpl {

	@Autowired
	private CustomerMapper mapper;

	public List<CustomerVO> selectList(CustomerVO customerVo) {
		return mapper.selectList(customerVo);
	}

}

package com.test.psk.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.psk.product.mapper.ProductMapper;
import com.test.psk.product.vo.ProductVO;

@Service
public class ProductServiceImpl {

	@Autowired
	private ProductMapper mapper;

	public List<ProductVO> selectList(ProductVO productVo) {
		return mapper.selectList(productVo);
	}

	public ProductVO select(ProductVO productVo) {
		return mapper.select(productVo);
	}
}

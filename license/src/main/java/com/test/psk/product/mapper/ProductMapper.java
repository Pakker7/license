package com.test.psk.product.mapper;

import java.util.List;

import com.test.psk.common.service.Mapper;
import com.test.psk.product.vo.ProductVO;

@Mapper
public interface ProductMapper {

	public ProductVO select(ProductVO productVo);

	public List<ProductVO> selectList(ProductVO productVo);

	public Integer update(ProductVO productVo);

	public Integer delete(ProductVO productVo);
}

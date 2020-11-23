package com.test.psk.customer.mapper;

import java.util.List;

import com.test.psk.common.service.Mapper;
import com.test.psk.customer.vo.CustomerVO;

@Mapper
public interface CustomerMapper {

	public CustomerVO select(CustomerVO customerVo);

	public List<CustomerVO> selectList(CustomerVO customerVo);

	public Integer update(CustomerVO customerVo);

	public Integer delete(CustomerVO customerVo);

}

package com.test.psk.issue.mapper;

import java.util.List;

import com.test.psk.common.service.Mapper;
import com.test.psk.issue.vo.LicenseVO;

@Mapper
public interface LicenseMapper {

	public LicenseVO select(LicenseVO licenseVo);

	public List<LicenseVO> selectList(LicenseVO licenseVo);

	public Integer insert(LicenseVO licenseVo);

	public Integer update(LicenseVO licenseVo);

	public Integer delete(LicenseVO licenseVo);

}

package com.test.psk.history.mapper;

import java.util.List;

import com.test.psk.history.vo.DistributeHistoryVO;

public interface DistributeHistoryMapper {

	public List<DistributeHistoryVO> selectList(DistributeHistoryVO distributeHistoryVo);
}

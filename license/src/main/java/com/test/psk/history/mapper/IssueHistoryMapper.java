package com.test.psk.history.mapper;

import java.util.List;

import com.test.psk.common.service.Mapper;
import com.test.psk.history.vo.IssueHistoryVO;

@Mapper
public interface IssueHistoryMapper {

	public List<IssueHistoryVO> selectList(IssueHistoryVO issueHistoryVo);

	public Integer insert(IssueHistoryVO issueHistoryVo);

}

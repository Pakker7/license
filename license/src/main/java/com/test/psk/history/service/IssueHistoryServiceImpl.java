package com.test.psk.history.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.psk.history.mapper.IssueHistoryMapper;
import com.test.psk.history.vo.IssueHistoryVO;

@Service
public class IssueHistoryServiceImpl {

	@Autowired
	private IssueHistoryMapper mapper;

	public Integer insert(IssueHistoryVO issueHistoryVo) {
		return mapper.insert(issueHistoryVo);
	}

	public List<IssueHistoryVO> selectLIst(IssueHistoryVO issueHistoryVo) {
		return mapper.selectList(issueHistoryVo);
	}
}

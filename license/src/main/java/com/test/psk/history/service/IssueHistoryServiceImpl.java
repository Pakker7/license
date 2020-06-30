package com.test.psk.history.service;

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
}

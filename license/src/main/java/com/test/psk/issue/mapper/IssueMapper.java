package com.test.psk.issue.mapper;

import java.util.List;

import com.test.psk.issue.vo.IssueVO;

public interface IssueMapper {

	public IssueVO select(IssueVO issueVo);

	public List<IssueVO> selectList(IssueVO issueVo);

	public Integer update(IssueVO issueVo);

	public Integer delete(IssueVO issueVo);

}

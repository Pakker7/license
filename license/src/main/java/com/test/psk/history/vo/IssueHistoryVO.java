package com.test.psk.history.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IssueHistoryVO {

	private int idx;
	private int product_idx;
	private int license_idx;
	private int issuer_idx;
	private int customer_idx;
	private String issue_reason;
	private String issueStart;
	private String issueEnd;
	private Date issue_date;

}

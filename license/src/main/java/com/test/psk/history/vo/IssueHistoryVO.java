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
	private String issue_start;
	private String issue_end;
	private Date issue_date;

	private String version;
	private String id;
	private String product_name;
	private String issuer_name;
	private String company_name;
	private String customer_name;
	private String sign_data;
	private String license_issue_key;
	private String license_verify_key;

}

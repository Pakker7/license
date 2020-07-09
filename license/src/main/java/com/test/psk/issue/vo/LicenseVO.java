package com.test.psk.issue.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LicenseVO {

	private int idx;
	private int lisence_idx;
	private int product_idx;
	private String version;
	private String system_info;
	private String sign_data;
	private String license_issue_key;
	private String license_verify_key;
	private Date create_date;
	private String license_policy;
	private String issue_start;
	private String issue_end;

	private String productName;

	public String getLisencePolicyForCommandInput() {
		return issue_start + "~" + issue_end + "|" + productName;
	}

}

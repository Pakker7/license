package com.test.psk.customer.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerVO {

	private int idx;
	private String company_name;
	private String customer_name;
	private String phone;
	private Date create_date;
}

package com.test.psk.product.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {

	public ProductVO() {

	}

	public ProductVO(int idx) {
		this.idx = idx;
	}

	private int idx;
	private String name;
	private String version;
	private Date launch_date;
	private String sales_man;
	private String technical_man;

}

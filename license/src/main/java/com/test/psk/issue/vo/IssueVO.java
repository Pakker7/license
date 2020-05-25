package com.test.psk.issue.vo;

import java.util.Date;

public class IssueVO {

	private int IDX;
	private int PRODUCT_IDX;
	private int LICENSE_IDX;
	private int ISSUER_IDX;
	private int CUSTOMER_IDX;
	private Date CREATE_DATE;

	public int getIDX() {
		return IDX;
	}

	public void setIDX(int iDX) {
		IDX = iDX;
	}

	public int getPRODUCT_IDX() {
		return PRODUCT_IDX;
	}

	public void setPRODUCT_IDX(int pRODUCT_IDX) {
		PRODUCT_IDX = pRODUCT_IDX;
	}

	public int getLICENSE_IDX() {
		return LICENSE_IDX;
	}

	public void setLICENSE_IDX(int lICENSE_IDX) {
		LICENSE_IDX = lICENSE_IDX;
	}

	public int getISSUER_IDX() {
		return ISSUER_IDX;
	}

	public void setISSUER_IDX(int iSSUER_IDX) {
		ISSUER_IDX = iSSUER_IDX;
	}

	public int getCUSTOMER_IDX() {
		return CUSTOMER_IDX;
	}

	public void setCUSTOMER_IDX(int cUSTOMER_IDX) {
		CUSTOMER_IDX = cUSTOMER_IDX;
	}

	public Date getCREATE_DATE() {
		return CREATE_DATE;
	}

	public void setCREATE_DATE(Date cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}

	@Override
	public String toString() {
		return "IssueVO [IDX=" + IDX + ", PRODUCT_IDX=" + PRODUCT_IDX + ", LICENSE_IDX=" + LICENSE_IDX + ", ISSUER_IDX="
				+ ISSUER_IDX + ", CUSTOMER_IDX=" + CUSTOMER_IDX + ", CREATE_DATE=" + CREATE_DATE + "]";
	}

}

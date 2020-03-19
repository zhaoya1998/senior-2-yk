package com.zhaoya.domain;

public class Vo {

	private String startPrice;
	private String endPrice;
	
	private String startDate;
	private String endDate;
	
	private String cname;
	
	private String status;
	
	private String tid;

	public String getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(String startPrice) {
		this.startPrice = startPrice;
	}

	public String getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(String endPrice) {
		this.endPrice = endPrice;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Vo(String startPrice, String endPrice, String startDate, String endDate, String cname, String status,
			String tid) {
		super();
		this.startPrice = startPrice;
		this.endPrice = endPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cname = cname;
		this.status = status;
		this.tid = tid;
	}

	public Vo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

package com.zhaoya.domain;

import java.io.Serializable;

public class Car implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer cid;
	private String cname;
	private String status;
	private String date;
	private String price;
	private String pic;
	private String tid;
	
	private Type type;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Car(Integer cid, String cname, String status, String date, String price, String pic, String tid, Type type) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.status = status;
		this.date = date;
		this.price = price;
		this.pic = pic;
		this.tid = tid;
		this.type = type;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}

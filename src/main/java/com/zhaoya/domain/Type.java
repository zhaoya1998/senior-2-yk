package com.zhaoya.domain;

import java.io.Serializable;

public class Type implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer tid;
	private String tname;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Type(Integer tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

package com.example.trade.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "URL")
public class URLModel {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	
	@Column
	private String short_url;
	@Column
	private String long_url;
	@Column
	private Integer count;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getShort_url() {
		return short_url;
	}
	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}
	public String getLong_url() {
		return long_url;
	}
	public void setLong_url(String long_url) {
		this.long_url = long_url;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}

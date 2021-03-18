package com.example.trade.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "trade_entries")
public class Trade {

	@Id
	@Column(name="trade_id")
	private String trade_id;
	
	@Column(name="version")
	private int version;
	
	@Column(name="counter_party_id")
	private String counter_party_id;
	
	@Column(name="book_id")
	private String book_id;
	
	
	@Column(name="maturity_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date maturity_date;
	
	@Column(name="creation_date")
	private Date creation_date;
	
	@Column(name="expired")
	private boolean expired;


	public String getTrade_id() {
		return trade_id;
	}

	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}


	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCounter_party_id() {
		return counter_party_id;
	}

	public void setCounter_party_id(String counter_party_id) {
		this.counter_party_id = counter_party_id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public Date getMaturity_date() {
		return maturity_date;
	}

	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}
}

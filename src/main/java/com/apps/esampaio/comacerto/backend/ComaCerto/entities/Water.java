package com.apps.esampaio.comacerto.backend.ComaCerto.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Water {
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dateAndTime;
	private Integer quantity;
	private Integer id;
	
	public Date getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}

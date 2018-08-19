package com.apps.esampaio.comacerto.backend.ComaCerto.entities;

public class Food {
	private String name;
	private String category;
	private Integer portion;
	
	public Food() {
		
	}
	public Food(String name, String category) {
		this(name,category,null);
	}
	public Food(String name, String category, Integer portion) {
		super();
		this.name = name;
		this.category = category;
		this.portion = portion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPortion() {
		return portion;
	}
	public void setPortion(Integer portion) {
		this.portion = portion;
	}
	
	
	
}

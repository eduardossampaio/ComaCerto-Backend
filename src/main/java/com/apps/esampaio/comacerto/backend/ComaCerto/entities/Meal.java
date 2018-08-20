package com.apps.esampaio.comacerto.backend.ComaCerto.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Meal {
	private String mealType;
	private Date hour;
	private List<Food> foods;
	private Integer hunger;
	private Integer satiety;
	private String feeling;
	
	
	public Meal() {
		
	}
	
	public Meal(String mealType, Date hour, List<Food> foods, Integer hunger, Integer satiety, String feeling) {
		super();
		this.mealType = mealType;
		this.hour = hour;
		this.foods = foods;
		this.hunger = hunger;
		this.satiety = satiety;
		this.feeling = feeling;
	}
	
	public void addFood(String foodName,int portion) {
		if ( foods ==null) {
			foods = new ArrayList<Food>();
		}
		foods.add(new Food(foodName, "", portion));
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public void setHour(Date hour) {
		this.hour = hour;
	}
	public Date getHour() {
		return hour;
	}
	public List<Food> getFoods() {
		return foods;
	}
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	public Integer getHunger() {
		return hunger;
	}
	public void setHunger(Integer hunger) {
		this.hunger = hunger;
	}
	public Integer getSatiety() {
		return satiety;
	}
	public void setSatiety(Integer satiety) {
		this.satiety = satiety;
	}
	public String getFeeling() {
		return feeling;
	}
	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}
	
	

}

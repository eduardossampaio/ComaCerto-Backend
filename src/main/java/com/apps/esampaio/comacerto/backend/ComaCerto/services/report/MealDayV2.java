package com.apps.esampaio.comacerto.backend.ComaCerto.services.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

import com.apps.esampaio.comacerto.backend.ComaCerto.entities.Meal;
import com.apps.esampaio.comacerto.backend.ComaCerto.entities.Water;

public class MealDayV2 implements Comparable<MealDayV2>{
	private Date date;
	private List<Meal> meals;
	private List<Water> waters;
	
	public MealDayV2(Date date) {
		super();
		this.date = date;
		this.meals = new ArrayList<Meal>();
		this.waters = new ArrayList<Water>();
	}
	
	public void addMeal(Meal meal) {
		meals.add(meal);
	}
	public void addWater(Water water) {
		waters.add(water);
	}
	
	public boolean belongsTo(Meal meal) {
		return DateUtils.isSameDay(date, meal.getDateAndTime());
	}
	public boolean belongsTo(Water water) {
		return DateUtils.isSameDay(date, water.getDateAndTime());
	}

	public List<Meal> getMeals() {
		return meals;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Water> getWaters() {
		return waters;
	}
	public void setWaters(List<Water> waters) {
		this.waters = waters;
	}

	@Override
	public int compareTo(MealDayV2 o) {		
		return (int) ( this.date.getTime() - o.getDate().getTime() );
	}
	
}

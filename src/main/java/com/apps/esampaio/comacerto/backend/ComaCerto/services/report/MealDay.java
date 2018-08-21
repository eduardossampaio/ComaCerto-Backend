package com.apps.esampaio.comacerto.backend.ComaCerto.services.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

import com.apps.esampaio.comacerto.backend.ComaCerto.entities.Meal;

public class MealDay {
	private Date date;
	private List<Meal> meals;
	
	public MealDay(Date date) {
		super();
		this.date = date;
		this.meals = new ArrayList<Meal>();
	}
	
	public void addMeal(Meal meal) {
		meals.add(meal);
	}
	public boolean belongsTo(Meal meal) {
		return DateUtils.isSameDay(date, meal.getDateAndTime());
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
	
	
}

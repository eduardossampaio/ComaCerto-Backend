package com.apps.esampaio.comacerto.backend.ComaCerto.controllers.report;

import java.util.Date;
import java.util.List;

import com.apps.esampaio.comacerto.backend.ComaCerto.entities.Meal;

public class GenerateMealReportRequest {
	private Date initialDate;
	private Date finalDate;
	private List<Meal> meals;
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	public List<Meal> getMeals() {
		return meals;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	
	
	
}

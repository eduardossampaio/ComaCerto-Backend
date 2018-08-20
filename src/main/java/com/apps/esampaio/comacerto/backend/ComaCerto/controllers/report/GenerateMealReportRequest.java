package com.apps.esampaio.comacerto.backend.ComaCerto.controllers.report;

import java.util.List;

import com.apps.esampaio.comacerto.backend.ComaCerto.entities.Meal;

public class GenerateMealReportRequest {
	private String initialDate;
	private String finalDate;
	public String getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}
	public String getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}
	public List<Meal> getMeals() {
		return meals;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	private List<Meal> meals;
	
	
	
}

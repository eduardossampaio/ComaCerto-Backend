package com.apps.esampaio.comacerto.backend.ComaCerto.services.report;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apps.esampaio.comacerto.backend.ComaCerto.entities.Meal;
import com.apps.esampaio.comacerto.backend.ComaCerto.entities.Water;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportService {
	
	private File pathToReportPackage;
	
	//Recupera os caminhos para que a classe possa encontrar os relatórios
	public ReportService(String version) {
		this.pathToReportPackage = new File("jasper/"+version);
	}
	
	public ByteArrayOutputStream generateMealReport(List<Meal> meals,Date initialDate,Date finalDate) throws Exception {
		
		List<MealDay> allMealsGrouped = group(meals);
		JasperReport report = JasperCompileManager.compileReport(new File(pathToReportPackage, "meal.jrxml").getAbsolutePath());
		Map<String,Object> parametros = new HashMap<String,Object>();
		parametros.put("INITIAL_DATE", initialDate);
		parametros.put("FINAL_DATE", finalDate);
		parametros.put("SUBREPORT_DIR", pathToReportPackage.getAbsolutePath()+"/");
		JasperPrint print = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(allMealsGrouped));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		JasperExportManager.exportReportToPdfStream(print, outputStream);
		return outputStream;
	}
	
public ByteArrayOutputStream generateMealReportV2(List<Meal> meals,List<Water> waters,Date initialDate,Date finalDate) throws Exception {
		
		List<MealDayV2> allMealsGrouped = groupV2(meals, waters);
		JasperReport report = JasperCompileManager.compileReport(new File(pathToReportPackage, "meal.jrxml").getAbsolutePath());
		Map<String,Object> parametros = new HashMap<String,Object>();
		parametros.put("INITIAL_DATE", initialDate);
		parametros.put("FINAL_DATE", finalDate);
		parametros.put("SUBREPORT_DIR", pathToReportPackage.getAbsolutePath()+"/");
		JasperPrint print = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(allMealsGrouped));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		JasperExportManager.exportReportToPdfStream(print, outputStream);
		return outputStream;
	}

	private List<MealDay> group(List<Meal> meals) {
		List<MealDay> allMealsGrouped = new ArrayList<MealDay>();
		
		for (Meal meal : meals) {
			boolean found = false;
			for (MealDay mealReport : allMealsGrouped) {
				if ( mealReport.belongsTo(meal)) {
					found = true;
					mealReport.addMeal(meal);
				}
			}
			if( ! found) {
				MealDay mealReport  = new MealDay(meal.getDateAndTime());
				mealReport.addMeal(meal);
				allMealsGrouped.add(mealReport);
			}
			
		}
		return allMealsGrouped;
	}
	
	private List<MealDayV2> groupV2(List<Meal> meals,List<Water> waters) {
		List<MealDayV2> allMealsGrouped = new ArrayList<MealDayV2>();
		
		for (Meal meal : meals) {
			boolean found = false;
			for (MealDayV2 mealReport : allMealsGrouped) {
				if ( mealReport.belongsTo(meal)) {
					found = true;
					mealReport.addMeal(meal);
				}
			}
			if( ! found) {
				MealDayV2 mealReport  = new MealDayV2(meal.getDateAndTime());
				mealReport.addMeal(meal);
				allMealsGrouped.add(mealReport);
			}
			
		}
		
		for (Water water : waters) {
			boolean found = false;
			for (MealDayV2 mealReport : allMealsGrouped) {
				if ( mealReport.belongsTo(water)) {
					found = true;
					mealReport.addWater(water);
				}
			}
			if( ! found) {
				MealDayV2 mealReport  = new MealDayV2(water.getDateAndTime());
				mealReport.addWater(water);
				allMealsGrouped.add(mealReport);
			}
			
		}
		Collections.sort(allMealsGrouped);
		return allMealsGrouped;
	}
}

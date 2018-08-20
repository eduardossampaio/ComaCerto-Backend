package com.apps.esampaio.comacerto.backend.ComaCerto.services.report;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apps.esampaio.comacerto.backend.ComaCerto.entities.Meal;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportService {
	
	public ByteArrayOutputStream generateMealReport(List<Meal> meals,Date initialDate,Date finalDate) throws Exception {
		
		List<MealDay> allMealsGrouped = group(meals);
		JasperReport report = JasperCompileManager.compileReport("/Users/eduardosoares/coma certo/meal.jrxml");
		Map<String,Object> parametros = new HashMap<String,Object>();
		parametros.put("INITIAL_DATE", initialDate);
		parametros.put("FINAL_DATE", finalDate);
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
				MealDay mealReport  = new MealDay(meal.getHour());
				mealReport.addMeal(meal);
				allMealsGrouped.add(mealReport);
			}
			
		}
		return allMealsGrouped;
	}
}

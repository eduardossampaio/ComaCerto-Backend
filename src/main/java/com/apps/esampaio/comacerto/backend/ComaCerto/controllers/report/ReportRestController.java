package com.apps.esampaio.comacerto.backend.ComaCerto.controllers.report;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apps.esampaio.comacerto.backend.ComaCerto.entities.Meal;
import com.apps.esampaio.comacerto.backend.ComaCerto.services.report.ReportService;
import com.apps.esampaio.comacerto.backend.ComaCerto.util.DateUtil;

@RestController
@RequestMapping("/reports")
public class ReportRestController {
	
	
	
	@RequestMapping(path="/meals",method = RequestMethod.POST, produces = "application/pdf")
	public byte[] generateMealReport(@RequestBody GenerateMealReportRequest request ) throws Exception {
		System.out.println("Gerando relatórios");
		Date initialDate = DateUtil.dateForFormat(request.getInitialDate());
		Date finalDate = DateUtil.dateForFormat(request.getFinalDate());
		ByteArrayOutputStream resultStream = new ReportService().generateMealReport(request.getMeals(), initialDate, finalDate );
		return resultStream.toByteArray();
	}
	
	@RequestMapping(path="/getMeals",method = RequestMethod.GET)
	public List<Meal> getMeals() throws ParseException {
		List<Meal> meals = new ArrayList<Meal>();
		
		//dia 01
		Meal cafe1 = new Meal();
		cafe1.setMealType("Café da Manha");
		cafe1.setHour(DateUtil.hourForFormat("10:00"));
		cafe1.setFeeling("Feliz");
		cafe1.setHunger(5);
		cafe1.setSatiety(5);
		cafe1.addFood("Pão com manteiga", 1);
		cafe1.addFood("leite ",1);
		cafe1.addFood("biscoito",5);
		
		Meal almoco1 = new Meal();
		almoco1.setMealType("Almoco");
		almoco1.setHour(DateUtil.hourForFormat("13:00"));
		almoco1.setFeeling("Pressa");
		almoco1.setHunger(3);
		almoco1.setSatiety(4);
		almoco1.addFood("Arroz", 1);
		almoco1.addFood("Feijão ",1);
		almoco1.addFood("Carne",3);
		almoco1.addFood("Macarrão",3);
		almoco1.addFood("Ovo",3);
		
		
		Meal lanche1 = new Meal();
		lanche1.setMealType("Lanche");
		lanche1.setHour(DateUtil.hourForFormat("16:00"));
		lanche1.setFeeling("Anstioso");
		lanche1.setHunger(1);
		lanche1.setSatiety(1);
		lanche1.addFood("suco",1);
		lanche1.addFood("maça",1);
		
		
		Meal janta1 = new Meal();
		janta1.setMealType("Janta");
		janta1.setHour(DateUtil.hourForFormat("20:00"));
		janta1.setFeeling("Cansado");
		janta1.setHunger(5);
		janta1.setSatiety(2);
		janta1.addFood("pão com manteiga",1);
		janta1.addFood("leite",1);
		
		
		//dia 02
		Meal cafe2 = new Meal();
		cafe2.setMealType("Café da Manha");
		cafe2.setHour(DateUtil.hourForFormat("10:00"));
		cafe2.setFeeling("Feliz");
		cafe2.setHunger(5);
		cafe2.setSatiety(5);
		cafe2.addFood("Pão com manteiga", 1);
		cafe2.addFood("café ",1);
		cafe2.addFood("batata frita",5);
		cafe2.addFood("bacon frita",5);
		
		Meal almoco2 = new Meal();
		almoco2.setMealType("Almoco");
		almoco2.setHour(DateUtil.hourForFormat("13:00"));
		almoco2.setFeeling("Ansioso");
		almoco2.setHunger(3);
		almoco2.setSatiety(4);
		almoco2.addFood("Arroz", 1);
		almoco2.addFood("Feijão ",1);
		almoco2.addFood("Carne",3);
		almoco2.addFood("Linguica",3);
		almoco2.addFood("Bacon",3);
		almoco2.addFood("Frango assado",3);
		almoco2.addFood("Couve",3);
		almoco2.addFood("Abacaxi",3);
		
		
		Meal lanche2 = new Meal();
		lanche2.setMealType("Lanche");
		lanche2.setHour(DateUtil.hourForFormat("16:00"));
		lanche2.setFeeling("Cansado");
		lanche2.setHunger(1);
		lanche2.setSatiety(1);
		lanche2.addFood("Refrigerante",1);
		lanche2.addFood("Salgado",3);
		lanche2.addFood("Café",3);
		
		
		Meal janta2 = new Meal();
		janta2.setMealType("Janta");
		janta2.setHour(DateUtil.hourForFormat("20:00"));
		janta2.setFeeling("Cansado");
		janta2.setHunger(5);
		janta2.setSatiety(2);
		janta2.addFood("pão com manteiga",1);
		janta2.addFood("leite",1);

		List<Meal> meals1 = new ArrayList<Meal>();
		meals1.add(cafe1);
		meals1.add(almoco1);
		meals1.add(lanche1);
		meals1.add(janta1);
		
		List<Meal> meals2 = new ArrayList<Meal>();
		meals2.add(cafe2);
		meals2.add(almoco2);
		meals2.add(lanche2);
		meals2.add(janta2);
		meals.addAll(meals1);
		meals.addAll(meals2);
		return meals;
	}
	
} 
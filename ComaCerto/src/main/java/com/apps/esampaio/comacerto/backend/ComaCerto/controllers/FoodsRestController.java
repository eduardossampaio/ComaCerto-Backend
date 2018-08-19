package com.apps.esampaio.comacerto.backend.ComaCerto.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apps.esampaio.comacerto.backend.ComaCerto.entities.Food;

@RestController
@RequestMapping("/foods")
public class FoodsRestController {
	
	@RequestMapping(path="/getAll",method = RequestMethod.GET)
	public List<Food> getAllFoods() {
		List<Food> foods = new ArrayList<>();
		foods.add(new Food("Arroz", "Comidas"));
		foods.add(new Food("Feijão", "Comidas"));
		foods.add(new Food("Carne", "Comidas"));
		
		return foods;
	}
}

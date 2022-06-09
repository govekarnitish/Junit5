package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DietPlannerTest {
	
	private DietPlanner dietPlanner;
	
	@BeforeEach
	void setup() {
		this.dietPlanner = new DietPlanner(20, 30, 50);
	}

	@AfterEach
	void afterEach() {
		System.out.println("A unit test was finished");
	}
	
	@Test
	void should_ReturnCorrectDietPlan_WhenCorrectCoder() {
		//given 
		Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
		DietPlan expectedDietPlan = new DietPlan(2202, 110, 73, 275);
		
		//when 
		DietPlan actual = dietPlanner.calculateDiet(coder);
		
		//then
		
		assertAll(
				()-> assertEquals(expectedDietPlan.getCalories(), actual.getCalories()),
				()-> assertEquals(expectedDietPlan.getCarbohydrate(), actual.getCarbohydrate()),
				()-> assertEquals(expectedDietPlan.getFat(), actual.getFat()),
				()-> assertEquals(expectedDietPlan.getProtein(), actual.getProtein())
				);
	}

}

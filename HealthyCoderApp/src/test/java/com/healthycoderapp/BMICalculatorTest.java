package com.healthycoderapp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class BMICalculatorTest {

	@Test
	void should_RetrunTrue_When_DietRecommended() {
	
		//given 
		double weight = 89.0;
		double height = 1.72;
		//when
		boolean recommended = BMICalculator.isDietRecommended(weight, height);
		//then 
		assertTrue(recommended);
	}

	
	@Test
	void should_RetrunFalse_When_DietNotRecommended() {
	
		//given 
		double weight = 50.0;
		double height = 1.92;
		//when
		boolean recommended = BMICalculator.isDietRecommended(weight, height);
		//then 
		assertFalse(recommended);
	}
}

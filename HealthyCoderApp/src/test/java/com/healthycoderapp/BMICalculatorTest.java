package com.healthycoderapp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
	
	@Test
	void should_ThrowArithmaticException_When_HeightIsZero() {
	
		//given 
		double weight = 50.0;
		double height = 0.0;
		//when
		Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
		//then 
		assertThrows(ArithmeticException.class, executable);
	}
	
	@Test
	void should_ReturnCoderWithWorstBMI_When_CoderListIsNotEmpty() {
		//given 
		List<Coder>  coderList = new ArrayList<Coder>();
		coderList.add(new Coder(1.80, 60));
		coderList.add(new Coder(1.82, 98));
		coderList.add(new Coder(1.83, 64.7));
		
		//when
		Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);
		
		//then
		assertAll( 
		()->assertEquals(1.82, coderWorstBMI.getHeight()),
		()->assertEquals(98, coderWorstBMI.getWeight()));
	}
}

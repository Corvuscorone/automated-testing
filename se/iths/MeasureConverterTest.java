package se.iths;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeasureConverterTest {
	
	//why do MC use int not float?

	protected MeasureConverter mc = new MeasureConverter();

	@Test
	public void testconvertWeightTrue(){
		boolean tometric = true;
		int value = 1;
		assertEquals(0, mc.convertWeight(value, tometric));
	}
	
	@Test
	public void testconvertWeightFalse(){
		boolean tometric = false;
		int value = 1;
		assertEquals(2, mc.convertWeight(value, tometric));
	}
	
	@Test
	public void testConvertToFeet(){
		assertEquals(1, mc.convertToFeet(31));
	}
}

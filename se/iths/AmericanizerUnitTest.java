package se.iths;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AmericanizerUnitTest {

	protected static Americanizer am;
	
	@Before
	public void before(){
		am = new Americanizer();
	}

	@Test
	public void testConverTime() {
		
		int hours = 2;
		TimeConverter tc = Mockito.mock(TimeConverter.class);
		am.setTimeConverter(tc);
		Mockito.when(tc.getMeridiem(hours)).thenReturn("AM");

		
		assertEquals(hours+" "+"AM", am.convertTime(hours));
	}
	
	@Test
	public void testConvertToPound(){
		int value = 30;
		boolean tometric = true;
		MeasureConverter mc = Mockito.mock(MeasureConverter.class);
		am.setWeightConverter(mc);
		Mockito.when(mc.convertWeight(value, tometric)).thenReturn(1);
		
		assertEquals(1,am.convertToPound(value));
	}
	
	@Test
	public void testConvertToFeet(){
		int cm =31;
		
		MeasureConverter mc = Mockito.mock(MeasureConverter.class);
		am.setWeightConverter(mc);
		Mockito.when(mc.convertToFeet(cm)).thenReturn(1);
		
		assertEquals(1,am.convertToFeet(cm));
	}

}

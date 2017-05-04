package se.iths;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AmericanizerTest {

	protected static Americanizer am = new Americanizer();
	protected static MeasureConverter mc = new MeasureConverter();
	protected static TimeConverter tc = new TimeConverter();
	
	@Before
	public void before(){
		am.setTimeConverter(tc);
		am.setWeightConverter(mc);
	}
	
	@Test(expected=NullPointerException.class)
	public void testSetWeightConverterToNull() {
		am.setWeightConverter(null);
		am.convertToPound(3);
	}
	
	@Test
	public void testConvertTime(){
		int hours = 2;
		String s = hours+" "+tc.getMeridiem(hours);
		assertEquals(s, am.convertTime(hours));
	}
	
	@Test
	public void testConvertToPound(){
		int value = 30;
		boolean tometric = true;
		int i = mc.convertWeight(value, tometric);
		int j = am.convertToPound(value);
		assertEquals(i,j);
	}

	@Test
	public void testConvertSpeach(){
		String sentence = "";
		assertEquals("yo dude!" + sentence + ", you know?", am.convertSpeach(sentence));
	}
	
	@Test
	public void testConvertToFeet(){
		int cm =31;
		int i = mc.convertToFeet(cm);
		int j = am.convertToFeet(cm);
		assertEquals(i,j);
	}
}

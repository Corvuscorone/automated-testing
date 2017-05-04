package se.iths;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeConverterTest {
	
	protected TimeConverter tm = new TimeConverter();

	@Test
	public void testPMGetMeridiem() {
		assertEquals("PM", tm.getMeridiem(12));
	}
	
	@Test
	public void testAMGetMeridiem() {
		assertEquals("AM", tm.getMeridiem(11));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLowerRangeGetMeridiem(){
		tm.getMeridiem(-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUpperRangeGetMeridiem(){
		tm.getMeridiem(24);
	}

}

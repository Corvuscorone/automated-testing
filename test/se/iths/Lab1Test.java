package se.iths;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.lang.ArithmeticException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Lab1Test {
	
	protected Lab1 lab1 = new Lab1();
	static int counter = 0;
	static ArrayList<String> quotes = new ArrayList<String>();
	
	@BeforeClass
	public static void start(){
        System.out.println("@Before - runBeforeTestMethod");
        quotes.add("We cannot solve our problems with the same thinking we used when we created them. - Albert Einstein");
		quotes.add("A fool thinks himself to be wise, but a wise man knows himself to be a fool. - William Shakespeare");
		quotes.add("You must be the change you wish to see in the world. - Mahatma Gandhi");
		quotes.add("In the End, we will remember not the words of our enemies, but the silence of our friends. - Martin Luther King, Jr.");
		quotes.add("Choose a job you love, and you will never have to work a day in your life. - Confucius");
		quotes.add("To expect the unexpected shows a thoroughly modern intellect. - Oscar Wilde");
		quotes.add("Without music, life would be a mistake. - Friedrich Nietzsche");
		quotes.add("I love deadlines. I like the whooshing sound they make as they fly by. - Douglas Adams");
    }
	
//	@After
//	public void after(){
//		counter++;
//	}

	@Test
	@Category(MathTest.class)
	public void testAdd(){
		counter++;
		assertEquals(lab1.add(1,2), 3);
	}
	
	@Test
	@Category(MathTest.class)
	public void testSubtract(){
		counter++;
		assertEquals(lab1.subtract(3, 2), 1);
	}

	@Test
	@Category(MathTest.class)
	public void testMultiply(){
		counter++;
		assertEquals(lab1.multiply(3, 2), 6);
	}
	
	@Test
	@Category(MathTest.class)
	public void testMultiplyNegative(){
		counter++;
		assertEquals(lab1.multiply(3, -2), -6);
	}
	
	@Test
	@Category(MathTest.class)
	public void testMultiplyDoubleNegative(){
		assertEquals(lab1.multiply(-3, -2), 6);
		counter++;
	}
	
	@Test
	@Category(MathTest.class)
	public void testDivide(){
		assertEquals(lab1.divide(6, 2), 3);
		counter++;
	}
	
	@Test
	@Category(MathTest.class)
	public void testDivideNegative(){
		assertEquals(lab1.divide(6, -2), -3);
		counter++;
	}
	
	@Test(expected = ArithmeticException.class)
	@Category(MathTest.class)
	public void testDivideByZero(){
		counter++;
		lab1.divide(2, 0);
	}
	
	@Test
	public void testReverse(){
		counter++;
		assertEquals(lab1.reverse("Hello World!"), "!dlroW olleH");
	}
	
	@Test
	public void reverseEmpty(){
		counter++;
		assertEquals(lab1.reverse(""), "");
	}
	
	@Test
	public void testQuoteContains(){
		counter++;
		assertTrue(quotes.contains(lab1.quote()));
	}
	
	@Test
	public void testQuoteNotContains(){
		counter++;
		assertFalse(!quotes.contains(lab1.quote()));
	}
	
	@Test
	public void testQuoteAppears(){
		while(!quotes.isEmpty()){
			counter++;
			quotes.remove(lab1.quote());
		}
		//counter--; //Compensating for the @After addition to counter
		assertEquals(quotes.size(), 0);
	}
	
	@Test
	public void testGetCounter(){
		int oldCounter = counter;
		counter = 0;
		testAdd();
		testSubtract();
		testMultiply();
		assertEquals(lab1.getCounter(), counter+oldCounter);
	}
}

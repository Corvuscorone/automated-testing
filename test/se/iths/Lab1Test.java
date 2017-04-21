package se.iths;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.lang.ArithmeticException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Lab1Test {
	
	protected Lab1 lab1 = new Lab1();
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
	

	@Test
	@Category(MathTest.class)
	public void testAdd(){
		assertEquals(lab1.add(1,2), 3);
	}
	
	@Test
	@Category(MathTest.class)
	public void testSubtract(){
		assertEquals(lab1.subtract(3, 2), 1);
	}

	@Test
	@Category(MathTest.class)
	public void testMultiply(){
		assertEquals(lab1.multiply(3, 2), 6);
	}
	
	@Test
	@Category(MathTest.class)
	public void testMultiplyNegative(){
		assertEquals(lab1.multiply(3, -2), -6);
	}
	
	@Test
	@Category(MathTest.class)
	public void testMultiplyDoubleNegative(){
		assertEquals(lab1.multiply(-3, -2), 6);
	}
	
	@Test
	@Category(MathTest.class)
	public void testDivide(){
		assertEquals(lab1.divide(6, 2), 3);
	}
	
	@Test
	@Category(MathTest.class)
	public void testDivideNegative(){
		assertEquals(lab1.divide(6, -2), -3);
	}
	
	@Test(expected = ArithmeticException.class)
	@Category(MathTest.class)
	public void testDivideByZero(){
		lab1.divide(2, 0);
	}
	
	@Test
	public void testReverse(){
		assertEquals(lab1.reverse("Hello World!"), "!dlroW olleH");
	}
	
	@Test
	public void testReverseEmpty(){
		assertEquals(lab1.reverse(""), "");
	}
	
	@Test
	public void testQuoteContains(){
		assertTrue(quotes.contains(lab1.quote()));
	}
	
	@Test
	public void testQuoteNotContains(){
		assertFalse(!quotes.contains(lab1.quote()));
	}
	
	@Test
	public void testQuoteAppears(){
		ArrayList<String> quotesCopy = new ArrayList<String>(quotes);
		while(!quotesCopy.isEmpty()){
			String s = lab1.quote();
			quotesCopy.remove(s);
		}
		assertEquals(quotesCopy.size(), 0);
	}
	
	@Test
	public void testGetCounter(){
		int oldCounter = lab1.getCounter();
		lab1.add(1, 2);
		lab1.divide(10, 2);
		lab1.multiply(3, 3);
		lab1.subtract(10, 2);
		lab1.reverse("hej");
		lab1.quote();
		assertEquals(lab1.getCounter(), oldCounter+6);
	}
}

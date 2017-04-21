package se.iths;

import static org.junit.Assert.*;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)  
@IncludeCategory(MathTest.class)  
@SuiteClasses({ Lab1Test.class})  

public class Lab1TestCategory {

	public static void main (String args[]){
		
	}
}
package test;

import org.testng.annotations.Test;

public class TestCase2 {
	
	@Test(priority=1,groups= {"Regression"})
	public void Logintest2()
	{
		System.out.println("Logintest2");
	}
	
	@Test(priority=0,description="Signup functionality",groups= {"Regression"})
	public void Signuptest()
	{
		System.out.println("Signuptest");
	}
	
	@Test(dependsOnMethods="Signuptest",groups= {"Regression"})
	public void Homepage()
	{
		System.out.println("Homepage");
	}
	
	

}

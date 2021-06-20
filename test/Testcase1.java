package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 {
	
	@BeforeTest
	public void Beforetest()
	{
		System.out.println("Before Test");
	}
	
	@BeforeMethod
	public void Beforemethod()
	{
		System.out.println("BeforeMethod");
	}
	
	@Test(groups= {"Regression"})
	public void Logintest()
	{
		System.out.println("Logintest");
	}
	
	@Test(groups= {"Smoke"})
	public void Signuptest()
	{
		System.out.println("Signuptest");
	}
	
	@Test
	public void Loginout()
	{
		System.out.println("Loginout");
	}
	
	@AfterMethod
	public void Aftermethod()
	{
		System.out.println("AfterMethod");
	}
	
	@Test
	public void Logout()
	{
		System.out.println("Logout");
	}
}

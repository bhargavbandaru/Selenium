package com.selenium.test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgAnns {


	@BeforeClass
	public void openapp()
	{
		System.out.println("beforeclass");	
	}
	@AfterClass
	public void closeapp()
	{
		System.out.println("afterclass");	
	}
	@BeforeMethod
	public void login()
	{
		System.out.println("beforemethod");	
	}
	@AfterMethod
	public void logout()
	{
		System.out.println("aftermethod");	
	}
	@Test()
	public void BA()
	{
		System.out.println("test1");	
	}
	@Test(enabled=true)
	public void MT()
	{
		System.out.println("test2");	
	}
	@Test(enabled=false)
	public void WD()
	{
		System.out.println("test3");	
	}

}


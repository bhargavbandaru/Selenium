package com.selenium.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviderExample {
     
	@DataProvider
	public Object[][]supplydata()
	{
		
	Object[][] data=new Object[4][2];
	data[0][0]="srikanth";
	data[0][1]=30;
	data[1][0]="srihari";
	data[1][1]=31;
	data[2][0]="sridhar";
	data[2][1]=32;
	data[3][0]="srinu";
	data[3][1]=33;
	return data;
	}
	
	@Test(dataProvider="supplydata")
	public void empcreation(String ename,int eage)
	{
		System.out.println("My name is "+ename+"  age is " +eage);
				
	}

}

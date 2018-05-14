package com.selenium.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromProp {


        @Test
		public void readelement() throws IOException{
			 FileInputStream fi=new FileInputStream("D:\\Users\\bhargav\\workspace32\\Seleniumexplore\\ReadProperties.Properties");
			 Properties p=new Properties();
			 p.load(fi);
			String userName = p.getProperty("UserName");
			String psword = p.getProperty("Password");
			System.out.println(userName);
			System.out.println(psword);
			
			// return property;
			}
		
	}


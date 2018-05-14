package com.selenium.test;

import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class ExcelRead

{
	@Test        
	public static void excelread() throws BiffException, IOException

	{

		FileInputStream fis = new FileInputStream("D:\\Users\\bhargav\\workspace32\\Seleniumexplore\\Bhargav.xls");
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet s = wb.getSheet(0);
        String s1 = s.getCell(1, 0).getContents();
        //s.getCell(0, i).getContents()
		System.out.println("Test data is"+ s1);
		// return s1;
		

	}
}
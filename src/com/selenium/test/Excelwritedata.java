package com.selenium.test;

import java.io.FileOutputStream;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.Test;

public class Excelwritedata {


		@Test
		public void WritingData() throws IOException, RowsExceededException, WriteException
		{

			FileOutputStream fos = new FileOutputStream ("D:\\Users\\bhargav\\workspace32\\Seleniumexplore\\Bhargav11.xls");

			WritableWorkbook wo = Workbook.createWorkbook(fos);
		   	WritableSheet sh = wo.createSheet("bhargav",0);
			Label cellcontent = new Label(0,0,"Team");
			sh.addCell(cellcontent);
			wo.write();
			wo.close();
		}

	}


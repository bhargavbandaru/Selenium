package com.selenium.test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {


	public static void main(String[] args) throws IOException
	{
		File f=new File("D:\\Users\\bhargav\\workspace32\\Seleniumexplore\\Bhargav.txt") ;
		try {
			f.createNewFile() ;
			FileWriter fw=new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write("hi how are you");
			bw.newLine();
			bw.write("I am fine");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

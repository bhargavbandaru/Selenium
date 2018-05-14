package com.selenium.test;
class xyz
{
	xyz()
	{
		display(10,20);
	}
	xyz(int a,int b)
	{
		this();
	}
	int a=10;
	int b=20;
	void display(int a,int b)
	{
		System.out.println(this.a);
		System.out.println(b);
	}
	void m()
	{
		
	}
}
public class ThisEx {
	public static void main(String args[]){
		//int a=0;int b=0;
		
		
		xyz t=new xyz();
		t.display(30,50);
	}
}

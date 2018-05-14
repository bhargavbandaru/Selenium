package com.selenium.test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ClickAllLink
{

	public static WebDriver driver;

	@Test(description = "Extract all Links and click all links ")

	public static void clickAllLinks()

	{

		driver = new FirefoxDriver();
		//driver.get("https://www.google.co.in/?gfe_rd=cr&ei=4Hz1VKuWHZDV8gft1YGYBA&gws_rd=ssl");
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        List<WebElement> wb = driver.findElements(By.tagName("a"));
		System.out.println( wb.size());
		for(int i=0;i<wb.size();i++)
		{

			System.out.println(wb.get(i).getText());
			
		}

	}
}


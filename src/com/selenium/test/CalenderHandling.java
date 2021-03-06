package com.selenium.test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalenderHandling {
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl2;
	private String baseUrl3;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl1 = "http://www.expedia.com/";
		baseUrl2 = "http://www.southwest.com";
		baseUrl3 = "http://www.airbnbcom/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testCalendarSelection1() throws Exception {
		driver.get(baseUrl1);
		Thread.sleep(2000);
		driver.findElement(By.id("tab-flight-tab")).click();
		WebElement text = driver.findElement(By.id("flight-departing"));
		text.click();

		WebElement nextButton;
		WebElement month = driver.findElement(By.xpath("//section[@class='cal-month']"));
		// This code clicks next button to find a particular month
		// To enable this, enter a valid month in the while statement "while (!month.getText().contains("SEP 2015"))"
		/*while (!month.getText().contains("SEP 2015")) {
				nextButton = driver.findElement(By.xpath("//button[@class='btn-paging btn-secondary next']"));
				nextButton.click();
				month = driver.findElement(By.xpath("//section[@class='cal-month']"));
			}*/

		WebElement cal = driver.findElement(By.xpath("//div[@class='cal']//section[1]//ul[@class='cal-dates']"));

		List<WebElement> columns = cal.findElements(By.tagName("li"));

		Thread.sleep(2000);
		for (WebElement cell : columns) {
			if (cell.getText().equals("30")) {
				// cell.findElement(By.linkText("30")).click();
				cell.click();
				break;
			}
		}
	}

	@Test
	public void testCalendarSelection2() throws Exception {
		driver.get(baseUrl2);
		Thread.sleep(2000);
		// Southwest has changed the website a little bit
		// I have updated xpath to find the elements
		WebElement text = driver.findElement(By.xpath("//a[@for='air-date-departure']"));
		text.click();

		WebElement cal = driver.findElement(By.xpath("//div[contains(@class,'calendar-1')]//table[@class='calendar-table']"));

		List<WebElement> columns = cal.findElements(By.tagName("td"));

		Thread.sleep(2000);
		for (WebElement cell : columns) {
			if (cell.getText().equals("30")) {
				cell.click();
				break;
			}
		}
	}

	@Test
	public void testCalendarSelectionAirbnb() throws Exception {
		driver.get(baseUrl3);
		Thread.sleep(2000);
		WebElement checkinElement = driver.findElement(By.id("checkin"));
		checkinElement.click();

		WebElement cal = driver.findElement(By.xpath("//div[contains(@class,'DayPicker') and @data-visible='true'][1]"));

		List<WebElement> columns = cal.findElements(By.tagName("td"));

		Thread.sleep(2000);
		for (WebElement cell : columns) {
			if (cell.getText().equals("30")) {
				cell.click();
				break;
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
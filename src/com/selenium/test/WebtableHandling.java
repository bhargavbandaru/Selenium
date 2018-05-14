package com.selenium.test;
import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebtableHandling {
	public static WebDriver driver;
	@BeforeTest
	public void setUp()
	{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhargav\\Desktop\\Course Material\\Softwares\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void tescase() throws IOException
	{



		WebElement table = driver.findElement(By.xpath("//table[@id='product']"));

		//To locate rows of table.
		List < WebElement > rows = table.findElements(By.tagName("tr"));

		//To calculate no of rows In table.
		int rowcount = rows.size();

		//Loop will execute for all the rows of the table
		for (int i = 0; i < rowcount; i++) {

			//To locate columns(cells) of that specific row.

			List < WebElement > Columns = rows.get(i).findElements(By.tagName("td"));

			//To calculate no of columns(cells) In that specific row.

			int columns_count = Columns.size();

			System.out.println("Number of cells In Row " + i + " are " + columns_count);

			//Loop will execute till the last cell of that specific row.
			for (int j = 0; j < columns_count; j++) {
				//To retrieve text from the cells.
				String celltext = Columns.get(j).getText();
				System.out.println("Cell Value Of row number " + i+ " and column number " + j + " Is " + celltext);
			}

		}


	}

	@AfterTest
	public void teardown()
	{
		driver.quit(); 

	}

}

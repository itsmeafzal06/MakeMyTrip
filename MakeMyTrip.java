package Testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MakeMyTrip {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.cssSelector("span.commonModal__close")).click();
		
	}
	@AfterClass
	void teardown() {
		driver.quit();
	}
	
	@Test
	void TestSearchFlight() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//div[@role='combobox']/input")).sendKeys("mumbai");
		
		List<WebElement> fromCity=driver.findElements(By.xpath("//div[@id='react-autowhatever-1']//ul/li"));
		fromCity.get(0).click();
		
		driver.findElement(By.xpath("//input[@data-cy='toCity']")).click();
		driver.findElement(By.xpath("//div[@role='combobox']/input")).sendKeys("goa");
		
		Thread.sleep(1000);
		
		List<WebElement> toCity=driver.findElements(By.xpath("//div[@id='react-autowhatever-1']//ul/li"));
		toCity.get(0).click();
		
		String MonthWithYear = "November 2024";
		String Date = "27";
		
		while(true) {
			String MWY=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[1]/div")).getText();
			if(MonthWithYear.equals(MWY)) {
				while(true) {
					List<WebElement> date=driver.findElements(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[3]/div/div/div/p[1]"));
					for(WebElement x:date) {
						if(x.getText().equals(Date)) {
							x.click();
							break;
						}
					}
				break;}
			}else {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
			if(MonthWithYear.equals(MWY)) {
				break;
			}
		}
		
		Thread.sleep(1000);
		
		//return calendar
		
		driver.findElement(By.xpath("//div[@class='fsw_inner returnPersuasion']/div[4]")).click();	
		
		String MonthWithYearReturn = "December2024";
		String ReturnDate = "17";
		
		while(true) {
			String MWYR=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]/div[1]/div")).getText();
			System.out.println(MWYR);
			if(MonthWithYearReturn.equals(MWYR)) {
				while(true) {
					List<WebElement> Rdate=driver.findElements(By.xpath("//div[@class='DayPicker-Months']/div[2]/div[3]/div/div/div/p[1]"));
					for(WebElement x:Rdate) {
						if(x.getText().equals(ReturnDate)) {
							x.click();
							break;
						}
					}
				break;}
			}else {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
			if(MonthWithYearReturn.equals(MWYR)) {
				break;
			}
		}
		
		//passenger type 
		//infants(below 2y)
		// Economy/Premium Economy, Premium Economy, Business, First Class
		
		String adult="3";
		String child="2";
		String infants="1";
		String cabin="Premium Economy";
		
		driver.findElement(By.xpath("//div[@class='fsw_inner returnPersuasion']/div[5]")).click();
		
		List<WebElement> adultP=driver.findElements(By.xpath("//div[@class='fltTravellers gbTravellers']/div/ul[1]/li"));
		List<WebElement> childP=driver.findElements(By.xpath("//div[@class='fltTravellers gbTravellers']/div/div/div[1]/ul/li"));
		List<WebElement> infantsP=driver.findElements(By.xpath("//div[@class='fltTravellers gbTravellers']/div/div/div[2]/ul/li"));
		List<WebElement> ChooseTravelClass=driver.findElements(By.xpath("//div[@class='fltTravellers gbTravellers']/div/ul[2]/li"));
		
		for(WebElement x:adultP) {
			if(x.getText().equals(adult)) {
				x.click();
			}
		}
		
		for(WebElement x:childP) {
			if(x.getText().equals(child)) {
				x.click();
			}
		}
		
		for(WebElement x:infantsP) {
			if(x.getText().equals(infants)) {
				x.click();
			}
		}
		
		for(WebElement x:ChooseTravelClass) {
			if(x.getText().equals(cabin)) {
				x.click();
			}
		}
		
		driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
		
		//select passenger type - Regular, Student, Senior Citizen, Armed Forced, Doctor and Nurses
		
		String type="Regular";
		
		List<WebElement> typeP =driver.findElements(By.xpath("//div[@class='makeFlex gap8 hrtlCenter  ']/div/div[2]/div[1]"));
		
		for(WebElement x:typeP) {
			if(x.getText().equals(type)) {
				x.click();
			}
		}
		
		//click on search button
		
		driver.findElement(By.xpath("//a[.='Search']")).click();
		
	}
		
}


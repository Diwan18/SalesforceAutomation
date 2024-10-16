package salesforce;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chromeoption);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("leaf@2024");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement opportunityTab = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		JavascriptExecutor Executer = (JavascriptExecutor) driver;
		Executer.executeScript("arguments[0].click();",opportunityTab);
		
		Thread.sleep(3000);
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		searchbox.clear();
		searchbox.sendKeys("Salesforce Automation By Mohammad",Keys.ENTER);
		Thread.sleep(8000);
		WebElement icon = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr/td[8]/span/div/a[@role='button']"));
		Executer.executeScript("arguments[0].click();",icon);
		
		
		Thread.sleep(6000);
		
		
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
//		Taking the current date 
		 LocalDate Date = LocalDate.now();
		 
//		 switching to next date
		 LocalDate NextDay = Date.plusDays(1);
//		 Setting the Dateformat
		 DateTimeFormatter Format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		 Changing the date format
		 String tomoDate = NextDay.format(Format);
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).clear();
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(tomoDate);
		
		driver.findElement(By.xpath("//button[@aria-label='Stage']")).click();
	    driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
	    Thread.sleep(4000);
	    
	    WebElement Delivery = driver.findElement(By.xpath("//button[@aria-label='Delivery/Installation Status']"));
		driver.executeScript("arguments[0].click();", Delivery);
		WebElement InProgress = driver.findElement(By.xpath("//span[text()='In progress']"));
		driver.executeScript("arguments[0].click();", InProgress);
		driver.findElement(By.xpath("//textarea[@part='textarea']")).sendKeys("SalesForce");
		
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		Thread.sleep(4000);
		
		  WebElement Stage = driver.findElement(By.xpath("//table[@role='grid']//span[text()='Perception Analysis']"));
		   String StageName = Stage.getText();
		   System.out.println(StageName);
		   
		   if(StageName.equalsIgnoreCase("Perception Analysis")) {
			   System.out.println("The Stage Name is Verified Succesfully");
			   driver.close();
		   }
		   else {
			   System.out.println("The Stage Name  is not Verified");
		   }

	}

}

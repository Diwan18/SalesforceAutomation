package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class GroupClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("August@2024");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(30);
		
		Actions click = new Actions(driver);
		
		WebElement workTypeGroups = driver.findElement(By.xpath("//span/p[text()='Work Type Groups']"));
		
		click.moveToElement(workTypeGroups).click().perform();
		
		Thread.sleep(50);
		
//		driver.findElement(By.xpath("//span[@class = 'slds-p-right_small']")).click();

		
		WebElement dropicon = driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[15]"));
		
		JavascriptExecutor Executer = (JavascriptExecutor) driver;
		Executer.executeScript("arguments[0].click();",dropicon);
		
		
		WebElement NewType = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		JavascriptExecutor Executer2 = (JavascriptExecutor) driver;
		Executer.executeScript("arguments[0].click();",NewType);
		
//		driver.findElement(By.xpath("//span[text()='More']")).click()
//		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation By MohammadDiwan");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		
		WebElement GroupName = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']"));
		
		String WorkGroupName = GroupName.getText();
		
		System.out.println(WorkGroupName);
		
		Assert.assertEquals(WorkGroupName, "Salesforce Automation By MohammadDiwan");
	    System.out.println("New Work Type Group is Verified");
	    driver.close();
		
		

	}

}

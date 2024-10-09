package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class EditLegalEntity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chromeoption);
		
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("August@2024");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(30);
		
		Actions action = new Actions(driver);
		WebElement legalEntity = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		action.moveToElement(legalEntity).click().perform();
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']"));
		searchbox.clear();
		searchbox.sendKeys("Salesforce Automation By Diwan");
		
		
		
		WebElement dropicon = driver.findElement(By.xpath("//table/tbody/tr/td/span/div/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", dropicon);
		
		 WebElement clickEdit = driver.findElement(By.xpath("//a[@title='Edit']"));
		executor.executeScript("arguments[0].click();", clickEdit);
		
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("(//textarea[@part='textarea'])[2]")).clear();
		driver.findElement(By.xpath("(//textarea[@part='textarea'])[2]")).sendKeys("Salesforce");
		
		WebElement Status = driver.findElement(By.xpath("//button[@aria-label='Status']"));
		executor.executeScript("arguments[0].click();", Status);
		
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		WebElement LegalEntityName = driver.findElement(By.xpath("//table/tbody/tr/th/span/a"));
		executor.executeScript("arguments[0].click();", LegalEntityName);
		
		WebElement CheckStatus = driver.findElement(By.xpath("//div//slot/lightning-formatted-text[text()='Active']"));
		String statusvalue = CheckStatus.getText();
		System.out.println(statusvalue);
		
		Assert.assertEquals(statusvalue, "Active");
		System.out.println("The Status is Active");
		driver.close();

	}

}

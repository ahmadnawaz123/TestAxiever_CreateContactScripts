package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Datepicker {

	public static void main(String[] args) {
		  WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://impex-test.axiever.com/page_id/sup02");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			driver.findElement(By.name("email")).sendKeys("ahmad@axiever.com");
			driver.findElement(By.name("password")).sendKeys("Ahmad@12Nawaz");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			 WebElement supplierMod = driver.findElement(By.xpath("(//span[.='Supplier'])[1]"));
			 
			 //Creating Actions class object for mouse hovering action
			  Actions a= new Actions(driver);
			  a.moveToElement(supplierMod).perform();
			  
			  //Supplier Master Feature
			  WebElement supplierMaster = driver.findElement(By.xpath("//span[.='Supplier Master']"));
			  
			  //hovering on supplier master sub-module
			  a.moveToElement(supplierMaster).perform();
			  
			  //clicking on new supplier sub-module
			  driver.findElement(By.xpath("//span[.='New Supplier']")).click();
			
			driver.findElement(By.id("datepicker-1")).click();
			driver.findElement(By.xpath("(//td[text()='31'])[2]")).click();
	}
}

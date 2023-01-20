package impexAxieverTestScripts;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import textAxiever.GenericUtility.JavaUtility;

public class CreateNewSupplier {
	
	
public static void main(String[] args) {
		WebDriver driver=null;
		JavaUtility jUtil = new JavaUtility();
	
		 //Handling web-push notification
		
		 //creating ChromeOptions object
		
	     ChromeOptions op = new ChromeOptions();
	      
	     //disabling notification parameter
	     
	     op.addArguments("--disable-notifications");
		
	     
	     driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://impex-test.axiever.com/login");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//for login
		driver.findElement(By.name("email")).sendKeys("ahmad@axiever.com");
		driver.findElement(By.name("password")).sendKeys("Ahmad@12Nawaz");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//login validation
		String titleHomePage = driver.getTitle();
		
		 if(titleHomePage.contains("Dashboard")) {
			 System.out.println("PASSED : Login Successfully");
		 }
		 else {
			 System.out.println("Login Unsuccessfully");    
		 }
		 
		 System.out.println("----currently we are in Homepage-----");
		
		 //supplier module
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
		  
		  //validation for create supplier page
		  String createSupplierTitle= driver.getTitle();
			
		  if(createSupplierTitle.contains("New Supplier")) {
				 System.out.println("PASSED : Create Supplier page open Successfully");
			   }
		  else {
				 System.out.println("Create Supplier page failed to open");    
			   }
		  
		  //filling mandatory fields
		  
		  driver.findElement(By.name("supplier_name")).sendKeys("Viven infotech services"+jUtil.getRandomNumber());
		  
		  driver.findElement(By.name("address_line1")).sendKeys("Block-4,Bank street,Near-constructor area,Adityapur");
		  
		  //selecting Country from Drop-down
		 
		  WebElement dd1 = driver.findElement(By.xpath("(//span[text()='Select Country'])[1]"));
		  dd1.click();
		  List<WebElement> allDropDownOptions1 = driver.findElements(By.xpath("(//li[@data-original-index='101'])[1]"));
		  jUtil.selectOption(allDropDownOptions1, "India");
		  
		  //selecting state from Drop-down
		 
		  WebElement dd2 = driver.findElement(By.xpath("(//span[.='Select State'])[1]"));
		  dd2.click();
		  List<WebElement> allDropDownOptions2 = driver.findElements(By.xpath("//span[.='Jharkhand']"));
		  jUtil.selectOption(allDropDownOptions2, "Jharkhand");                       
			
		  //selecting City from Drop-down
		
		  WebElement cityDropdown= driver.findElement(By.xpath("(//span[.='Select City:'])[1]"));
		  cityDropdown.click();
		  List<WebElement> allDropDownOptions3 = driver.findElements(By.xpath("//span[contains(text(),'Jamshedpur ')]"));
		  jUtil.selectOption(allDropDownOptions3, "Jamshedpur");
		  
		  //filling zip code
		  driver.findElement(By.name("zip_code")).sendKeys("836545");
		  
		  //filling phone number
		  driver.findElement(By.id("phone_no")).sendKeys("9858256585");
		  
		  //filling supplier's website
		  driver.findElement(By.name("website")).sendKeys("www.vivenservices.com");
		  
		  //selecting industry from Drop-down
		
		  WebElement industryDropdown = driver.findElement(By.xpath("(//span[text()='Select Industry'])[1]"));
		  industryDropdown.click();
		  List<WebElement> allDropDownOptions4 = driver.findElements(By.xpath("//span[text()='Construction']"));
		  jUtil.selectOption(allDropDownOptions4, "Construction");
		
		  //selecting date from supplier since date-picker
		 
		  driver.findElement(By.id("datepicker-1")).click();
		  driver.findElement(By.xpath("(//td[text()='31'])[2]")).click();
		  
		  //clicking on save button
		  driver.findElement(By.id("submit_action")).click();

		  //validation for new customer is created or not
			WebElement ConfirmationLogo = driver.findElement(By.xpath("//h3[@class='nw_portlet-title text-dark']"));
			if(ConfirmationLogo.isDisplayed()){
			  System.out.println("PASSED : New supplier created successfully");
				}
				else {
					System.out.println("FAILED : New supplier not created********");

					}
		    // Logout
			driver.findElement(By.xpath("//i[@class=\" fa fa-caret-down m-l-5 m-r-5\"]")).click();
			driver.findElement(By.xpath("//span[.='Logout']")).click();
			
			//validation for log-out
			String loginPage= driver.getCurrentUrl();
			if(loginPage.contains("https://impex-test.axiever.com/login"))
			{
				System.out.println("PAASED : Logout Successfully");
			}
			else {
				System.out.println("Logout failed");
			}
}
}

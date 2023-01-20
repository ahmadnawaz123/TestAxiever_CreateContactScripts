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

public class CreateNewCustomer {
	
WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		
		 //Handling web-push notification
		
		 //creating ChromeOptions object
		 Thread.sleep(3000);
	     ChromeOptions op = new ChromeOptions();
	      
	     //disabling notification parameter
	     Thread.sleep(3000);
	     op.addArguments("--disable-notifications");
		
	     
	     WebDriver driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://impex-test.axiever.com/login");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//for login
		driver.findElement(By.name("email")).sendKeys("ahmad@axiever.com");
		driver.findElement(By.name("password")).sendKeys("Ahmad@12Nawaz");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//login validation
		String titleHomePage =driver.getTitle();
		
		 if(titleHomePage.contains("Dashboard")) {
			 System.out.println("-----Login Successfully----");
		 }
		 else {
			 System.out.println("----Login Unsuccessfully----");    
		 }
		 System.out.println("----currently we are in Homepage-----");
		 
		//hovering on Customer module,then customer master and then clicking on new customer
		
		WebElement CustomerMod = driver.findElement(By.xpath("(//span[text()='Customer'])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(CustomerMod).perform();
		
		WebElement CustomerMaster = driver.findElement(By.xpath("//span[.='Customer Master']"));
		act.moveToElement(CustomerMaster).perform();
		
		driver.findElement(By.xpath("//span[.='New Customer ']")).click();
		
		//validation for create customer page
		String createContactTitle= driver.getTitle();
		
		 if(createContactTitle.contains("New Customer")) {
			 System.out.println("----Create Contact page open Successfully----");
		 }
		 else {
			 System.out.println("----Create Contact page failed to open----");    
		 }
		 
		// filling mandatory fields
	
		 driver.findElement(By.id("customer_name")).sendKeys("Nawaz"+getRandomNumber());
		
		 driver.findElement(By.id("address_line1")).sendKeys("22/2,Hillview,Bistupur");
		
			//selecting Country from Drop-down
			WebElement dd1 = driver.findElement(By.xpath("(//span[.='Select Country'])[1]"));
			dd1.click();
			List<WebElement> allDropDownOptions1 = driver.findElements(By.xpath("(//li[@data-original-index='101'])[1]"));
			selectOption(allDropDownOptions1, "India");
			
			//selecting state from Drop-down
			WebElement dd2 = driver.findElement(By.xpath("(//span[.='Select State'])[1]"));
			dd2.click();
			List<WebElement> allDropDownOptions2 = driver.findElements(By.xpath("//span[.='Jharkhand']"));
			selectOption(allDropDownOptions2, "Jharkhand");                       
			
			//selecting City from Drop-down
			WebElement cityDropdown= driver.findElement(By.xpath("(//span[.='Select City:'])[1]"));
			cityDropdown.click();
			List<WebElement> allDropDownOptions3 = driver.findElements(By.xpath("(//span[.='Dhanbad'])[1]"));
			selectOption(allDropDownOptions3, "Dhanbad");
			
			
			//Entering phone number
			driver.findElement(By.id("phone_no")).sendKeys("3691215189");
			
			//selecting region from Drop-down
			WebElement regionDropdown= driver.findElement(By.xpath("(//span[.='Select Region'])[1]"));
			regionDropdown.click();
			List<WebElement> allDropDownOptions4 = driver.findElements(By.xpath("(//span[.='Asia'])[1]"));
			selectOption(allDropDownOptions4,"Asia");
			
			//selecting Time-zone from Drop-down
//			WebElement timeZoneDropdown= driver.findElement(By.xpath("(//span[.='Select Time Zone'])[1]"));
//			timeZoneDropdown.click();
//			List<WebElement> allDropDownOptions5 = driver.findElements(By.xpath("(//span[.='Asia/Kolkata (+05:30)'])[1]"));
//			selectOption(allDropDownOptions5,"Asia/Kolkata (+05:30)");
			
			System.out.println("----All mandatory fields are filled successfully----");
			
			//clicking on save button
			driver.findElement(By.id("submit_action")).click();
			
			//validating new customer is created or not
			
			WebElement customerCreatedLogo = driver.findElement(By.xpath("//h3[@class=\"nw_portlet-title text-dark\"]"));
			if(customerCreatedLogo.isDisplayed()) {
				System.out.println("PASSED--new customer created successfully");
			}
			else {
				System.out.println("FAILED--new customer not created ");

			}
			
			driver.findElement(By.xpath("//i[@class=\" fa fa-caret-down m-l-5 m-r-5\"]")).click();
			driver.findElement(By.xpath("//span[.='Logout']")).click();
			
			String loginPage= driver.getCurrentUrl();
			if(loginPage.contains("https://impex-test.axiever.com/login"))
			{
				System.out.println("Logout Successfully");
			}
			else {
				System.out.println("Logout failed");
			}
			
	}
	
	
	
	public static void selectOption(List<WebElement> alldropDownOptions, String optionToBeSelected) {
		boolean isFound = false;
		for (WebElement option : alldropDownOptions) {
			if (option.getText().equals(optionToBeSelected)) {
				option.click();
				isFound = true;
				break;
			}
 
		}
		if (!isFound)
			System.out.println("No matching option found.");
		
	}

	private static int getRandomNumber() {
		{
			Random r = new Random();
			int ran =r.nextInt(1000);
			return ran;
		}
		
	}
}

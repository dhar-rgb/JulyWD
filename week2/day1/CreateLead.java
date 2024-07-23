package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class CreateLead {

	public static void main(String[] args) {
		
		// instantiate the browser driver
		
		ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver driver = new FirefoxDriver();
		
		// launch the web browser
		
		driver.get("http://leaftaps.com/opentaps/");
		
		// maximize the browser window
		
		driver.manage().window().maximize();
		
		// locate the webelement for username and password field
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// find the login webelement and click the login button
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// find the crm/sfa button and click the webelement
		
		driver.findElement(By.className("crmsfa")).click();
		
		// find the accounts webelement and click
		
		driver.findElement(By.linkText("Leads")).click();
		
		// find the create leads webelement and click
		
		driver.findElement(By.linkText("Create Lead")).click();
		
		// find the first and last name webelement and send key 'dharma' in the input field box
		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("dharma");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("ravi");
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("demo automation testing lead");
		
		driver.findElement(By.className("smallSubmit")).click();
		
		driver.close();
		
				

	}

}


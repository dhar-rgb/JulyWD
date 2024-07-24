package Week2.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class CreateAccount {

    public static void main(String[] args) {
        // Instantiate the ChromeDriver directly
        ChromeDriver driver = new ChromeDriver();

        try {
            // Open the specified URL
            driver.get("http://leaftaps.com/opentaps/");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Locate the webelement for username and password fields
            driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
            driver.findElement(By.id("password")).sendKeys("crmsfa");

            // Find the login webelement and click the login button
            driver.findElement(By.className("decorativeSubmit")).click();

            // Find the crm/sfa button and click the webelement
            driver.findElement(By.linkText("CRM/SFA")).click();

            // Find the accounts webelement and click
            driver.findElement(By.linkText("Accounts")).click();

            // Find the create account webelement and click
            driver.findElement(By.linkText("Create Account")).click();

            // Find the account name webelement and send key 'dharma' in the input field box
            driver.findElement(By.id("accountName")).sendKeys("dharma");

            // Find the description input box webelement and type selenium automation tester
            driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");

            // Handling dropdown using Select class for industry
            WebElement industryDropdown = driver.findElement(By.name("industryEnumId"));
            Select dd1 = new Select(industryDropdown);
            dd1.selectByIndex(3);

            // Handling dropdown using Select class for ownership
            WebElement ownershipDropdown = driver.findElement(By.name("ownershipEnumId"));
            Select dd2 = new Select(ownershipDropdown);
            dd2.selectByVisibleText("S-Corporation");

            // Handling dropdown using Select class for data source
            WebElement sourceIdDropdown = driver.findElement(By.name("dataSourceId"));
            Select dd3 = new Select(sourceIdDropdown);
            dd3.selectByValue("LEAD_EMPLOYEE");

            // Handling dropdown using Select class for marketing campaign
            WebElement marketingCampaignDropdown = driver.findElement(By.name("marketingCampaignId"));
            Select dd4 = new Select(marketingCampaignDropdown);
            dd4.selectByIndex(6);

            // Handling dropdown using Select class for state/province
            WebElement stateDropdown = driver.findElement(By.name("generalStateProvinceGeoId"));
            Select dd5 = new Select(stateDropdown);
            dd5.selectByValue("TX");

            // Find the add button and click it
            WebElement addButton = driver.findElement(By.xpath("//input[@value='Create Account']"));
            addButton.click();

            
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

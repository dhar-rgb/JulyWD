package marathon1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BagsForBoys {
    public static void main(String[] args) {
        // Set Chrome options to disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Instantiate the ChromeDriver with the options
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open the specified URL
            driver.get("https://www.amazon.in/");

            // Maximize the browser window
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

            // Perform the search
            WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
            searchInput.sendKeys("Bags for boys");
            searchInput.submit();
             
            // Create WebDriverWait instance
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            
            // Locate and click the checkbox for the brand "Skybags"
            WebElement checkbox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[4]") // Adjust the index as needed
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox1);
            wait.until(ExpectedConditions.elementToBeClickable(checkbox1));
            checkbox1.click();
            
            // Capture and print the number of search results for "Skybags"
            WebElement checkbox1ResultsText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".a-section.a-spacing-small.a-spacing-top-small")
            ));
            System.out.println("Number of search results for 'Skybags': " + checkbox1ResultsText.getText());
            
            // Locate and click the checkbox for the brand "Safari"
            WebElement checkbox2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[5]") // Adjust the index as needed
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox2);
            wait.until(ExpectedConditions.elementToBeClickable(checkbox2));
            checkbox2.click();
            
            // Capture and print the number of search results for "Safari"
            WebElement checkbox2ResultsText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".a-section.a-spacing-small.a-spacing-top-small")
            ));
            System.out.println("Number of search results for 'Safari': " + checkbox2ResultsText.getText());
            
            // Print the number of search results for 'Bags for boys'
            WebElement searchResultsText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".a-section.a-spacing-small.a-spacing-top-small")
            ));
            System.out.println("Total number of search results for 'Bags for boys': " + searchResultsText.getText());

            // Sort by "Newest Arrivals"
            WebElement sortDropdown = driver.findElement(By.xpath("//span[@class='a-dropdown-container']"));
            sortDropdown.click();
            WebElement newestArrivalsOption = driver.findElement(By.xpath("//a[text()='Newest Arrivals']"));
            newestArrivalsOption.click();
            
            driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).click();
            
            // Wait for the sorting to be applied and fetch product titles and pricing
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")));

            List<WebElement> productTitles = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
            List<WebElement> productPrices = driver.findElements(By.xpath("//span[@class='a-price']"));

            for (int i = 0; i < 2; i++) {
                System.out.println("Product Title: " + productTitles.get(i).getText());
                if (i < productPrices.size()) {
                    System.out.println("Product Price: " + productPrices.get(i).getText());
                } else {
                    System.out.println("Product Price: Not available");
                }
            }
            
         // Print the page title at the end of the script
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}

package marathon1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pvrcinemaTicketBooking {

    public static void main(String[] args) {
        // Set Chrome options to disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Instantiate the ChromeDriver with the options
        WebDriver driver = new ChromeDriver(options);

        // Open the specified URL
        driver.get("https://www.pvrcinemas.com/");

        // Maximize the browser window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        try {
            // Find and click on the city element
            WebElement city = driver.findElement(By.xpath("//h6[contains(text(), 'Bengaluru')]"));
            city.click();

            // Wait and click on the filter option
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cinemaFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Cinema')]")));
            cinemaFilter.click();

            // Click on the dropdown to open it
            WebElement theaterDropdown = driver.findElement(By.xpath("//span[contains(text(), 'Select Cinema')]"));
            theaterDropdown.click(); // Open the dropdown

            // Select the desired option with INOX Lido Mall, Ulsoor Bengaluru
            WebElement theaterOption = driver.findElement(By.xpath("//span[contains(text(), 'INOX Lido Mall, Ulsoor Bengaluru')]"));
            theaterOption.click(); // Select the option

            // Select the date
            WebElement dateOption = driver.findElement(By.xpath("//span[contains(text(), 'Select Date')]"));
            dateOption.click(); // Open the date picker

            // Locate and click on the '27 Jul' button
            WebElement dateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '27 Jul')]")));
            dateButton.click();

            // Select the movie "Raayan"
            WebElement movieDropdown = driver.findElement(By.xpath("//span[contains(text(), 'Select Movie')]"));
            movieDropdown.click(); // Open the dropdown
            WebElement movieOption = driver.findElement(By.xpath("//span[contains(text(), 'Raayan')]"));
            movieOption.click(); // Select the movie

            // Select the showtime 09:25 AM
            WebElement timingDropdown = driver.findElement(By.xpath("//span[contains(text(), 'p-dropdown-trigger')]"));
            timingDropdown.click(); // Open the dropdown
            WebElement timeOption = driver.findElement(By.xpath("//span[contains(text(), '09:40 AM')]"));
            timeOption.click();
            
           // WebElement timingOption = driver.findElement(By.xpath("//span[contains(text(), '09:25 AM')]"));
           // timingOption.click(); // Select the timing
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Wait for 2 hours (7,200,000 milliseconds)
        try {
            Thread.sleep(7200000); // 2 hours
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Note: Not quitting the browser as per the requirement
    }
}

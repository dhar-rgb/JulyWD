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

        try {
            // Open the specified URL
            driver.get("https://www.pvrcinemas.com/");

            // Maximize the browser window
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

            // Create WebDriverWait instance
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Find and click on the city element
            WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h6[@class='cities-name pointer'])[6]")));
            city.click();
            
            // Click on the 'Cinema' filter option
            WebElement cinemaFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Cinema']")));
            cinemaFilter.click();

            // Select Cinema
            WebElement selectCinema = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select Cinema']")));
            selectCinema.click();
            WebElement cinemaOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='p-dropdown-item']/span)[2]")));
            cinemaOption.click();

            // Select Date
            WebElement dateOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Tomorrow')]")));
            dateOption.click();

            // Select Movie
            WebElement movieOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='p-dropdown-item']/span)[1]")));
            movieOption.click();

            // Select Show Time
            WebElement showTimeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='p-dropdown-item']/span)[1]")));
            showTimeOption.click();

            // Click the Book button
            WebElement bookButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            bookButton.click();

            // Click Accept button (Ensure this is correct; might need to click multiple times based on the site behavior)
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept']")));
            acceptButton.click();

            // Choose Seat
            WebElement seat = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='seat-current-pvr'])")));
            seat.click();

            // Print Booking Summary
            WebElement summary = driver.findElement(By.className("summary-movies-content"));
            System.out.println("Booking summary: " + summary.getText());

            // Print Selected Seat Number
            WebElement seatNo = driver.findElement(By.xpath("//div[@class='seat-number']/p"));
            System.out.println("Booking Seat No: " + seatNo.getText());

            // Print Total Amount
            WebElement price = driver.findElement(By.className("grand-prices"));
            System.out.println("Grand Total: " + price.getText());

            // Click Proceed button
            WebElement proceedButton = driver.findElement(By.xpath("//div[@class='register-btn']/button"));
            proceedButton.click();

            // Print Grand Total
            WebElement grandTotal = driver.findElement(By.xpath("//div[@class='grand-tota col-md-3']//following::span"));
            System.out.println(grandTotal.getText());

            // Verify Price
            if (price.getText().contains(grandTotal.getText())) {
                System.out.println("Both are same");
            }

            // Close the browser
            driver.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure the driver is closed
            if (driver != null) {
                driver.quit();
            }
        }
    }
}

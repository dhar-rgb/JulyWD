package marathon1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;

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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        try {
            // Find and click on the city element
            WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[contains(text(), 'Chennai')]")));
            city.click();

            // Wait and click on the filter option
            WebElement cinemaFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Cinema')]")));
            cinemaFilter.click();

            // Click on the dropdown to open it
            WebElement theaterDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Select Cinema')]")));
            theaterDropdown.click(); // Open the dropdown

            // Select the desired option with INOX National, Virugambakkam Chennai
            WebElement theaterOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'INOX National,Virugambakkam Chennai')]")));
            theaterOption.click(); // Select the option

            // Wait for dropdown to update
            Thread.sleep(2000);

            // Locate and click the date dropdown trigger
            WebElement dateDropdownTrigger = wait.until(ExpectedConditions.elementToBeClickable(By.className("p-dropdown-trigger")));
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", dateDropdownTrigger);
            jsExecutor.executeScript("arguments[0].click();", dateDropdownTrigger);

            // Use JavaScriptExecutor to locate the hidden message for date
            WebElement dateHiddenMessage = (WebElement) jsExecutor.executeScript("return document.querySelector('#date > span')");
            if (dateHiddenMessage != null && dateHiddenMessage.isDisplayed()) {
                System.out.println("Hidden date message found: " + dateHiddenMessage.getText());
            } else {
                System.out.println("Hidden date message not found or not visible.");
            }

            // Select the date
            WebElement selectDateDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Select Date')]")));
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", selectDateDropdown);
            jsExecutor.executeScript("arguments[0].click();", selectDateDropdown);

            // Wait for date options to be visible and click on the '27 Jul' button
            WebElement dateOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='p-dropdown-items']/li[2]/span")));
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", dateOption);
            jsExecutor.executeScript("arguments[0].click();", dateOption);

            // Wait for dropdown to update
            Thread.sleep(2000);

            // Locate and click the movie dropdown trigger
            WebElement movieDropdownTrigger = wait.until(ExpectedConditions.elementToBeClickable(By.className("p-dropdown-trigger")));
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", movieDropdownTrigger);
            jsExecutor.executeScript("arguments[0].click();", movieDropdownTrigger);

            // Select the movie "INDIAN 2"
            WebElement movieDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='p-dropdown-item']/span[text()='INDIAN 2']")));
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", movieDropdown);
            jsExecutor.executeScript("arguments[0].click();", movieDropdown);

            // Wait for dropdown to update
            Thread.sleep(3000);

            // Locate and click the showtime dropdown trigger
            WebElement timingDropdownTrigger = wait.until(ExpectedConditions.elementToBeClickable(By.className("p-dropdown-trigger")));
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", timingDropdownTrigger);
            jsExecutor.executeScript("arguments[0].click();", timingDropdownTrigger);

            // Use JavaScriptExecutor to locate the hidden message for showtime
            WebElement timeHiddenMessage = (WebElement) jsExecutor.executeScript("return document.querySelector('body > div.p-dropdown-panel.p-component.p-ripple-disabled.p-connected-overlay-enter-done > div > ul > li:nth-child(3) > span')");
            if (timeHiddenMessage != null && timeHiddenMessage.isDisplayed()) {
                System.out.println("Hidden showtime message found: " + timeHiddenMessage.getText());
            } else {
                System.out.println("Hidden showtime message not found or not visible.");
            }

            // Select the showtime
            WebElement timingOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='p-dropdown-items']//span")));
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", timingOption);
            jsExecutor.executeScript("arguments[0].click();", timingOption);

            // Wait for a short period to ensure the action completes
            Thread.sleep(2000);

            // Retry mechanism for clicking the submit button
            int maxRetries = 10; // Maximum number of retries
            int attempts = 0;
            boolean isButtonClicked = false;

            while (attempts < maxRetries && !isButtonClicked) {
                try {
                    // Locate the submit button by aria-label and click it
                    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Submit']")));
                    button.click();
                    isButtonClicked = true; // Set flag to true if click was successful

                    // Optional: Verify the click action or add additional checks
                    System.out.println("Button text after click: " + button.getText());
                } catch (StaleElementReferenceException e) {
                    System.out.println("StaleElementReferenceException caught. Retrying...");
                    attempts++;
                    Thread.sleep(1000); // 1 second delay before retrying
                } catch (Exception e) {
                    // Handle other exceptions if necessary
                    System.out.println("Exception caught: " + e.getMessage());
                    attempts++;
                    Thread.sleep(1000); // 1 second delay before retrying
                }
            }

            if (!isButtonClicked) {
                System.out.println("Failed to click the submit button after " + maxRetries + " attempts.");
            }

            driver.findElement(By.xpath("//body[@class='sweetalert-overflow-hidden p-overflow-hidden']//button[2]")).click();
            driver.findElement(By.xpath("//span[@id='SL.SILVER|E:3']")).click();
            driver.findElement(By.xpath("//span[@id='SL.SILVER|D:4']")).click();
            	            		
            driver.findElement(By.xpath("//body[@class='sweetalert-overflow-hidden']//button[text() ='Proceed']")).click();
            WebElement seatinfo = driver.findElement(By.xpath("//body[@class='sweetalert-overflow-hidden']//button[@class ='select-seat-number']"));
            WebElement grandtotal = driver.findElement(By.xpath("//body[@class='sweetalert-overflow-hidden']//button[@class ='all-grand']"));
            
            Thread.sleep(2000);

            // Retry mechanism for clicking the submit button
            int checkoutmaxRetries = 30; // Maximum number of retries
            int checkoutattempts = 0;
            boolean isButton2Clicked = false;

            while (attempts < maxRetries && !isButtonClicked) {
                try {
                	
                	//driver.findElement(By.xpath("//div[@class='register-btn']/button")).click();

                    // Locate the submit button by aria-label and click it
                    WebElement button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='register-btn']/button")));
                    button2.click();
                    isButton2Clicked = true; // Set flag to true if click was successful

                    // Optional: Verify the click action or add additional checks
                    System.out.println("Button text after click for finalbooking: " + button2.getText());
                } catch (StaleElementReferenceException e) {
                    System.out.println("StaleElementReferenceException caught. Retrying...");
                    checkoutattempts++;
                    
                    
                    Thread.sleep(1000); // 1 second delay before retrying
                } catch (Exception e) {
                    // Handle other exceptions if necessary
                    System.out.println("Exception caught: " + e.getMessage());
                    checkoutattempts++;
                    Thread.sleep(1000); // 1 second delay before retrying
                }
            }

            if (!isButton2Clicked) {
                System.out.println("Failed to click the submit button after " + checkoutmaxRetries + " attempts.");
            }

            driver.findElement(By.xpath("//div[@class='register-btn']/button")).click();
            
            
            System.out.println("your reserved seat number is " + seatinfo);
            System.out.println("your grandtotal is " + grandtotal);
            
         // Print the page title at the end of the script
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Wait for 2 hours (7,200,000 milliseconds)
            try {
                Thread.sleep(7200000); // 2 hours
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Close the browser
            driver.quit();
        }
    }
}

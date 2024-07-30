package Week3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ajio {

    public static void main(String[] args) throws InterruptedException {
        // Set Chrome options to disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Instantiate the ChromeDriver with the options
        WebDriver driver = new ChromeDriver(options);

        // Open the specified URL
        driver.get("https://www.ajio.com/");

        // Maximize the browser window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Perform the search
        driver.findElement(By.xpath("//form//input[@placeholder='Search AJIO']")).sendKeys("bags");
        driver.findElement(By.xpath("//form//span")).click();

        // Create an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Interact with the checkbox with id 'Men'
        WebElement menCheckbox = driver.findElement(By.id("Men"));
        if (!menCheckbox.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menCheckbox);
        }

        Thread.sleep(1000);

        // Interact with the checkbox with id 'Men - Fashion Bags'
        WebElement fashionBagsCheckbox = driver.findElement(By.id("Men - Fashion Bags"));
        if (!fashionBagsCheckbox.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fashionBagsCheckbox);
        }

        Thread.sleep(1000);

        // Wait until the search results are loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("length")));

        // Capture and print the number of search results for "Bags" with the filter for Men and Men - Fashion Bags
        WebElement checkboxResultsText = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("#products > div.filter-container > div > div.length")
        ));
        System.out.println("Number of search results for 'bags': " + checkboxResultsText.getText());

        // Get the total number of bags by brand name
        List<WebElement> brandNameList = driver.findElements(By.className("brand"));
        int totalBrandNameCount = brandNameList.size();
        System.out.println("Total number of brand names in bags: " + totalBrandNameCount);

        // Initialize a list to store brand names
        List<String> brandNameData = new ArrayList<>();

        // Iterate through the list of elements and get their text
        for (int i = 0; i < totalBrandNameCount; i++) {
            String text1 = brandNameList.get(i).getText();
            brandNameData.add(text1);
        }

        // Remove duplicates from brand names
        Set<String> uniqueBrandNames = new HashSet<>(brandNameData);

        // Save the unique brand names to a file
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter("uniqueBrandNameData.txt"))) {
            for (String brandName : uniqueBrandNames) {
                writer1.write(brandName);
                writer1.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Find elements with tag name 'strong'
        List<WebElement> bagTypesList = driver.findElements(By.xpath("//div[@class='products']//div[@class='brand']"));
        int totalBagTypes = bagTypesList.size();
        System.out.println("Total bag types found: " + totalBagTypes);

        // Initialize a list to store bag types data
        List<String> bagTypesData = new ArrayList<>();

        // Iterate through the list of elements and get their text
        for (int j = 0; j < totalBagTypes; j++) {
            String text2 = bagTypesList.get(j).getText();
            bagTypesData.add(text2);
        }

        // Remove items with numerical values
        Pattern pattern = Pattern.compile(".*\\d.*");
        bagTypesData.removeIf(pattern.asPredicate());

        // Find duplicates
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        List<String> allBagTypes = new ArrayList<>();

        for (String item : bagTypesData) {
            if (!seen.add(item)) {
                duplicates.add(item);
            } else {
                allBagTypes.add(item);
            }
        }

        // Add duplicates to the list without repeating
        allBagTypes.addAll(duplicates);

        // Print all bag types including unique and duplicate items without repeating duplicates
        System.out.println("All bag types (including unique and non-repeated duplicates): " + allBagTypes);

        // Save all bag types data to a file
        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("allBagTypesData.txt"))) {
            for (String bagType : allBagTypes) {
                writer2.write(bagType);
                writer2.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Print duplicates and their count
        System.out.println("Duplicates: " + duplicates);
        System.out.println("Number of duplicates: " + duplicates.size());

        // Find unique bag types
        Set<String> uniqueBagTypes = new HashSet<>(bagTypesData);
        uniqueBagTypes.removeAll(duplicates);

        // Print unique bag types
        System.out.println("Unique bag types: " + uniqueBagTypes);

        // Save the unique bag types to a file
        try (BufferedWriter writer3 = new BufferedWriter(new FileWriter("uniqueBagTypes.txt"))) {
            for (String uniqueBagType : uniqueBagTypes) {
                writer3.write(uniqueBagType);
                writer3.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Close the browser
        // driver.quit();
    }

    public static Set<String> findDuplicates(List<String> list) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (String item : list) {
            if (!seen.add(item)) {
                duplicates.add(item);
            }
        }

        return duplicates;
    }
}

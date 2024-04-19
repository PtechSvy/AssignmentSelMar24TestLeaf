package SeleniumSessions.HomeAssignment1.Week5HA;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDealActions {

    public static void main(String[] args) throws InterruptedException, IOException {

        ChromeDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        //Load the URL (https://www.amazon.in/)
        driver.get("https://www.snapdeal.com/");

        //Maximize the browser window
        driver.manage().window().maximize();

        //Add an implicit wait to ensure the webpage elements are fully loaded
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Go to "Men's Fashion".
        driver.findElement(By.xpath("//li[1]//a[1]//span[2]")).click();


        //Go to "Sports Shoes".
        WebElement sportsShoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));

        actions.moveToElement(sportsShoes).click().perform();

        //Get the count of sports shoes.
        WebElement sportsshoecount = driver.findElement(By.xpath("//span[@class='category-name category-count']"));

        String countofsportsshoes = sportsshoecount.getText();

        System.out.println("countofsportsshoes: " + countofsportsshoes);

        // Click on "Training Shoes"

        WebElement trainingShoes = driver.findElement(By.xpath("//div[text()='Training Shoes']"));

        trainingShoes.click();

        //Sort the products by "Low to High".

        WebElement dropDownPrice = driver.findElement(By.xpath("//div[@class='sorting-sec animBounce']/div"));
        actions.moveToElement(dropDownPrice).click().build().perform();

        List<WebElement> sortPrice = driver.findElements(By.xpath("//ul[@class='sort-value']/li"));
        sortPrice.stream().filter(pr ->pr.getText().contains("Price Low To High")).findFirst()
                .ifPresent(WebElement::click);


        //Check if the displayed items are sorted correctly.

        List<WebElement>productPrice = driver.findElements(By.xpath("//div[@class='product-price-row clearfix']"));
        List<String>prDet = productPrice.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        List<String>sortedVal = new ArrayList<>(prDet);

        Collections.sort(sortedVal);

        boolean sortedCorrectly = prDet.equals(sortedVal);

        if (sortedCorrectly) {
            System.out.println("Items are displayed correctly in sorted order.");
        } else {
            System.out.println("Items are not displayed correctly in sorted order.");
        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Select any price range ex:(500-700).
        WebElement fromVal = driver.findElement(By.xpath("//input[@name='fromVal']"));
        fromVal.clear();
        Thread.sleep(5000);
        fromVal.sendKeys("500");

        WebElement toVal = driver.findElement(By.xpath("//input[@name='toVal']"));
        toVal.clear();
        toVal.sendKeys("700");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn btn-line btn-theme-secondary')]")).click();

        //Filter by any colour.

        driver.findElement(By.xpath("//a[contains(text(),' White & Blue')]/following::label[1]")).click();

        //Verify all the applied filters.

        String filtr1 = "Rs. 575 - Rs. 700";
        WebElement fltrPrice = driver.findElement(By.cssSelector("div[class='filters-top-selected'] a[class='clear-filter-pill']"));
        boolean checkFltr = fltrPrice.getText().equalsIgnoreCase(filtr1);
        if(checkFltr)
        {
            System.out.println("Value is selected properly");
        }
        else
        {
            System.out.println("Value is not selected properly");
        }
        driver.findElement(By.xpath("//a[contains(text(),' White & Blue')]/following::label[1]")).isSelected();

        //Mouse hover on the first resulting "Training Shoes".
        List<WebElement>traingShoesList = driver.findElements(By.xpath("//img[@class='product-image wooble']"));
        actions.moveToElement(traingShoesList.get(0)).build().perform();

        //Click the "Quick View" button.
        String pHandle = driver.getWindowHandle();
        WebElement quickViewButton = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
        quickViewButton.click();
        String newWindow = null;
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows)
        {
            if (!window.equals(pHandle))
            {
                newWindow = window;
                driver.switchTo().window(newWindow);
                break;
            }
        }



        //Print the cost and the discount percentage.
        WebElement priceShoes = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[1]"));
        String valCost =priceShoes.getText();
        System.out.println("Price of viewed shoe is : " + " " + valCost);

        WebElement discountRate = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[2]"));
        System.out.println("Discount percentage is" + " " + discountRate.getText() );

        //Take a snapshot of the shoes.
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("./SeleniumScreenshots/Shoes.png"));

        //Close the current window.
        driver.close();

        //Close the main window.
       driver.quit();


    }
}

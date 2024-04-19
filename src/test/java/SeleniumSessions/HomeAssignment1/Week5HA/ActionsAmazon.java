package SeleniumSessions.HomeAssignment1.Week5HA;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ActionsAmazon {

    public static void main(String[] args) throws IOException {
        ChromeDriver driver = new ChromeDriver();

        //Load the URL (https://www.amazon.in/)
        driver.get("https://www.amazon.in/");

        //Maximize the browser window
        driver.manage().window().maximize();

        //Add an implicit wait to ensure the webpage elements are fully loaded
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Search for "oneplus 9 pro".
        WebElement srchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        srchbox.sendKeys("oneplus 9 pro");
        srchbox.sendKeys(Keys.ENTER);

        //Get the price of the first product.
        List<WebElement> priceEl = driver.findElements(By.xpath("//span[@class='a-price']"));
        System.out.println(priceEl.get(0).getText());

        //Print the number of customer ratings for the first displayed product.
        List<WebElement> ratings = driver.findElements(By.xpath("//span[@class='a-size-base s-underline-text']"));
        String custRatings = ratings.get(0).getText();
        System.out.println("The rating for first product is :" + " " + custRatings);

        //Click the first text link of the first image.
        String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);

        List<WebElement>imgs = driver.findElements(By.xpath("//*[@class='s-image']"));
        Actions action = new Actions(driver);
        action.moveToElement(imgs.get(0)).click().build().perform();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("The total no: of windows : "+windowHandles.size());


        for(String Wnd:windowHandles)
        {
            if(!Wnd.equals(parentWindow))
            {
                driver.switchTo().window(Wnd);
                break;
            }
        }

        //Take a screenshot of the product displayed.
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("./SeleniumScreenshots/Product.png"));
        System.out.println("Screenshot is captured for the product");

        //Click the 'Add to Cart' button.
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

        //Get the cart subtotal and verify if it is correct.
        String numberOfItems = "1 item";
        WebElement cartSubTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-total-string']"));
        if(cartSubTotal.getText().equalsIgnoreCase(numberOfItems))
        {
            System.out.println("Value is correct");

        }
        else
        {
            System.out.println("Incorrect items added");
        }

        //Close the browser.
        driver.close();
    }
}

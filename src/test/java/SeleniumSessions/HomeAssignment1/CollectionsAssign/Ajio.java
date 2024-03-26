package SeleniumSessions.HomeAssignment1.CollectionsAssign;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Ajio {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        //Launch the URL
        driver.get("https://www.ajio.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //In the search box, type as "bags" and press enter
        driver.findElement(By.xpath("//input[@placeholder='Search AJIO']")).sendKeys("bags", Keys.ENTER);

        //To the left of the screen under "Gender" click on "Men"
        driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click();

        //Under "Category" click "Fashion Bags"
        driver.findElement(By.xpath("//label[normalize-space()='Fashion Bags (1,079)']")).click();

        //Print the count of the items found.
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='brand']"));
        System.out.println("Items count is" + " " + items.size());

        List<String> finalProductList = new ArrayList<>();
        //Get the list of brand of the products displayed in the page and print the list.
        for(WebElement productsBrand : items)
        {
            String prodName = productsBrand.getText();
            finalProductList.add(prodName);
        }

        //Get the list of names of the bags and print it
        System.out.println("Product Names for men on the screen are"+" " + finalProductList);

    }
}

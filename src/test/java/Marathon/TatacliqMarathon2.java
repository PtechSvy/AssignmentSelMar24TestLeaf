package Marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TatacliqMarathon2 {

    public static void main(String[] args) {

        //To freeze dom:
        //setTimeout(function(){debugger;},5000);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.tatacliq.com/");
        driver.manage().window().maximize();

        //MouseHover on 'Brands'
        driver.findElement(By.id("wzrk-cancel")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement brands = driver.findElement(By.xpath("//div[contains(text(),'Brands')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(brands).build().perform();
  //3. MouseHover on 'Watches & Accessories'
        //4. Choose the first option from the 'Featured brands'.
        //5. Select sortby: New Arrivals
        //6. choose men from catagories filter.
        //7. print all price of watches
        //8. click on the first resulting watch
        //9. compare two price are similar
        //10. Take a snap of the resulting page.
        //11. close the all opened windows one by one.
    }
}

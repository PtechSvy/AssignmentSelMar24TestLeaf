package SeleniumSessions.HomeAssignment1.ClassroomActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class AlertAssignment {

    public static void main(String[] args) {

        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://www.leafground.com/alert.xhtml");
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']//span[@class='ui-button-text ui-c'][normalize-space()='Show']")).click();
        Alert alertbx = driver.switchTo().alert();
        String originalMsg = "Alert Prompt" ;
        alertbx.sendKeys(originalMsg);
       // alertbx.accept();
        alertbx.dismiss();
        String msg = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
        if(msg.contains(originalMsg))
        {
            System.out.println("The message as typed by user is same as expected");
        }
        else
        {
            System.out.println("The message as typed by user is not same as expected");
        }
        driver.close();


    }
}

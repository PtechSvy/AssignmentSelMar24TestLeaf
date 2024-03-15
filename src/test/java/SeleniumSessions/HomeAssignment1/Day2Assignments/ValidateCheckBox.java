package SeleniumSessions.HomeAssignment1.Day2Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class ValidateCheckBox {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://leafground.com/checkbox.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Click on the "Basic Checkbox.”
        driver.findElement(By.xpath("//span[contains(text(),'Basic')]")).click();

        //Click on the "Notification Checkbox.
        driver.findElement(By.xpath("//span[contains(text(),'Ajax')]")).click();

        //Verify that the expected message is displayed.
        String expMsg = "Checked";
        String accMsg = driver.findElement(By.xpath("//span[text()='Checked']")).getText();

        if (accMsg.contains(expMsg)) {
            System.out.println("Expected message is displayed: " + expMsg);
        } else {
            System.out.println("Expected message is not displayed. Actual message: " + accMsg);
        }
        // Click on your favorite language (assuming it's related to checkboxes).
        driver.findElement(By.xpath ("(//div[contains(@class,'ui-chkbox-box ui-widget')])[3]")).click();


        //Click on the Tri-State Checkbox.
       WebElement tristate =  driver.findElement(By.xpath("//div[@data-iconstates='[\"\",\"ui-icon ui-icon-check\",\"ui-icon ui-icon-closethick\"]']"));
       tristate.click();


        //Verify which tri-state option has been chosen.
        if(tristate.isSelected())
        {
            System.out.println("Tri-State Checkbox is selected");
        }
        else
        {
            System.out.println("Tri-State Checkbox is not selected");
        }


        //Click on the Toggle Switch.
        driver.findElement(By.className("ui-toggleswitch-slider")).click();



        //Verify if the Checkbox is disabled.
        driver.findElement(By.id("j_idt87:j_idt102")).isEnabled();

        //Select multiple options on the page (details may be needed).
         WebElement  multiplOption = driver.findElement(By.cssSelector("ul[data-label='Cities']"));
         multiplOption.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Perform any additional actions or verifications required.
        driver.findElement(By.xpath("//input[@role='textbox']")).sendKeys("Paris");

        //Close the web browser when done.
        driver.close();


    }
}

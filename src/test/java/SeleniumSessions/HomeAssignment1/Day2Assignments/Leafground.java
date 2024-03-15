package SeleniumSessions.HomeAssignment1.Day2Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class Leafground {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://leafground.com/button.xhtml");
        driver.manage().window().maximize();

       //Click on the button with the text ‘Click and Confirm title.’
         driver.findElement(By.cssSelector("button[id='j_idt88:j_idt90'] span[class='ui-button-text ui-c']")).click();
        //- Verify that the title of the page is ‘dashboard.’
        String expectedTitle = "dashboard";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equalsIgnoreCase(actualTitle))
        {
            System.out.println("The title matches as expected");
        }
        else
        {
            System.out.println("The title do not match as expected");
        }
        driver.navigate().back();
  //- Check if the button with the text ‘Confirm if the button is disabled’ is disabled.
        assertFalse(driver.findElement(By.xpath("//button[@id = 'j_idt88:j_idt92']")).isEnabled());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //- Find and print the position of the button with the text ‘Submit.’
        String subText = driver.findElement(By.cssSelector("button[id='j_idt88:j_idt94'] span[class='ui-button-text ui-c']")).getText();
        System.out.println(subText);
  //- Find and print the background color of the button with the text ‘Find the Save button color.’
        WebElement buttonColor = driver.findElement(By.xpath("//span[text()='Save']"));
        String backgroundColor = buttonColor.getCssValue("background-color");
        System.out.println(backgroundColor);
        //- Find and print the height and width of the button with the text ‘Find the height and width of this button.’
        WebElement buttonDim = driver.findElement(By.xpath("(//span[text()='Submit'])[2]"));
        // Get the size (height and width) of the button
        Dimension buttonSize = buttonDim.getSize();
        // Print the height and width of the button
        System.out.println("Button size - Height: " + buttonSize.getHeight() + ", Width: " + buttonSize.getWidth());
        //Close the browser window.
        driver.close();
    }
}

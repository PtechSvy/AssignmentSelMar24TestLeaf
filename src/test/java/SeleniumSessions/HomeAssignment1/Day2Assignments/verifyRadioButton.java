package SeleniumSessions.HomeAssignment1.Day2Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class verifyRadioButton {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.leafground.com/radio.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Select 'Your most favourite browser' from the radio buttons
        WebElement rdBrowser = driver.findElement(By.xpath("//table[@id='j_idt87:console1']/tbody/tr/td[1]"));
        rdBrowser.click();

        //- Click on a radio button, then click on the same radio button again to verify that
       // rdBrowser.click(); This does not work
        //it becomes ‘unselected’.
        //- Identify the radio button that is initially selected by default.
        WebElement defaultBrowser = driver.findElement(By.xpath("//table[@id='j_idt87:console2']/tbody/tr/td[1]"));
        if(!defaultBrowser.isSelected())
        {
            defaultBrowser.click();
        }
        else
        {
            System.out.println("Default browser already selected");
        }
        //- Check and select the age group (21-40 Years) if not already selected.
        WebElement ageSlct = driver.findElement(By.xpath("//div[@class='ui-g-12 ui-md-4']//div[@class='ui-radiobutton-box ui-widget ui-corner-all ui-state-default ui-state-active']"));
        if(!ageSlct.isSelected())
        {
            ageSlct.click();
        }
        else
        {
            System.out.println("Age group is selected already");
        }

        driver.close();

    }
}

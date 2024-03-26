package SeleniumSessions.HomeAssignment1.ClassroomActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    public String browserName = "Chrome";
    public String browserVersion ="12.2.0";

    public WebDriver driver;

    public void openURL(){
         driver = new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps/");
    }

    public void closeBrowser(){
        driver.close();
    }

        public void navigateBack(){
        driver.navigate().back();
        }
}

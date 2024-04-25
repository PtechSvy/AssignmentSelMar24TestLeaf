package SeleniumSessions.HomeAssignment1.TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseClass {
    //public ChromeDriver driver;
    //RemoteWebDriver is the parent for all webdriver
    public RemoteWebDriver driver;
    public String fileName;

    //Add common values to parameter xml and then add the annotation parameter and define them

    //cross-broser testing - execution in different browsers

    @Parameters({"url","username","password","browser"})
    @BeforeMethod
    public void initiateDriver(String url,String uName,String pWord,String browser)//pass arguments for the parameters
    {
   //   driver = new ChromeDriver();

        if(browser.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-notifications");
           driver = new ChromeDriver(options);
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new FirefoxDriver(firefoxOptions);
        }
      driver.manage().window().maximize();
      driver.get(url);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Enter the user name
        driver.findElement(By.id("username")).sendKeys(uName);
        //Enter the Password
        driver.findElement(By.id("password")).sendKeys(pWord);
        //Click Login button
        driver.findElement(By.className("decorativeSubmit")).click();
        //Click on the "CRM/SFA" link.
        driver.findElement(By.partialLinkText("CRM")).click();

    }

    @AfterMethod
    public void postCondition()
    {
        driver.close();
    }

}

package SeleniumSessions.HomeAssignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CreateAccInFacebook {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://en-gb.facebook.com/");
        driver.manage().window().maximize();

        //Click on the Create new account button.
        driver.findElement(By.xpath("//a[contains(text(),'account')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Enter the First name.
        driver.findElement(By.name("firstname")).sendKeys("Test");
        //Enter the Surname.
        driver.findElement(By.name("lastname")).sendKeys("AccLeaf");

        //Enter the Mobile number or email address.
        driver.findElement(By.name("reg_email__")).sendKeys("demo@abc.com");
        //Enter the New password.
        driver.findElement(By.id("password_step_input")).sendKeys("Test123");

        //Handle all three dropdowns in Date of birth
        WebElement dayVal = driver.findElement(By.xpath("//select[@id='day']"));
        Select dt = new Select(dayVal);
        dt.selectByValue("4");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement monVal = driver.findElement(By.xpath("//select[@id='month']"));
        Select month = new Select(monVal);
        month.selectByVisibleText("Oct");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement yrVal = driver.findElement(By.xpath("//select[@id='year']"));
        Select yr = new Select(yrVal);
        yr.selectByVisibleText("1989");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Select the radio button in Gender.
        driver.findElement(By.xpath("//*[text() = 'Female']")).click();

        driver.close();

    }
}

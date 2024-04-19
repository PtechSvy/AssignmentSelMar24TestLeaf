package SeleniumSessions.HomeAssignment1.Week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.CommonFunc;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandleAssign extends CommonFunc{


    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        CommonFunc dt = new CommonFunc();
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //Enter the user name
        driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
        //Enter the Password
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        //Click Login button
        driver.findElement(By.className("decorativeSubmit")).click();
        //Click on the "CRM/SFA" link.
        driver.findElement(By.partialLinkText("CRM")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Click on the Contacts button.
       // driver.findElement(By.xpath("//div[@class='frameSectionHeader']/following::a[contains(text(),'Contacts')]")).click();
        driver.findElement(By.xpath("//a[@id='ext-gen601']"));

        // Click on Merge Contacts.
        driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();


        // Click on the widget of the "From Contact".
        WebElement  parentWidjet = driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a[1]"));
        Set<String> allWindows = driver.getWindowHandles();
        List<String> allhandles = new ArrayList<String>(allWindows);
        driver.switchTo().window(allhandles.get(1));
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Laavan");
        driver.findElement(By.xpath("//table[@id='ext-gen21']")).click();



        // Click on the first resulting contact.


        // Click on the widget of the "To Contact".

        // Click on the second resulting contact.

        // Click on the Merge button.

        // Accept the alert.

        // Verify the title of the page
    }
}

package SeleniumSessions.HomeAssignment1.Day2Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DeleteLead {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps/.");
        driver.manage().window().maximize();

        //Enter the username.
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        //Enter the password.
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        //Click the Login button.
        driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //- Click the "crm/sfa" link.
        driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();


        //- Click the "Leads" link.
        driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();

        //- Click "Find leads."
        driver.findElement(By.linkText("Find Leads")).click();

        //- Click on the "Phone" tab.
        driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();

        //- Enter the phone number.
        driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).sendKeys("1");
        driver.findElement(By.name(" phoneAreaCode")).sendKeys("212");
        driver.findElement(By.name(" phoneNumber")).sendKeys("681-3029");

        //- Click the "Find leads" button.
       driver.findElement(By.id("ext-gen334")).click();

        //- Capture the lead ID of the first resulting lead.
        WebElement ldId = driver.findElement(By.cssSelector(".x-grid3-cell-inner.x-grid3-col-partyId"));
       String leadId = ldId.getText();

        //- Click the first resulting lead.
        ldId.click();

        //- Click the "Delete" button.
        driver.findElement(By.linkText("Delete")).click();

        //- Click "Find leads" again.
        driver.findElement(By.linkText("Find Leads")).click();


        //- Enter the captured lead ID.
        driver.findElement(By.xpath("(//input[@id='ext-gen253'])[1]")).sendKeys(leadId);

        //- Click the "Find leads" button.
        driver.findElement(By.id("ext-gen334")).click();

        // - Verify the presence of the message "No records to display" in the Lead List. This message confirms the successful deletion.
        WebElement messageElement = driver.findElement(By.xpath("//div[text()='No records to display']"));
        // Capture the text of the element
        String actualMessage = messageElement.getText();
        // Expected message
        String expectedMessage = "No records to display";
        // Verify that the expected message is displayed
        if (actualMessage.contains(expectedMessage)) {
            System.out.println("Expected message is displayed: " + expectedMessage);
        } else {
            System.out.println("Expected message is not displayed. Actual message: " + actualMessage);
        }

        //- Close the browser.
        driver.close();


    }
}

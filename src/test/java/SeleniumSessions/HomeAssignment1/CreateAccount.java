package SeleniumSessions.HomeAssignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.time.Duration;

public class CreateAccount {



    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //Initialize webpage
        driver.get("http://leaftaps.com/opentaps/");
        driver.manage().window().maximize();

        //Enter a username and password.
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");

        //- Click the "Login" button.
        driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //- Click on the "CRM/SFA" link.
        driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

        //click on AccountsTab
        WebElement accTab = driver.findElement(By.linkText("Accounts"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(d -> accTab.isDisplayed());
        accTab.click();

        //Click on the "Create Account" button
        driver.findElement(By.linkText("Create Account")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        //Enter an account name.
        String accName = "Test account";
        driver.findElement(By.id("accountName")).sendKeys(accName);

        //Enter a description as "Selenium Automation Tester."
        driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");



         /*- Select "ComputerSoftware" as the industry.
- Select "S-Corporation" as ownership using SelectByVisibleText.
- Select "Employee" as the source using SelectByValue.
- Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex.
- Select "Texas" as the state/province using SelectByValue.*/


        WebElement indstryVal = driver.findElement(By.name("industryEnumId"));
        Select accClass = new Select(indstryVal);
        accClass.selectByValue("IND_SOFTWARE");
        WebElement emp = driver.findElement(By.xpath("//select[@name='ownershipEnumId']"));
        Select empVal = new Select(emp);
        empVal.selectByVisibleText("S-Corporation");
        WebElement Source= driver.findElement(By.id("dataSourceId"));
        Select srcVal = new Select(Source);
        srcVal.selectByValue("LEAD_EMPLOYEE");
        Select markCamp = new Select(driver.findElement(By.id("marketingCampaignId")));
        markCamp.selectByIndex(6);
        Actions a = new Actions(driver);
//scroll down a page
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        WebElement stVal = driver.findElement(By.xpath("//select[@id='generalStateProvinceGeoId']"));
        Select provSt = new Select(stVal);
        provSt.selectByValue("TX");


        //Product remediation 5.11..jfx releases
        //KT -- CLM SST SETTLEMENTS --- QA AUTOMATION + TEST
        //Onboarded last month


        //Click the submit button
        driver.findElement(By.className("smallSubmit")).click();

        //Verify that the account name is displayed correctly.
        WebElement actualAccountNameElement = driver.findElement(By.xpath("//span[contains(text(),'" + accName + "')]"));

        String accNameVal = actualAccountNameElement.getText();
        if(accName.equalsIgnoreCase(accNameVal))
        {
            System.out.println("Account Name is displayed as expected");
        }
        else {
            System.out.println("Account name mismatch");
        }

        driver.close();





    }
}

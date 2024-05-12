package SeleniumSessions.HomeAssignment1.TestNg;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class CreateLead extends BaseClass{


   @BeforeTest
    public void setValues()
    {
        fileName = "CreateLead.xlsx";
    }


   // @Test(dataProvider = "fetchData",retryAnalyzer = SeleniumSessions.HomeAssignment1.TestNg.RetryFailedTests.class)

    @Test(dataProvider = "fetchData")
    public void runCreateLeadTestCase(String cName,String fName,String lName,String emaId)
    {
        Faker fake = new Faker();
        String firstName = fake.name().firstName();
      //  String lastName = fake.name().lastName();
        driver.findElement(By.linkText("Leads")).click();
        //Click on Create Lead
        driver.findElement(By.linkText("Create Lead")).click();
        //Enter the CompanyName Field Using Xpath
        driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys(cName);
        //Enter the FirstName Field Using Xpath.
        // driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys(fName);
        driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys(firstName);
        //Enter the LastName Field Using Xpath.
        driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys(lName);
        //Enter the FirstName (Local) Field Using Xpath.
        driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys(fName);
        //Enter the Department Field
        driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Software");
        //Enter the Description Field
        driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
        //Enter your email in the E-mail address Field
        driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(emaId);
        //Select State/Province as NewYork Using Visible Text.
        WebElement StVal= driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
        Select select = new Select(StVal);
        select.selectByVisibleText("New York");
        //Click on the Create Button.
        driver.findElement(By.name("submitButton")).click();
    }
}

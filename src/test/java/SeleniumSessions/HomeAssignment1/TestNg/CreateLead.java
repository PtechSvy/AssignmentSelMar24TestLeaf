package SeleniumSessions.HomeAssignment1.TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CreateLead extends BaseClass{

    //Dynamic Parameterization
    @DataProvider(name="fetchData")
    public String[][] sendData() //this method will supply data to test method
    // and for that we have annotation DataProvider(supply data for a test method)
    {
        //first array indicates row count and second array indicates column count
      String[][] data = new String[2][4];
      //add each data into index
        //index will start with 0
        data[0][0]= "TestLeaf";
        data[0][1] = "Rajesh";
        data[0][2] = "kumar";
        data[0][3] = "rajeshkumar@gmail.com";


        data[1][0]= "TestLeaf";
            data[1][1] = "Piyali";
        data[1][2] = "Poddar";
        data[1][3] = "ppodder2020@gmail.com";
        return data;
    }

    @Test(dataProvider = "fetchData")
    public void runCreateLeadTestCase(String cName,String fName,String lName,String emaId)
    {
        driver.findElement(By.linkText("Leads")).click();
        //Click on Create Lead
        driver.findElement(By.linkText("Create Lead")).click();
        //Enter the CompanyName Field Using Xpath
        driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys(cName);
        //Enter the FirstName Field Using Xpath.
        driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys(fName);
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

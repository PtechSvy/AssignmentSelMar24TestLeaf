package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;

public class GenerateExtentReport {

    public static void main(String[] args) throws IOException {

        //Step 1:Create Path for report  folder
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/result.html");

        //Step 2:Create Object for ExtentReports
        ExtentReports extent = new ExtentReports();

        //Step 3:Attach data with the physical file
        extent.attachReporter(reporter);

        //Step 4 : Create Testcase and assign the details
        ExtentTest test = extent.createTest("Login","Login with Credentials");
        test.assignCategory("Sanity");
        test.assignAuthor("Piyali");

        //Step 5 : Step level status
        test.pass("Login is enterned successfully", MediaEntityBuilder.createScreenCaptureFromPath("./SeleniumScreenshots/Shoes.png").build());
        test.pass("Test is done");

        //Step 6: Mandatory Step to save the report
        extent.flush();

        System.out.println("Done");



    }
}

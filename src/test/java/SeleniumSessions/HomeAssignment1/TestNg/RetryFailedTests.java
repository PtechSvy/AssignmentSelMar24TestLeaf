package SeleniumSessions.HomeAssignment1.TestNg;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryFailedTests implements IRetryAnalyzer, IAnnotationTransformer {
//ItestResult will describe the result of the test
    int maxRetry = 0;
    @Override
    public boolean retry(ITestResult result) {
        //logic to retry the failed cases
        if(maxRetry<1)
        {
            maxRetry++;
            return true; //retry will continue
        }
        return false;//once testcase is passed retry will stop
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
    {
       annotation.setRetryAnalyzer(RetryFailedTests.class);
    }
}

//if it because of nosuchelementexception then we will check if the elements located or not
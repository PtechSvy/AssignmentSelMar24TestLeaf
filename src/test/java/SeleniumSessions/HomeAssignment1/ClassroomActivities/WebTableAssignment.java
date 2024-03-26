package SeleniumSessions.HomeAssignment1.ClassroomActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WebTableAssignment {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        //Launch the erail URL.
        driver.get("https://erail.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    //    Enter "MAS" as the "From" station.
         WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
         fromStation.sendKeys("MAS");
        fromStation.sendKeys(Keys.CLEAR);
         fromStation.sendKeys(Keys.ENTER);

           //     - Enter "MDU" as the "To" station.
        WebElement tostation = driver.findElement(By.id("txtStationTo"));
        tostation.sendKeys(Keys.CLEAR);
        tostation.sendKeys("MDU");
        tostation.sendKeys(Keys.ENTER);

           //     - Uncheck the "Sort on Date" checkbox
         driver.findElement(By.xpath("//td[@id='tdDateOnly']/input")).click();


         //Locate the table
        WebElement table = driver.findElement(By.xpath("//div[@id='divTrainsList']/table[1]/tbody"));
        // Locate the row
        List<WebElement> rowCount = table.findElements(By.tagName("tr"));
        // Locate the column
        List<WebElement> columnCount = table.findElements(By.tagName("th"));
        //print size or row
        System.out.println("Row count:"+rowCount.size());
        //Print column count
        System.out.println("Column Count:"+columnCount.size());
        //Print particular data
       String data = driver.findElement(By.xpath("//div[@id='divTrainsList']/table[1]/tbody/tr/th[2]")).getText();
        System.out.println("Column name to fetch data is" + " " + data);
        Set<String> trains = new HashSet<>();
        List<String> duplicates = new ArrayList<>();
       for(int i = 1 ;i<rowCount.size();i++)
           for(int j = 1; j <columnCount.size() ; j++)
           {
               String trainName = driver.findElement(By.xpath("//div[@id='divTrainsList']/table[1]/tbody/tr["+i+"]/td["+j+"]")).getText();
               System.out.println(trainName);
               //oneway - trainname.contents
//               if(trainName.equalsIgnoreCase(trainName))
//               {
//                   System.out.println("Duplicate train is" + " " + trainName);
//               }
               //list into set
               if(!trains.add(trainName))
               {
                   duplicates.add(trainName);
               }

           }
        System.out.println("Duplicate train is" + " " + duplicates);





    }
}

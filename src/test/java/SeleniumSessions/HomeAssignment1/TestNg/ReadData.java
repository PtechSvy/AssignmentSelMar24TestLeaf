package SeleniumSessions.HomeAssignment1.TestNg;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadData {

    public static void main(String[] args) throws IOException {
        //Open the workbook
        XSSFWorkbook wBook = new XSSFWorkbook("./data/CreateLead.xlsx");
        //Enter into the specific worksheet by using sheet index/sheet Name
       // wbook.getSheet("Sheet1");
        XSSFSheet wSheet = wBook.getSheetAt(0);//USING INDEX

        //Enter into the specific rows
        XSSFRow row  = wSheet.getRow(0);

        //Enter into the specific cell
        XSSFCell cell = row.getCell(0);
        //Read the data from each cell
       String data =  cell.getStringCellValue();
        System.out.println(data);





    }
}

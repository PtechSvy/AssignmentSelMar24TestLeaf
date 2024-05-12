package SeleniumSessions.HomeAssignment1.TestNg;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadData {

    public static String[][] readData(String excelFileName) throws IOException {
        //Open the workbook
        XSSFWorkbook wBook = new XSSFWorkbook("./data/"+excelFileName+".xlsx");
        //Enter into the specific worksheet by using sheet index/sheet Name
       // wbook.getSheet("Sheet1");
          XSSFSheet wSheet = wBook.getSheetAt(0);//USING INDEX
//
//        //Enter into the specific rows
//        XSSFRow row  = wSheet.getRow(1);
//
//        //Enter into the specific cell
//        XSSFCell cell = row.getCell(0);
//        //Read the data from each cell
//       String data =  cell.getStringCellValue();
//       // System.out.println(data);o


        //To iterate through the rowcolumn and columb=n we should know total row and column
       int rowCount = wSheet.getLastRowNum();
        System.out.println("Total no of Rows:" + rowCount);

        //find total number of columns
        //get the number of headers to get the last cellcount we can get the number of columns
        int columnCount = wSheet.getRow(0).getLastCellNum();
        System.out.println("Total no of Columns:" + columnCount);
        String [][] data = new String[rowCount][columnCount];
        //Iterate through each row and column to get the values.
        for(int i = 1;i<=rowCount;i++) //as value starts from 1
        {
           XSSFRow row = wSheet.getRow(i);
           for(int j = 0;j<columnCount;j++)
           {
               String stringCelldata = row.getCell(j).getStringCellValue();
               System.out.println(stringCelldata);
               data[i-1][j] = stringCelldata;//i-1 because index value always starts from 0
           }


        }
        wBook.close();
        return data;










    }
}

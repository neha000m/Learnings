package TestGenerator;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.common.collect.Table.Cell;

public class ExcelData {

            WebDriver driver;

        public ExcelData(WebDriver driver) {
            this.driver = driver;
        }
         
        public void getData() throws Exception {

        FileInputStream fis = new FileInputStream("/Users/Saurabh/Desktop/Users.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheeets=workbook.getNumberOfSheets();
        DataFormatter formatter = new DataFormatter();

        for( int i=0; i<sheeets; i++) {

            if(workbook.getSheetName(i).equals("LoginDetails")) {
                // Assuming the first row contains the headers
              Iterator<Row> row=  workbook.getSheetAt(i).iterator();
                  String username = null;
                  String password = null;

                  // Skip the header row
                  
int k=0;
List<String> lis=new ArrayList<>();
                  // Process the data rows
              while(row.hasNext()) {
                  Row currentRow = row.next();
              Iterator<org.apache.poi.ss.usermodel.Cell>   cell= currentRow.cellIterator();
                  if(currentRow.getRowNum() == 0) {
                      continue; // Skip header row
                  }
                  for(int j=0;i<currentRow.getLastCellNum();i++) {
                      if(currentRow.getCell(i) != null) {
                        
                          
                 username = currentRow.getCell(i).getStringCellValue();
                 password = currentRow.getCell(i+1).getStringCellValue();
                 lis.add(username);
                 lis.add(password);
  k++;

  
}}

            }
        }
    
        workbook.close();
        fis.close();
    }   
}}
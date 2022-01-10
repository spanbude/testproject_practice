package excldataReader;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel_XLSFormat {
	 public static void main(String[] args) throws IOException {
	        
	        
	        FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\TestData.xlsx");
	        
	        
	        //Control file using POI jar  -XSSFWorkbook xlsx file format
	        //xls - HSSFWorkbook
	        
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        
	        XSSFSheet sheet = workbook.getSheet("sampleData");
	        
	        int rowCount = sheet.getLastRowNum();
	        
	        int columnCount = sheet.getRow(0).getLastCellNum();
	        
	        System.out.println("Row Count are: " + rowCount);       //3
	        System.out.println("Column Count are: " + columnCount); //5
	        
	        
	        for(int i = 1; i<=rowCount; i++) {
	            
	            XSSFRow currentRow = sheet.getRow(i);
	            
	            
	            String userName = currentRow.getCell(0).toString();
	            String password = currentRow.getCell(1).toString();
	            String email = currentRow.getCell(2).toString();
	            String phone = currentRow.getCell(3).toString();
	            String address = currentRow.getCell(4).toString();
	            
	            
	            System.out.println("UserName information: "+ i + "    " + userName +"     " + password);
	            
	        }
	        
	        
	        
	        
	        
	        
	    }


}

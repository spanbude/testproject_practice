package excldataReader;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class xlsFrmat {
	 public static void main(String[] args) throws IOException {
	        
	        
	        FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\TestData1.xls");
	        
	        
	        //Control file using POI jar  -XSSFWorkbook xlsx file format
	        //xls - HSSFWorkbook
	        
	        HSSFWorkbook workbook = new HSSFWorkbook(fis);
	        
	        HSSFSheet sheet = workbook.getSheet("smokeData");
	        
	        int rowCount = sheet.getLastRowNum();
	        
	        int columnCount = sheet.getRow(0).getLastCellNum();
	        
	        System.out.println("Row Count are: " + rowCount);       //3
	        System.out.println("Column Count are: " + columnCount); //5
	        
	        
	        for(int i = 1; i<=rowCount; i++) {
	            
	            HSSFRow currentRow = sheet.getRow(i);
	            
	            
	            String userName = currentRow.getCell(0).toString();
	            String password = currentRow.getCell(1).toString();
	            String email = currentRow.getCell(2).toString();
	            String phone = currentRow.getCell(3).toString();
	            String address = currentRow.getCell(4).toString();
	            
	            
	            System.out.println("UserName information: "+ i + "    " + userName +"     " + password);
	            
	        }
	        
	        
	        
	        
	        
	        
	    }

}

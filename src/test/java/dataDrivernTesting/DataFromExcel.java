package dataDrivernTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//1.Convert physical file into java readable object	
		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		
		//2.Open Workbook
		Workbook wb = WorkbookFactory.create(fis);
		
//		//3. Get control to the sheet
//		Sheet sheet = wb.getSheet("Sheet1");
//		
//		//4.Get control to the Row
//		Row row =sheet.getRow(1);
//		
//		//5.Get control to the cell
//		Cell cell = row.getCell(1);
//		
//		//6.Fetch the value
//		System.out.println(cell.getStringCellValue());
//		
		String data = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		System.out.println(data);
		//7.close the workbook
		wb.close();
		
		

	}

}


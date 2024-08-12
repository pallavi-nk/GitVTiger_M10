package dataDrivernTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelWithDAtaFormatter {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		System.out.println(wb.getSheet("Sheet1").getRow(2).getCell(1).getNumericCellValue());
		wb.close();

	}

}

package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {

	public static String[][] getExcelValue(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream excelFile = new FileInputStream("./src/test/resources/xlsx/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(excelFile);
		Sheet sheetObj = wb.getSheet(sheetname);
		int rowNum = sheetObj.getLastRowNum();
		int colNum = sheetObj.getRow(0).getLastCellNum();
		String[][] data = new String[rowNum][colNum];
		for(int i = 1; i <= rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				data[i-1][j] = sheetObj.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}

package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * This Helper class is for getting the test data from Excel Sheet.
 * @author FirojShaik
 *
 */
public class ExcelHelper {
  
	/**
	 * @param fileName
	 * @param sheetName
	 * @return array of String
	 */
	public static String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);
            //Get No of cols and Rows
			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			//Iterate through each Row
			for (int i= 1 ; i < totalNoOfRows; i++) {
				//Iterate through each Column
				for (int j=0; j < totalNoOfCols; j++) {
					 // Get data from cell location
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
}

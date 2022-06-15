package webAutomation.Elearning.unitbv.Base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Base {

	public static XSSFWorkbook book;
	public static XSSFSheet sheet;

	//method excelUtilsSetup with the 2 parameters filename and sheetname will take the data from excel file and sheetname
	public void excelUtilsSetup(String filename, String sheetname) throws IOException {
		String ProjectPath = System.getProperty("user.dir");
		//FileInputStream argument takes input from excel file, pass the complete path of the file name
		FileInputStream file = new FileInputStream(
				ProjectPath + "\\src\\main\\java\\webAutomation\\Elearning\\unitbv\\Utillities\\" + filename + ".xlsx");
		
		book = new XSSFWorkbook(file); //checks the excel file		
		sheet = book.getSheet(sheetname);//checks the sheet name
	}
	//setting excel file for string, fetch all the values in string type
	public String settingExcelFileforString(int row, int column) throws IOException {

		String valueData = null;
		
		//passing automatically number of row and column and converting them to string type
		valueData = sheet.getRow(row).getCell(column).toString();
		return valueData;
	}

	//methods getColCount and getRowCount gets the number of columns and rows from the excel and pull the data into test
	public static int getColCount() {
		int noofcol = 0;
		noofcol = sheet.getRow(0).getPhysicalNumberOfCells();
		return noofcol;
	}

	public static int getRowCount() {
		int NoofRows = 0;
		NoofRows = sheet.getPhysicalNumberOfRows();

		return NoofRows;
	}
	
	
	public Object[][] testdata(String file,String sheetName) throws IOException {

		excelUtilsSetup(file, sheetName);

		int rows = getRowCount();

		int cols = getColCount();
		Object data[][] = new Object[rows-1][cols];
		for(int i=1 ; i<rows; i++) {

		for(int j=0; j<cols; j++) {

		String cellData = settingExcelFileforString(i, j);
		System.out.println(cellData+"|");
		data[i-1][j]= cellData;
		}
		System.out.println();
		}
		return data;
		}
}
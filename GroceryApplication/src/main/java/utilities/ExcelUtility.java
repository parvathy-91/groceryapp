package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import constants.Constants;

public class ExcelUtility {
	static FileInputStream f;// inbuilt class for input an external file
	static XSSFWorkbook w;// inbuilt class for getting workbook from the file
	static XSSFSheet s;// inbuilt class for getting sheets from workbook

	public static String getStringdata(int row, int column, String sheet) throws IOException // row and column are the
																								// index of row and cell
	{
		f = new FileInputStream(Constants.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(row);// getting data from row
		XSSFCell c = r.getCell(column);// getting data from cell
		return c.getStringCellValue();// returning string value from cell

	}

	public static String getIntegerdata(int row, int column, String sheet) throws IOException {
		f = new FileInputStream(Constants.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(row);
		XSSFCell c = r.getCell(column);
		int y = (int) c.getNumericCellValue();// Get numeric value from the cell(double type) and cast it to an integer
		return String.valueOf(y);// Convert the integer to a String and return it

	}

}

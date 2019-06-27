package Utils;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public ExcelUtils(String path,String sheetName) {
		try {
			workbook = new XSSFWorkbook(path);
			sheet= workbook.getSheet("Sheet1");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}
	public int getColumnCount() {
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;		}
	public  String getStringCellData(int rowNum,int colNum)
	{
		String stringCellData= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return stringCellData;	}
	public  Double getNumericCellData(int rowNum,int colNum)
	{
		Double numericCellData= sheet.getRow(rowNum).getCell(rowNum).getNumericCellValue();
		return numericCellData;	}
}

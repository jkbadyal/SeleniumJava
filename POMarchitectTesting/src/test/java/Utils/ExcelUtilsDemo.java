package Utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		ExcelUtils excel= new ExcelUtils(projectPath+"/ExcelFolder/Data.xlsx", "Sheet1");
		excel.getRowCount();
		excel.getColumnCount();
		excel.getStringCellData(1, 0);
		excel.getNumericCellData(1, 1);

	}

}

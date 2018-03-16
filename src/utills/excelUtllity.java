package utills;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtllity {
	static XSSFWorkbook wb;
	static XSSFSheet sh;

	public static String getExcelKeyValue(String match) throws Exception {

		String retData = null;
		File file = new File("D:\\EE\\MyWork\\ZTest\\src\\testData\\excelTest.xlsx");
		FileInputStream fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		int rowNum = sh.getLastRowNum();
		for (int i = 0; i <= rowNum; i++) {
			match.trim();
			String data = sh.getRow(i).getCell(0).getStringCellValue();
			data.trim();
			if (match.equalsIgnoreCase(data)) {
				retData = sh.getRow(i).getCell(1).getStringCellValue();

			}

		}
		System.out.println("Data Found: " + retData);
		return retData;

	}

}

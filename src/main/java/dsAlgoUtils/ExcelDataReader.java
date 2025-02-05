package dsAlgoUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

	public static Object[][] getExcelData(String sheetName, String testCaseName) {
		Object[][] data = null;
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\DSAlgoExcelsheets\\TestDataforScenarios.xlsx");
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet(sheetName);

			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getLastCellNum(); // Get total columns

			for (int i = 1; i < rowCount; i++) { // Skipping header row
				Row row = sheet.getRow(i);
				Cell testNameCell = row.getCell(0); // First column contains test case names

				if (testNameCell != null && testCaseName.equalsIgnoreCase(testNameCell.toString())) {
					String[] rowData = new String[colCount - 1]; // Store all values except testCaseName

					for (int j = 1; j < colCount; j++) { // Start from column 1 (skip test case name column)
						Cell cell = row.getCell(j);
						rowData[j - 1] = (cell != null) ? cell.toString() : ""; // Store each column value
					}

					data = new Object[][] { rowData }; // Store as single-row data
					break;
				}
			}

			workbook.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}

//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class ExcelDataReader {
//
//    public static Object[][] getExcelData(String sheetName, String testCaseName) {
//        Object[][] data = null;
//        try {
//            FileInputStream file = new FileInputStream(System.getProperty("user.dir")
//					+ "\\src\\main\\resources\\DSAlgoExcelsheets\\TestDataforScenarios.xlsx");
//            Workbook workbook = new XSSFWorkbook(file);
//            Sheet sheet = workbook.getSheet(sheetName);
//
//            int rowCount = sheet.getPhysicalNumberOfRows();
//            int colCount = sheet.getRow(0).getLastCellNum();
//
//            for (int i = 1; i < rowCount; i++) { // Skipping header row
//                Row row = sheet.getRow(i);
//                Cell testNameCell = row.getCell(0); // First column contains test case names
//
//                if (testNameCell != null && testCaseName.equalsIgnoreCase(testNameCell.toString())) {
//                    Cell urlCell = row.getCell(1); // URL is in column C (index 2)
//                    data = new Object[][]{{urlCell != null ? urlCell.toString() : ""}};
//                    break;
//                }
//            }
//
//            workbook.close();
//            file.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
//}
//
//
//
//
//
//

//import java.io.FileInputStream;
//import java.util.Iterator;
//
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelDataReader {
//
//	public static Object[][] readExcel(String sheetName) {
//		Object[][] data = null;
//		try {
//			FileInputStream file = new FileInputStream(System.getProperty("user.dir")
//					+ "\\src\\main\\resources\\DSAlgoExcelsheets\\TestDataforScenarios.xlsx"); // Read from fixed file
//			XSSFWorkbook workbook = new XSSFWorkbook(file);
//			XSSFSheet sheet = workbook.getSheet(sheetName);
//
//			if (sheet == null) {
//				throw new RuntimeException("Sheet" + sheetName + " not found in ");
//			}
//
//			int rowCount = sheet.getPhysicalNumberOfRows();
//			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//
//			data = new Object[rowCount - 1][colCount]; // Skip header row
//			Iterator<Row> rowIterator = sheet.iterator();
//			rowIterator.next(); // Skip header
//
//			int i = 0;
//			while (rowIterator.hasNext()) {
//				Row row = rowIterator.next();
//				for (int j = 0; j < colCount; j++) {
//					data[i][j] = row.getCell(j).getStringCellValue();
//				}
//				i++;
//			}
//			workbook.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return data;
//	}
//}
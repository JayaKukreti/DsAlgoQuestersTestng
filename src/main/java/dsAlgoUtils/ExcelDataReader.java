package dsAlgoUtils;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import freemarker.template.utility.DateUtil;

public class ExcelDataReader {

	public static Object[][] readExcel(String sheetName) {
		Object[][] data = null;
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\DSAlgoExcelsheets\\TestDataforScenarios.xlsx"); // Read from fixed file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				throw new RuntimeException("Sheet " + sheetName + " not found in ");
			}

			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

			data = new Object[rowCount - 1][colCount]; // Skip header row
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next(); // Skip header

			int i = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				for (int j = 0; j < colCount; j++) {
					Cell cell = row.getCell(j);
					if (cell == null || cell.getCellType() == CellType.BLANK) {
						data[i][j] = ""; // Store empty string if the cell is empty
					} else {
						data[i][j] = cell.getStringCellValue();
					}
				}
				i++;
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
//	private static String getCellValue(Cell cell) {
//        if (cell == null) {
//            return ""; // Return empty string if the cell is null
//        }
//
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue().trim();
//
//            case NUMERIC:
//                if (DateUtil.isCellDateFormatted(cell)) {
//                    return new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue()); // Format date cells
//                } else {
//                return String.valueOf(cell.getNumericCellValue());  // Convert numeric value to string
//                }
//
//            case BOOLEAN:
//                return String.valueOf(cell.getBooleanCellValue());
//
//            case FORMULA:
//            try {
//                     return cell.getStringCellValue(); // Attempt to get formula result as string
//                 } catch (IllegalStateException e) {
//                     return String.valueOf(cell.getNumericCellValue()); // If formula is numeric, convert
//                 }
//
//            case BLANK:
//                return "";
//
//            default:
//                return "";
//        }
//    }

}

package dsAlgoUtils;

import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelDataReader {

    public static Object[][] readExcel(String sheetName) {
        Object[][] data = null;
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")
                    + "\\src\\main\\resources\\DSAlgoExcelsheets\\TestDataforScenarios.xlsx"); // Read from fixed file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet " + sheetName + " not found in the Excel file.");
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
                        data[i][j] = cell.toString().trim(); // Convert any cell type to string
                    }
                }
                i++;
            }

            workbook.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data; // Fixed invalid character issue
    }
}

package dsAlgoUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataReaderArrayLinkedlist {
    public static Object[][] readExcelforArrayLinkedList(String sheetName) {
        Object[][] data = null;
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")
                    + "\\src\\main\\resources\\DSAlgoExcelsheets\\TestDataforScenarios.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                workbook.close();
                file.close();
                throw new RuntimeException("Sheet '" + sheetName + "' not found.");
            }

            int rowCount = sheet.getLastRowNum(); // Get actual last row index instead of physical count
            if (rowCount == 0) {
                workbook.close();
                file.close();
                return new Object[0][0]; // Return empty array if no rows
            }

            int colCount = sheet.getRow(0).getLastCellNum(); // Get actual last column index
            System.out.println("Rows read (excluding header): " + rowCount);
            System.out.println("Columns read: " + colCount);

            data = new Object[rowCount][colCount]; // Adjust rowCount to exclude header
            for (int i = 1; i <= rowCount; i++) { // Start from 1 to skip header
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue; // Skip null rows
                }
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    data[i - 1][j] = getCellValue(cell);
                }
            }

            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading Excel file.");
        }
        return data;
    }

    private static String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}


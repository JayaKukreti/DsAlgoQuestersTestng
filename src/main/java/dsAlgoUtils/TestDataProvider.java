package dsAlgoUtils;

import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "TryEditorDataArray", parallel = false)
	public Object[][] arrayTryEditorData() {
		Object[][] testData1 = ExcelDataReaderArrayLinkedlist.readExcelforArrayLinkedList("ArrayTryEditor");
		// Debug print to check how many rows are being loaded
		System.out.println("Test data length: " + testData1.length);
		return testData1;
	}

	@DataProvider(name = "PracticeQuestionForArrayRun", parallel = false)
	public Object[][] arrayPracticeQuestionRun() {
		Object[][] testData2 = ExcelDataReaderArrayLinkedlist.readExcelforArrayLinkedList("PracticeQuestionRun");
		// Debug print to check how many rows are being loaded
		System.out.println("Test data length: " + testData2.length);
		return testData2;
	}

	@DataProvider(name = "PracticeQuestionForArraySubmit", parallel = false)
	public Object[][] arrayPracticeQuestionSubmit() {
		Object[][] testData3 = ExcelDataReaderArrayLinkedlist.readExcelforArrayLinkedList("PracticeQuestionSubmit");
		// Debug print to check how many rows are being loaded
		System.out.println("Test data length: " + testData3.length);
		return testData3;
	}

	@DataProvider(name = "TryEditorDataLinkedList", parallel = false)
	public Object[][] LinkedlistTryEditorData() {
		Object[][] testData4 = ExcelDataReaderArrayLinkedlist.readExcelforArrayLinkedList("LinkedListTryEditor");
		System.out.println("Test data length: " + testData4.length);
		return testData4;
	}

//    @DataProvider(name = "excelDataProvider")

	@DataProvider(name = "testdata")
	public static Object[][] getGraphModuleData(ITestNGMethod method) {
		String sheetName = "testdataformethods";
		String testCaseName = method.getMethodName();
		System.out.println("testCaseName is : " + testCaseName);
		return ExcelDataReader.getExcelData(sheetName, testCaseName);
	}

	@DataProvider(name = "tryeditordata")
	public static Object[][] getTryEditorData(ITestNGMethod method) {
		String sheetName = "tryEditor";
		String testCaseName = method.getMethodName();
		System.out.println("testCaseName is : " + testCaseName);
		return ExcelDataReader.getExcelData(sheetName, testCaseName);
	}

}

package dsAlgoUtils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "TryEditorDataArray")
	public Object[][] arrayTryEditorData() {
		Object[][] testData1 = ExcelDataReaderArrayLinkedlist.readExcelforArrayLinkedList("ArrayTryEditor");
		System.out.println("Test data length: " + testData1.length);
		return testData1;
	}

	@DataProvider(name = "PracticeQuestionForArrayRun")
	public Object[][] arrayPracticeQuestionRun() {
		Object[][] testData2 = ExcelDataReaderArrayLinkedlist.readExcelforArrayLinkedList("PracticeQuestionRun");
		System.out.println("Test data length: " + testData2.length);
		return testData2;
	}

	@DataProvider(name = "PracticeQuestionForArraySubmit")
	public Object[][] arrayPracticeQuestionSubmit() {
		Object[][] testData3 = ExcelDataReaderArrayLinkedlist.readExcelforArrayLinkedList("PracticeQuestionSubmit");
		System.out.println("Test data length: " + testData3.length);
		return testData3;
	}

	@DataProvider(name = "TryEditorDataLinkedList")
	public Object[][] LinkedlistTryEditorData() {
		Object[][] testData4 = ExcelDataReaderArrayLinkedlist.readExcelforArrayLinkedList("LinkedListTryEditor");
		System.out.println("Test data length: " + testData4.length);
		return testData4;
	}

	@DataProvider(name = "QueueTryEditorData")
	public Object[][] QueueTryEditorData() {
		Object[][] testData = ExcelDataReader.readExcel("QueueTryEditor");
		System.out.println("Test data length: " + testData.length);
		return testData;
	}

	@DataProvider(name = "TreeTryEditorData")
	public Object[][] TreeTryEditorData() {
		Object[][] testData = ExcelDataReader.readExcel("TreeTryEditor");
		System.out.println("Test data length: " + testData.length);
		return testData;
	}

	@DataProvider(name = "codeExecutionData")
	public Object[][] getData() {
		return ExcelDataReader.readExcel("tryedit");
	}

	@DataProvider(name = "signinPageData")
	public Object[][] getSigninData() {
		return ExcelDataReader.readExcel("Signin");
	}

	@DataProvider(name = "dataStructures")
	public Object[][] getDataStructures() throws IOException {

		return ExcelDataReader.readExcel("Home");
	}

	@DataProvider(name = "RegisterPageData")
	public Object[][] getRegisterData() {
		return ExcelDataReader.readExcel("Register");
	}
}

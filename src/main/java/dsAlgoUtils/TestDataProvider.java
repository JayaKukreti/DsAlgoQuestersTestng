package dsAlgoUtils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestDataProvider {



	
	 @DataProvider(name = "QueueTryEditorData", parallel = false)
	    public Object[][] QueueTryEditorData() {
	        Object[][] testData = ExcelDataReader.readExcel("QueueTryEditor");

	        // Debug print to check how many rows are being loaded
	        System.out.println("Test data length: " + testData.length);
	        return testData;
	    }
	 @DataProvider(name = "TreeTryEditorData", parallel = false)
	    public Object[][] TreeTryEditorData() {
	        Object[][] testData = ExcelDataReader.readExcel("TreeTryEditor");

	        // Debug print to check how many rows are being loaded
	        System.out.println("Test data length: " + testData.length);
	        return testData;
	    }
	




	@DataProvider(name = "codeExecutionData")
	public Object[][] getData() {
		return ExcelDataReader.readExcel("tryEditor");
	}

	@DataProvider(name = "signinPageData")
	public Object[][] getSigninData() {
		return ExcelDataReader.readExcel("Sheet1");
	}

	@DataProvider(name = "dataStructures")
	public Object[][] getDataStructures() throws IOException {

		return ExcelDataReader.readExcel("Home");
	}


	
    @DataProvider(name = "RegisterPageData")
    public Object[][] getRegisterData() {
        return ExcelDataReader.readExcel("Sheet3");
    }
}










	




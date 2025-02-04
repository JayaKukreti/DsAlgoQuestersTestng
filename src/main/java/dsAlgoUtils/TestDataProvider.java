package dsAlgoUtils;

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
	
}
//	
//    @DataProvider(name = "codeExecutionData")
//    public Object[][] getData() {
//        return ExcelDataReader.readExcel("tryEditor"); 
//    }
//    @DataProvider(name = "excelDataProvider")
//    public Object[][] getDataFromExcel(Method testMethod) {
//        String sheetName = "";
//        
//        // Identify which test method is calling this DataProvider
//        if (testMethod.getName().equals("verifyCodeExecution")) {
//            sheetName = "CodeExecutionSheet";
//        } else if (testMethod.getName().equals("verifyErrorHandling")) {
//            sheetName = "ErrorHandlingSheet";
//        } else if (testMethod.getName().equals("verifyEdgeCases")) {
//            sheetName = "EdgeCasesSheet";
//        }
//
//        return ExcelReader.readExcel(sheetName);
//    }

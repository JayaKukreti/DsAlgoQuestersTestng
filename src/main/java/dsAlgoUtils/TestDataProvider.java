package dsAlgoUtils;

import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	 @DataProvider(name = "testdata")
	    public static Object[][] getGraphModuleData(ITestNGMethod method) {
	        String sheetName = "testdataformethods"; 
	        String testCaseName = method.getMethodName();
	      System.out.println("testCaseName is : "+ testCaseName);
	        return ExcelDataReader.getExcelData(sheetName, testCaseName);
	    }
	 @DataProvider(name = "tryeditordata")
	    public static Object[][] getTryEditorData(ITestNGMethod method) {
	        String sheetName = "tryEditor";
	        String testCaseName = method.getMethodName();
	        System.out.println("testCaseName is : "+ testCaseName);
	        return ExcelDataReader.getExcelData(sheetName, testCaseName);
	    }
	 
	 
}	 
	 
	 
	 
	 
	
	
	
   
//	@DataProvider(name = "code")
//    public Object[][] getData() {
//        return ExcelDataReader.getExcelData("tryEditor"); 
//    }
//	
//	@DataProvider(name = "excelDataProvider")
//	    public Object[][] getDataFromExcel(Method testMethod) {
//	        // HashMap to map test method names to test case IDs
//	        Map<String, String> testCaseMap = new HashMap<>();
//	        testCaseMap.put("errorMessageWhenClickedOnDataStructureBeforeSignin", "Tc1");
//	        testCaseMap.put("navigateToLogin", "Tc2");
//	        testCaseMap.put("testSomethingElse", "Tc3"); // Add more test cases dynamically
//
//	        String testCaseID = testCaseMap.get(testMethod.getName());
//
//	        if (testCaseID == null) {
//	            throw new RuntimeException("Test case not found in mapping: " + testMethod.getName());
//	        }
//
//	        return new Object[][] { ExcelReader.getRowByTestCaseID("Sheet2", testCaseID) };
//	    }
//	
//	

	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
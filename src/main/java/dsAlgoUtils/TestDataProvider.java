package dsAlgoUtils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
//    @DataProvider(name = "codeExecutionData")
//    public Object[][] getData() {
//        return ExcelDataReader.readExcel("tryEditor"); 
//    }  
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
    
}
    
    
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

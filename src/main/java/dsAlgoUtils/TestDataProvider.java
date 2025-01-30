package dsAlgoUtils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "codeExecutionData")
    public Object[][] getData() {
        return ExcelDataReader.readExcel("tryEditor"); 
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

@DataProvider(name = "Credtionals")
public Object[][] getDataFromExcel() {
    return ExcelDataReader.readExcel("Signin"); 
}

   }













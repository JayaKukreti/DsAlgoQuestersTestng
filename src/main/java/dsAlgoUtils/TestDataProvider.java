package dsAlgoUtils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "codeExecutionData")
    public Object[][] getData() {
        return ExcelDataReader.readExcel("tryEditor"); 
    }

    @DataProvider(name = "signinPageData")
    public Object[][] getSigninData() {
        return ExcelDataReader.readExcel("Signin");
 }
    @DataProvider(name = "RegisterPageData")
    public Object[][] getRegisterData() {
        return ExcelDataReader.readExcel("Sheet3");
    }
}












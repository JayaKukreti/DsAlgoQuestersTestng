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
		return ExcelDataReader.readExcel("Sheet1");
	}

	@DataProvider(name = "dataStructures")
	public Object[][] getDataStructures() throws IOException {

		return ExcelDataReader.readExcel("Home");
	}

}
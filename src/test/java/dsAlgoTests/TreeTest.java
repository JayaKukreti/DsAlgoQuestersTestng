package dsAlgoTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.chaintest.plugins.ChainTestListener;
import dsAlgoHooks.Hooks;
import dsAlgoPages.HomePage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.TreePage;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.TestDataProvider;

public class TreeTest extends Hooks {
	WebDriver driver;
	HomePage homepage;
	SigninPage signinpage;
	TryEditorPage tryeditorpage;
//Properties prop = ConfigReader.initializeprop();
	TreePage treepage;

	@BeforeMethod
	public void navigateToTreePage() {
		driver = Hooks.getDriver();// to call driver
		ChainTestListener.log("Driver initialized.");
		homepage = new HomePage(driver);// calling the page with driver
		ChainTestListener.log("Driver initialized.");
		homepage.clickLaunchPageGetstartedbutton();
		ChainTestListener.log("Clicked on Get Started button on the Launch Page.");
		homepage.clickSignin();
		ChainTestListener.log("Navigating to Sign-in Page.");
		signinpage = new SigninPage(driver);
		ChainTestListener.log("SigninPage object created.");
		signinpage.sendtextusername();
		ChainTestListener.log("Entered Username.");
		signinpage.sendtextpassword();
		ChainTestListener.log("Entered Password.");
		signinpage.clickLoginbutton();
		ChainTestListener.log("Clicked Login button.");
		homepage.getStartedTree();
		ChainTestListener.log("Clicked on Get Started in Tree section.");
		treepage = new TreePage(driver);
		ChainTestListener.log("Navigation to Tree Page completed successfully.");

	}

	@Test(priority = 1)
	public void navigateToOverviewOfTrees() {
		treepage = new TreePage(driver);
		ChainTestListener.log("TreePage object created.");
		treepage.OverviewOfTrees();
		ChainTestListener.log("Navigated to Overview of Trees.");
		Assert.assertTrue(treepage.textconfirmOverviewOfTrees());
		ChainTestListener.log("Overview of Trees verification successful.");
	}

	@Test(priority = 2)
	public void navigateToOverviewOfTreesTryEditor() {
		ChainTestListener.log("Navigating to Overview of Trees section.");
		treepage.OverviewOfTrees();
		ChainTestListener.log("Clicked on Overview of Trees.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");

	}

	@Test(priority = 3)
	public void navigateToTerminologies() {
		ChainTestListener.log("Navigating to Terminologies section.");
		treepage.Terminologies();
		ChainTestListener.log("Clicked on Terminologies.");
		Assert.assertTrue(treepage.textconfirmTerminologies());
		ChainTestListener.log("Terminologies verification successful.");
	}

	@Test(priority = 4)
	public void navigateToTerminologiesTryEditor() {
		ChainTestListener.log("Navigating to Terminologies section.");
		treepage.Terminologies();
		ChainTestListener.log("Clicked on Terminologies.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 5)
	public void navigateToTypesOfTrees() {
		ChainTestListener.log("Navigating to Types of Trees section.");
		treepage.TypesOfTrees();
		ChainTestListener.log("Clicked on Types of Trees.");
		Assert.assertTrue(treepage.textconfirmTypesOfTrees());
		ChainTestListener.log("Types of Trees verification successful.");
	}

	@Test(priority = 6)
	public void navigateToTypesOfTreesTryEditor() {
		ChainTestListener.log("Navigating to Types of Trees section.");
		treepage.TypesOfTrees();
		ChainTestListener.log("Clicked on Types of Trees.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");

	}

	@Test(priority = 7)
	public void navigateToTreeTraversals() {
		ChainTestListener.log("Navigating to Tree Traversals section.");
		treepage.TreeTraversals();
		ChainTestListener.log("Clicked on Tree Traversals.");
		Assert.assertTrue(treepage.textconfirmTreeTraversals());
		ChainTestListener.log("Tree Traversals verification successful.");

	}

	@Test(priority = 8)
	public void navigateToTreeTraversalsTryEditor() {
		ChainTestListener.log("Navigating to Tree Traversals section.");
		treepage.TreeTraversals();
		ChainTestListener.log("Clicked on Tree Traversals.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");

	}

	@Test(priority = 9)
	public void navigateToTraversalsIllustration() {
		ChainTestListener.log("Navigating to Tree TraversalsIllustration section.");
		treepage.TraversalsIllustration();
		ChainTestListener.log("Clicked on Tree Traversals.");
		Assert.assertTrue(treepage.textconfirmTraversalsIllustration());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 10)
	public void navigateToTraversalsIllustrationTryEditor() {
		ChainTestListener.log("Navigating to Tree TraversalsIllustrationTryEditor section.");
		treepage.TraversalsIllustration();
		ChainTestListener.log("Clicked on Tree TraversalsIllustration.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");

	}

	@Test(priority = 11)
	public void navigateToBinaryTrees() {
		ChainTestListener.log("Navigating to Tree navigateToBinaryTrees section.");
		treepage.BinaryTrees();
		ChainTestListener.log("Clicked on BinaryTrees.");
		Assert.assertTrue(treepage.textconfirmBinaryTrees());
		ChainTestListener.log("Text Editor verification successful.");

	}

	@Test(priority = 12)
	public void navigateToBinaryTreesTryEditor() {
		treepage.BinaryTrees();
		ChainTestListener.log("Clicked on BinaryTrees.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 13)
	public void navigateToTypesOfBinaryTrees() {
		treepage.TypesOfBinaryTrees();
		ChainTestListener.log("Clicked on TypesOfBinaryTrees.");
		Assert.assertTrue(treepage.textconfirmTypesOfBinaryTrees());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 14)
	public void navigateToTypesOfBinaryTreesTryEditor() {
		treepage.TypesOfBinaryTrees();
		ChainTestListener.log("Clicked on TypesOfBinaryTrees.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 15)
	public void navigateToImplementationInPython() {
		treepage.ImplementationInPython();
		ChainTestListener.log("Clicked on ImplementationInPython.");
		Assert.assertTrue(treepage.textconfirmImplementationInPython());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 16)
	public void navigateToImplementationInPythonTryEditor() {
		treepage.ImplementationInPython();
		ChainTestListener.log("Clicked on ImplementationInPython.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 17)
	public void navigateToBinaryTreeTraversals() {
		treepage.BinaryTreeTraversals();
		ChainTestListener.log("Clicked on BinaryTreeTraversals.");
		Assert.assertTrue(treepage.textconfirmBinaryTreeTraversals());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 18)
	public void navigateToBinaryTreeTraversalsTryEditor() {
		treepage.BinaryTreeTraversals();
		ChainTestListener.log("Clicked on BinaryTreeTraversals.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 19)
	public void navigateToImplementationOfBinaryTrees() {
		treepage.ImplementationOfBinaryTrees();
		ChainTestListener.log("Clicked on ImplementationOfBinaryTrees.");
		Assert.assertTrue(treepage.textconfirmImplementationOfBinaryTrees());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 20)
	public void navigateToImplementationOfBinaryTreesTryEditor() {
		treepage.ImplementationOfBinaryTrees();
		ChainTestListener.log("Clicked on ImplementationOfBinaryTrees.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");

	}

	@Test(priority = 21)
	public void navigateToApplicationsOfBinaryTrees() {
		treepage.ApplicationsOfBinaryTrees();
		ChainTestListener.log("Clicked on ApplicationsOfBinaryTrees.");
		Assert.assertTrue(treepage.textconfirmApplicationsOfBinaryTrees());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 22)
	public void navigateToApplicationsOfBinaryTreesTryEditor() {
		treepage.ApplicationsOfBinaryTrees();
		ChainTestListener.log("Clicked on ApplicationsOfBinaryTrees.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");

	}

	@Test(priority = 23)
	public void navigateToBinarySearchTrees() {
		treepage.BinarySearchTrees();
		ChainTestListener.log("Clicked on BinarySearchTrees.");
		Assert.assertTrue(treepage.textconfirmBinarySearchTreess());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 24)
	public void navigateToBinarySearchTreesTryEditor() {
		treepage.BinarySearchTrees();
		ChainTestListener.log("Clicked on BinarySearchTrees.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 25)
	public void navigateToImplementationOfBST() {
		treepage.ImplementationOfBST();
		ChainTestListener.log("Clicked on ImplementationOfBST.");
		Assert.assertTrue(treepage.textconfirmImplementationOfBST());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 26)
	public void navigateToImplementationOfBSTTryEditor() {
		treepage.ImplementationOfBST();
		ChainTestListener.log("Clicked on ImplementationOfBST.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		Assert.assertTrue(treepage.textconfirmTextEditor());
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(dataProvider = "TreeTryEditorData", dataProviderClass = TestDataProvider.class, priority = 27)
	public void verifyCodeExecutionForTreeTryEditor(String Options, String code, String ExpectedResult) {
		ChainTestListener.log("Navigating to the '" + Options + "' section.");
		treepage.Option(Options);
		ChainTestListener.log("Selected option: " + Options);
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		tryeditorpage = new TryEditorPage(driver);
		ChainTestListener.log("TryEditorPage object initialized.");
		tryeditorpage.enteringCode(code);
		ChainTestListener.log("Entered code into the editor:\n" + code);
		tryeditorpage.runButton();
		ChainTestListener.log("Clicked on Run button.");
		String ActualResult = tryeditorpage.output();
		Assert.assertEquals(ActualResult, ExpectedResult, "Output mismatch for section:" + Options);
		ChainTestListener.log(
				"Code execution verification successful. Expected: " + ExpectedResult + ", Actual: " + ActualResult);

	}

	@Test(priority = 28)
	public void verifyTreeTryEditorWithoutCodeOfOverviewOfTrees() {
		treepage.OverviewOfTrees();
		ChainTestListener.log("Clicked on OverviewOfTrees.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		treepage.RunBtn();
		ChainTestListener.log("Clicked on 'RunBtn' button to access the text editor.");
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 29)
	public void verifyTreeTryEditorWithoutCodeOfTerminologies() {
		treepage.Terminologies();
		ChainTestListener.log("Clicked on Terminologies.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		treepage.RunBtn();
		ChainTestListener.log("Clicked on 'RunBtn' button to access the text editor.");
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 30)
	public void verifyTreeTryEditorWithoutCodeOfTypesOfTrees() {
		treepage.TypesOfTrees();
		ChainTestListener.log("Clicked on TypesOfTrees.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		treepage.RunBtn();
		ChainTestListener.log("Clicked on 'RunBtn' button to access the text editor.");
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 31)
	public void verifyTreeTryEditorWithoutCodeOfTreeTraversals() {
		treepage.TreeTraversals();
		ChainTestListener.log("Clicked on TreeTraversals.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		treepage.RunBtn();
		ChainTestListener.log("Clicked on 'RunBtn' button to access the text editor.");
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 32)
	public void verifyTreeTryEditorWithoutCodeOfTraversalsIllustration() {
		treepage.TraversalsIllustration();
		ChainTestListener.log("Clicked on TraversalsIllustration.");
		treepage.TryHereBtn();
		ChainTestListener.log("Clicked on 'Try Here' button to access the text editor.");
		treepage.RunBtn();
		ChainTestListener.log("Clicked on 'RunBtn' button to access the text editor.");
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
		ChainTestListener.log("Text Editor verification successful.");
	}

	@Test(priority = 33)
	public void navigateToPracticeQuestionOfOverviewOfTrees() {

		treepage.OverviewOfTrees();
		ChainTestListener.log("Clicked on OverviewOfTrees.");
		treepage.PracticeQuestionPage();
		ChainTestListener.log("Clicked on PracticeQuestionPage.");
		Assert.assertTrue(treepage.textconfirmPracticeQuestionPage());
		ChainTestListener.log("Text Editor verification successful.");

	}

	@Test(priority = 34)
	public void listOfPracticeQuestionOfOverviewOfTrees() {

		treepage.OverviewOfTrees();
		ChainTestListener.log("Clicked on OverviewOfTrees.");
		treepage.PracticeQuestionPage();
		ChainTestListener.log("Clicked on PracticeQuestionPage.");
		Assert.fail("No list of practice question found");
		ChainTestListener.log("Text Editor verification successful.");
	}
}

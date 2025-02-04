package dsAlgoTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsAlgoHooks.Hooks;
import dsAlgoPages.GraphPage;
import dsAlgoPages.HomePage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.TreePage;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.TestDataProvider;

public class TreeTest extends Hooks {
	WebDriver driver;
	HomePage homepage;
	SigninPage signinpage;
	TryEditorPage tryeditorpage;
	Properties prop = ConfigReader.initializeProp();
	TreePage treepage;
	
	@BeforeMethod	
	public void navigateToTreePage() {
		driver = Hooks.getDriver();//to call driver
	       homepage = new HomePage(driver);//calling the page with driver
	       homepage.clickLaunchPageGetstartedbutton();
	       homepage.clickSignin();
	       signinpage = new SigninPage(driver);
	       signinpage.sendtextusername();
	       signinpage.sendtextpassword();
	       signinpage.clickLoginbutton();
	       homepage.getStartedTree();
	       treepage= new TreePage(driver);
	       
	}
	 @Test()
	public void navigateToOverviewOfTrees() {
	 treepage= new TreePage(driver);
	treepage.OverviewOfTrees();
	Assert.assertTrue(treepage.textconfirmOverviewOfTrees());
	}
	 @Test()
	 public void navigateToOverviewOfTreesTryEditor() {
		 treepage.OverviewOfTrees();
		 treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
		 
	 }
	 @Test()
	 public void navigateToTerminologies() {
		 treepage.Terminologies();
		 Assert.assertTrue(treepage.textconfirmTerminologies());
	 }
	 @Test()
	 public void navigateToTerminologiesTryEditor() {
		 treepage.Terminologies();
		 treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
	 }
	 @Test()
	 public void navigateToTypesOfTrees() {
		 treepage.TypesOfTrees();
		 Assert.assertTrue(treepage.textconfirmTypesOfTrees());
	 }
	 @Test()
	 public void navigateToTypesOfTreesTryEditor() {
		 treepage.TypesOfTrees();
		 treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
		 
	 }
	 @Test()
	 public void navigateToTreeTraversals() {
		 treepage.TreeTraversals();
		 Assert.assertTrue(treepage.textconfirmTreeTraversals());
		 
	 }
	 @Test()
	 public void navigateToTreeTraversalsTryEditor() {
		 treepage.TreeTraversals();
		 treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
		 
	 }
	 @Test()
	 public void navigateToTraversalsIllustration() {
		 treepage.TraversalsIllustration();
		 Assert.assertTrue(treepage.textconfirmTraversalsIllustration());
		 
	 }
	 @Test()
	 public void navigateToTraversalsIllustrationTryEditor() {
		 treepage.TraversalsIllustration();
		 treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
		 
	 }
	 @Test()
	 	 public void navigateToBinaryTrees() {
		 treepage.BinaryTrees();
		 Assert.assertTrue(treepage.textconfirmBinaryTrees());
		 
	 }
	 @Test()
	 public void navigateToBinaryTreesTryEditor() {
		 treepage.BinaryTrees();
		 treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
		 
	 }
	 @Test()
	 public void navigateToTypesOfBinaryTrees() {
		 treepage.TypesOfBinaryTrees();
		 Assert.assertTrue(treepage.textconfirmTypesOfBinaryTrees());
		 
	 }
	 @Test()
	 public void navigateToTypesOfBinaryTreesTryEditor() {
		 treepage.TypesOfBinaryTrees();
		 treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
		 
	 }
	 @Test()
	 public void navigateToImplementationInPython() {
		 treepage.ImplementationInPython();
		 Assert.assertTrue(treepage.textconfirmImplementationInPython());
		 
	 }
	 @Test()
	 public void navigateToImplementationInPythonTryEditor() {
		 treepage.ImplementationInPython();
		 treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
		 
	 }
	 @Test()
	 public void navigateToBinaryTreeTraversals() {
		 treepage.BinaryTreeTraversals();
		 Assert.assertTrue(treepage.textconfirmBinaryTreeTraversals());
		 
	 }
	 @Test()
	 public void navigateToBinaryTreeTraversalsTryEditor() {
		 treepage.BinaryTreeTraversals();
		 treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
		 
	 }
	 @Test()
	 public void navigateToImplementationOfBinaryTrees() {
		 treepage.ImplementationOfBinaryTrees();
		 Assert.assertTrue(treepage.textconfirmImplementationOfBinaryTrees());
		 
	 }
	 @Test()
	 public void navigateToImplementationOfBinaryTreesTryEditor() {
		 treepage.ImplementationOfBinaryTrees();
		 treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
		 
	 }
	 @Test()
	 public void navigateToApplicationsOfBinaryTrees() {
		 treepage.ApplicationsOfBinaryTrees();
		 Assert.assertTrue(treepage.textconfirmApplicationsOfBinaryTrees());
		 
	 }
	 @Test()
	 public void navigateToApplicationsOfBinaryTreesTryEditor() {
		 treepage.ApplicationsOfBinaryTrees();
		 treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
		 
	 }
	 @Test()
	 public void navigateToBinarySearchTrees() {
		 treepage.BinarySearchTrees();
		 Assert.assertTrue(treepage.textconfirmBinarySearchTreess());
		 
	 }
	 @Test()
	 public void navigateToBinarySearchTreesTryEditor() {
		treepage.BinarySearchTrees();
		treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
		 
	 }
	 @Test()
	 public void navigateToImplementationOfBST() {
		 treepage.ImplementationOfBST();
		 Assert.assertTrue(treepage.textconfirmImplementationOfBST());
		 
	 }
	 @Test()
	 public void navigateToImplementationOfBSTTryEditor() {
		 treepage.ImplementationOfBST();
		 treepage.TryHereBtn();
		 Assert.assertTrue(treepage.textconfirmTextEditor());
		 
	 }
	 @Test(dataProvider="TreeTryEditorData",dataProviderClass=TestDataProvider.class)
	public void verifyCodeExecutionForTreeTryEditor(String Options,String code,String ExpectedResult) {
		treepage.Option(Options);
		treepage.TryHereBtn();
		tryeditorpage = new TryEditorPage(driver);
		tryeditorpage.enteringCode(code);
		tryeditorpage.runButton();
		 String ActualResult = tryeditorpage.output();
		 Assert.assertEquals(ActualResult, ExpectedResult,"Output mismatch for section:" + Options );
			
	}
	 
	 @Test
		public void verifyTreeTryEditorWithoutCodeOfOverviewOfTrees() {
			treepage.OverviewOfTrees();
			treepage.TryHereBtn();
			treepage.RunBtn();
			 Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
		} 
	 @Test
		public void verifyTreeTryEditorWithoutCodeOfTerminologies() {
			treepage.Terminologies();
			treepage.TryHereBtn();
			treepage.RunBtn();
			 Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
		} 
	 @Test
		public void verifyTreeTryEditorWithoutCodeOfTypesOfTrees() {
			treepage.TypesOfTrees();
			treepage.TryHereBtn();
			treepage.RunBtn();
			 Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
		} 
	 @Test
		public void verifyTreeTryEditorWithoutCodeOfTreeTraversals() {
			treepage.TreeTraversals();
			treepage.TryHereBtn();
			treepage.RunBtn();
			 Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
		} 
	 @Test
		public void verifyTreeTryEditorWithoutCodeOfTraversalsIllustration() {
			treepage.TraversalsIllustration();
			treepage.TryHereBtn();
			treepage.RunBtn();
			 Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
		} 
	 @Test
	 public void navigateToPracticeQuestionOfOverviewOfTrees() {
	    	
	    	treepage.OverviewOfTrees();
	    	treepage.PracticeQuestionPage();
	   	   	Assert.assertTrue(treepage.textconfirmPracticeQuestionPage());
  	
	    }
	 @Test()
	 public void listOfPracticeQuestionOfOverviewOfTrees() {
    	
	    	treepage.OverviewOfTrees();
	    	treepage.PracticeQuestionPage();
	    	Assert.fail("No list of practice question found");
	    	
	    }
	 
	
	
	
	
	
	

}

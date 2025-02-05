package dsAlgoTests;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsAlgoHooks.Hooks;
import dsAlgoPages.HomePage;
import dsAlgoPages.QueuePage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.TestDataProvider;

public class QueueTest extends Hooks {
	WebDriver driver;
	HomePage homepage;
	SigninPage signinpage;
	//RegisterPage registerpage;
	TryEditorPage tryeditorpage;
	Properties prop = ConfigReader.initializeprop();
    QueuePage queuepage;
    
    @BeforeMethod
    public void  navigatetoQueuepage() {
    	driver = Hooks.getDriver();//to call driver
       homepage = new HomePage(driver);//calling the page with driver
       homepage.clickLaunchPageGetstartedbutton();
       homepage.clickSignin();
       signinpage = new SigninPage(driver);
       signinpage.sendtextusername();
       signinpage.sendtextpassword();
       signinpage.clickLoginbutton();
       homepage.getStartedQueue();
       queuepage= new QueuePage(driver);
            
    }
    @Test()
    public void navigatetoImplementationOfQueueInPython() {
    	
    	queuepage.implementationOfQueueInPythonBtn();
    	Assert.assertTrue(queuepage.textconfirmImplementationofQueue());
    }
    
    @Test()
    public void navigatetoImplementationOfQueueInPythonTryEditor() {
    	
    	queuepage.implementationOfQueueInPythonBtn();
    	queuepage.TryHereBtn();
       	Assert.assertTrue(queuepage.textconfirmTextEditor());
    	
    }
    @Test()
    public void navigatetoImplementationUsingCollectionsDeque() {
    	
    	queuepage.implementationUsingCollectionsDequeBtn();
    	Assert.assertTrue(queuepage.textconfirmImplementationUsingCollectionsDeque());
    }
    @Test()
    public void navigatetoImplementationUsingCollectionsDequeTryEditor() {
    	
    	queuepage.implementationUsingCollectionsDequeBtn();
    	queuepage.TryHereBtn();
    	Assert.assertTrue(queuepage.textconfirmTextEditor());
    }
    @Test()
    public void navigateToImplementationUsingArray() {
    	
    	queuepage.ImplementationUsingArrayBtn();
    	Assert.assertTrue(queuepage.textconfirmImplementationUsingArray());
    }
    @Test()
    public void navigateToImplementationUsingArrayTryEditor() {
    	
    	queuepage.ImplementationUsingArrayBtn();
    	queuepage.TryHereBtn();
    	Assert.assertTrue(queuepage.textconfirmTextEditor());
    }
    @Test()
    public void navigateToQueueOperations() {
    	
    	queuepage.QueueOperationsBtn();
    	Assert.assertTrue(queuepage.textconfirmQueueOperations());
    
    }
    @Test()
    public void navigateToQueueOperationsTryEditor() {
    	
    	queuepage.QueueOperationsBtn();
    	queuepage.TryHereBtn();
    	Assert.assertTrue(queuepage.textconfirmTextEditor());
    	  
    }
    @Test()
    public void navigateToPracticeQuestionOfImplementationOfQueueInPython() {
    	
    	queuepage.implementationOfQueueInPythonBtn();
    	queuepage.PracticeQuestionBtn();
   	   	Assert.assertTrue(queuepage.textconfirmPracticeQuestionPage());
  	
    }
   @Test()
    public void listOfPracticeQuestionOfImplementationOfQueueInPython() {
    	
    	queuepage.implementationOfQueueInPythonBtn();
    	queuepage.PracticeQuestionBtn();
    	Assert.fail("No list of practice question found");
    	
    }
   @Test()
   public void navigateToPracticeQuestionImplementationUsingCollectionsDeque() {
	 
	   queuepage.implementationUsingCollectionsDequeBtn();
	   queuepage.PracticeQuestionBtn();
		Assert.assertTrue(queuepage.textconfirmPracticeQuestionPage());
	   
   }
   @Test()
   public void listOfPracticeQuestionImplementationUsingCollectionsDeque() {
	   
	   queuepage.implementationUsingCollectionsDequeBtn();
	   queuepage.PracticeQuestionBtn();
		Assert.assertTrue(queuepage.textconfirmPracticeQuestionPage());
	   }
   @Test()
   public void checkErrorMeaasgeWhenExecutingWithoutCodeInImplementationOfQueueInPython() {
	   queuepage.implementationOfQueueInPythonBtn();
	   queuepage.TryHereBtn();
	   queuepage.RunBtn();
	   Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
   }
   @Test()
   public void checkErrorMessageWhenExecutingWithoutCodeInImplementationUsingCollectionsDeque() {
	    queuepage.implementationUsingCollectionsDequeBtn();;
	   queuepage.TryHereBtn();
	   queuepage.RunBtn();
	   Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
   }
   @Test()
   public void checkErrorMeaasgeWhenExecutingWithoutCodeInImplementationUsingArray() {
	   queuepage.ImplementationUsingArrayBtn();;
	   queuepage.TryHereBtn();
	   queuepage.RunBtn();
	   Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
   }
   @Test()
   public void checkErrorMeaasgeWhenExecutingWithoutCodeInQueueOperations() {
	   queuepage.QueueOperationsBtn();
	   queuepage.TryHereBtn();
	   queuepage.RunBtn();
	   Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");
   }
   @Test(dataProvider="QueueTryEditorData",dataProviderClass=TestDataProvider.class)
   public void verifyCodeExecutionForQueueTryEditor(String Options,String code,String expectedResult) {
	   queuepage.Option(Options);
	   queuepage.TryHereBtn();
	   tryeditorpage=new TryEditorPage(driver);
	   tryeditorpage.enteringCode(code);
	   tryeditorpage.runButton();
	   String ActualResult=tryeditorpage.output();
	   Assert.assertEquals(ActualResult, expectedResult,"Output mismatch for section:" + Options);
	 }
    




    

    
    
    
    
    
    
    
    
    
   
    
}

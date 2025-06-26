package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RegisterTests_negativeScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	RegisterPage registerObject= new RegisterPage(driver);
	
    @Test (priority = 3)
    public void testRegister_ExistEmail() throws InterruptedException {
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	
    	homeObject.openRegisterationPage();
    	Thread.sleep(3000);
    	
    	Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());
    	
    	String name ="Mohamed Ahmed";
    	registerObject.userCanRegister(name,"abdelrahmanosama7651111@gmail.com");
    	Thread.sleep(3000);
    	
    	Assert.assertEquals("Email Address already exist!", registerObject.failedMessage.getText());
    	
    }
    
   
}

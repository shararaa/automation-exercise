package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RegisterTests_happyScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	RegisterPage registerObject = new RegisterPage(driver);
	
    @Test (priority = 1)
    public void testRegister_NewEmail_MandarotyAndOptional() throws InterruptedException {
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	
    	homeObject.openRegisterationPage();
    	Thread.sleep(3000);
    	
    	Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());
    	
    	String name ="Mohamed Ahmed";
    	registerObject.userCanRegister(name,"abdelrahmanosama76833@gmail.com");
    	Thread.sleep(3000);
    	
    	Assert.assertEquals("ENTER ACCOUNT INFORMATION", registerObject.enterAccountMessage.getText());///الطريقة الاولي
    	
    	registerObject.enterAccountInformation("123456789",25,"12","2002",
    			"Abdelrahman","Osama","Itworx","Fostat",
    			"United States","Newyork","aaaa","17611",
    			"01013440554"
    			);
    	
    	Thread.sleep(3000);
    	
    	Assert.assertTrue(registerObject.successMessage.getText().equalsIgnoreCase("Account Created!"));/// الطريقة الثانية
    	
    	registerObject.continueAccount();
    	Assert.assertEquals("Logged in as "+name, registerObject.loggedInLink.getText());
    	Thread.sleep(3000);
    	
    	registerObject.deleteAccount();
    	Thread.sleep(3000);

    	String deleteText = "Account Deleted!";
    	Assert.assertEquals(deleteText.toUpperCase(), registerObject.deleteMessage.getText());/// الطريقة الثالثة
    	
    	registerObject.continueAccount();
    }
    
    @Test (priority = 2,dependsOnMethods = {"testRegister_NewEmail_MandarotyAndOptional"})
    public void testRegister_NewEmail_Mandaroty() throws InterruptedException {
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	
    	homeObject.openRegisterationPage();
    	
    	Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());
    	
    	String name ="Mohamed Ahmed";
    	registerObject.userCanRegister(name,"abdelrahmanosama76833@gmail.com");
    	
    	Assert.assertEquals("ENTER ACCOUNT INFORMATION", registerObject.enterAccountMessage.getText());///الطريقة الاولي
    	
    	registerObject.enterAccountInformation("123456789",1,"12","2002",
    			"Abdelrahman","Osama","","Fostat",
    			"United States","Newyork","aaaa","17611",
    			"01013440554"
    			);
    	
    	
    	Assert.assertTrue(registerObject.successMessage.getText().equalsIgnoreCase("Account Created!"));/// الطريقة الثانية
    	
    	registerObject.continueAccount();
    	Assert.assertEquals("Logged in as "+name, registerObject.loggedInLink.getText());
    	
    	registerObject.deleteAccount();

    	String deleteText = "Account Deleted!";
    	Assert.assertEquals(deleteText.toUpperCase(), registerObject.deleteMessage.getText());/// الطريقة الثالثة
    	
    	registerObject.continueAccount();
    }

}

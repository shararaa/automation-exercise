package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class Login_NegativeScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	LoginPage loginObject = new LoginPage(driver);
	@Test (priority = 2)
	  public void testLogin_InCorrectEmail() throws InterruptedException {
	  	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));

		homeObject.openLoginPage();
		Thread.sleep(2000);
		
		Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
		  
		loginObject.userCanLogin("abdelrahmanosama76588@gmail.com", "12345678");
		Thread.sleep(2000);
		
		Assert.assertEquals("Your email or password is incorrect!", loginObject.failedMessage.getText());
	  }
	
	  @Test (priority = 3)
	  public void testLogin_CorrectEmailandNotCorrectPassword() throws InterruptedException {

		homeObject.openLoginPage();
		Thread.sleep(2000);
		
		Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
		  
		loginObject.userCanLogin("abdelrahmanosama7651111@gmail.com", "123456");
		Thread.sleep(2000);
		
		Assert.assertEquals("Your email or password is incorrect!", loginObject.failedMessage.getText());
	  }
  }

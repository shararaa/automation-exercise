package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests_happyScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	LoginPage loginObject = new LoginPage(driver);
  @Test(priority = 1)
  public void testLogin_CorrectEmailAndPassword() throws InterruptedException {
  	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));

	homeObject.openLoginPage();
	Thread.sleep(2000);
	
	Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
	  
	loginObject.userCanLogin("abdelrahmanosama7651111@gmail.com", "12345678");
	Thread.sleep(2000);
	
	Assert.assertEquals("Logout", loginObject.logoutBtn.getText());  
	
	loginObject.userCanLogout();
	Thread.sleep(2000);
  }
}

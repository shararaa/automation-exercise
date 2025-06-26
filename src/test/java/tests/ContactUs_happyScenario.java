package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPageWithDirectWay;
import pages.ContactUsPageWithRobotWay;
import pages.HomePage;

public class ContactUs_happyScenario extends TestBase {
	HomePage homeObject = new HomePage(driver);
	ContactUsPageWithRobotWay contactUsObject = new ContactUsPageWithRobotWay(driver);
  @Test
  public void testContactUs_validData() throws InterruptedException, AWTException {
	  homeObject.openContactUsPage();
	  
	  Assert.assertEquals("GET IN TOUCH", contactUsObject.getInMessage.getText());
	  
	  contactUsObject.userCanContactUs("Abdelrahman Osama", "abdelrahman@gmail.com", "Complain", "my order doesn't deliver yet");
	  Thread.sleep(3000);
	  
	  Assert.assertEquals("Success! Your details have been submitted successfully.", contactUsObject.successMessage.getText());
  }
}

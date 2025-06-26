package Autoamtion_Project.Autmation_Excercises_S5Group;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginTests_happyScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	ReigsterPage registerObject= new ReigsterPage(driver);
	
    @Test
    public void f() throws InterruptedException {
    	homeObject.openRegisterationPage();
    	Thread.sleep(3000);
    	
    	registerObject.userCanRegister();
    	Thread.sleep(3000);
    	
    	registerObject.enterAccountInformation();
    	Thread.sleep(3000);
    }

}

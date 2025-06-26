package Autoamtion_Project.Autmation_Excercises_S5Group;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Signup / Login")
	WebElement signUpBtn;
	
	public void openRegisterationPage() {
		signUpBtn.click();
	}
}

package Autoamtion_Project.Autmation_Excercises_S5Group;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	protected WebDriver driver;
	
	PageBase(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

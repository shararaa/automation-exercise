package Autoamtion_Project.Autmation_Excercises_S5Group;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ReigsterPage extends PageBase {

	ReigsterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="name")
	WebElement usernameTxt;
	
	@FindBy(name="email")
	List<WebElement> emails;
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	WebElement signUpBtn;
	
	@FindBy(id="id_gender1")
	WebElement maleGenderBtn;
	
	@FindBy(id="password")
	WebElement passwordTxt;
	
	@FindBy(id="days")
	WebElement daysList;
	
	@FindBy(id="months")
	WebElement monthsList;
	
	@FindBy(id="years")
	WebElement yearsList;
	
	@FindBy(id="newsletter")
	WebElement newsLetterBtn;
	
	@FindBy(id="optin")
	WebElement specialOffersBtn;
	
	@FindBy(id="first_name")
	WebElement firstNameTxt;
	
	@FindBy(id="last_name")
	WebElement lastNameTxt;
	
	@FindBy(id="company")
	WebElement companyTxt;
	
	@FindBy(id="address1")
	WebElement addressTxt1;
	
	@FindBy(id="country")
	WebElement countryList;
	
	@FindBy(id="state")
	WebElement stateTxt;
	
	@FindBy(id="city")
	WebElement cityTxt;
	
	@FindBy(id="zipcode")
	WebElement zipCodeTxt;
	
	@FindBy(id="mobile_number")
	WebElement mobileNumberTxt;
	
	@FindBy(css="#form > div > div > div > div.login-form > form > button")
	WebElement createAccountBtn;
	
	
	public void userCanRegister() {
		usernameTxt.sendKeys("abdelrahmanosama21");
		emails.get(1).sendKeys("abdelrahmanosama76856@gmail.com");
		signUpBtn.click();
	}
	
	public void enterAccountInformation() {
		maleGenderBtn.click();
		passwordTxt.sendKeys("123456789");
		
		Select makeDaysList = new Select(daysList);
		Select makemonthsList = new Select(monthsList);
		Select makeYearsList = new Select(yearsList);
		Select makeCountryList = new Select(countryList);
		
		makeDaysList.selectByIndex(25);
		makemonthsList.selectByValue("12");
		makeYearsList.selectByVisibleText("2000");
		
		newsLetterBtn.click();
		specialOffersBtn.click();
		
		firstNameTxt.sendKeys("Abdelrahman");
		lastNameTxt.sendKeys("Osama");
		
		companyTxt.sendKeys("Itworx");
		addressTxt1.sendKeys("fostat city");
		
		makeCountryList.selectByVisibleText("United States");
		stateTxt.sendKeys("Newyork");
		cityTxt.sendKeys("aaaafag");
		
		zipCodeTxt.sendKeys("1768952");
		mobileNumberTxt.sendKeys("01016549879");
		
		createAccountBtn.click();
	}
}

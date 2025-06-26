package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContactUsPageWithRobotWay extends PageBase {

	public ContactUsPageWithRobotWay(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="name")
	WebElement nameTxt;
	
	@FindBy(name="email")
	WebElement emailTxt;
	
	@FindBy(name="subject")
	WebElement subjectTxt;
	
	@FindBy(id="message")
	WebElement messageTxt;
	
	@FindBy(name="upload_file")
	WebElement uploadFileBtn;
	
	@FindBy(name="submit")
	WebElement submitBtn;
	
	@FindBy(css="#contact-page > div.row > div.col-sm-8 > div > h2")
	public WebElement getInMessage;
	
	@FindBy(xpath="//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")
	public WebElement successMessage;
	
	public void userCanContactUs(String name,String email,String subject,String message) throws AWTException, InterruptedException {
		nameTxt.sendKeys(name);
		emailTxt.sendKeys(email);
		subjectTxt.sendKeys(subject);
		messageTxt.sendKeys(message);
		
		///upload file
		String filePath = System.getProperty("user.dir")+"\\images\\messi.jpg.jpg";
	
//		uploadFileBtn.click(); cannot be used for input tag
		Actions builder = new Actions(driver);
		builder.click(uploadFileBtn).build().perform();
		
		StringSelection selection = new StringSelection(filePath);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		Robot robot = new Robot();
		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.delay(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);		
		
		submitBtn.click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
	}
	
}

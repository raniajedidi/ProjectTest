package PagesObjects;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POFormAuthenticationOnMenu {

	public WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='Form Authentication']")
	public WebElement FormAuthenticationLink;

	@FindBy(id = "username")
	WebElement usernameElement;

	@FindBy(id = "password")
	WebElement passwordElement;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement BtnLogin;

	@FindBy(xpath = "//a[@class='button secondary radius']")
	WebElement BtnLogout;

	@FindBy(xpath = "//div[@id='flash']")
	WebElement MsgElement;

	public POFormAuthenticationOnMenu(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void setUserName(String usernametxt) {

		usernameElement.sendKeys(usernametxt);

	}

	public void setUserPassword(String passwordtxt) {

		passwordElement.sendKeys(passwordtxt);

	}

	public void clickSubmit() {

		BtnLogin.click();

	}

	public void login(String usernametxt, String passwordtxt) {
		this.setUserName(usernametxt);
		this.setUserPassword(passwordtxt);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		this.clickSubmit();

	}

	public void ClickLogout() {

		BtnLogout.click();

	}

	public void AssertionResultKO(String errortxt) {

		String ActualResult = MsgElement.getText();
		if (ActualResult.contains(errortxt)) {

			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

// changer cette méthode en une méthode plus generique 
	
	public void AssertionResultOK(String ExpectedURL) {
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ExpectedURL, ActualURL);
		
	}
}
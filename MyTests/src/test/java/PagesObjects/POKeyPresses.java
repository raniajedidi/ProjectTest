package PagesObjects;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POKeyPresses {

	public WebDriver driver;
 
	@FindBy(xpath = "//a[normalize-space()='Key Presses']")
	public WebElement KeyPressesLink;
	
	@FindBy(xpath = "//body")
	public WebElement FormTextElement;

	@FindBy(xpath = "//p[@id='result']")
	public WebElement FormTextResult;

	public POKeyPresses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
//try to change it to a return method 

	public void setKey(String Keytxt) {

		FormTextElement.sendKeys(Keytxt);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		FormTextElement.sendKeys(Keys.ENTER);
	}

	public void getResultAssertion(String resulttxt) {

		System.out.println(FormTextResult.getText());
		assertEquals(resulttxt, FormTextResult.getText());
	}
	
}
package StepsDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PagesObjects.POFormAuthenticationOnMenu;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationStepDefinition {

	WebDriver driver;
	POFormAuthenticationOnMenu login1;

	String URlSecure = "http://the-internet.herokuapp.com/secure";
	String ErrorMsg = "Your password is invalid!";
	String URlExpectedLogOut = "http://the-internet.herokuapp.com/login";

	@Before
	public void initData() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jedidi Rania\\ChromeDriver\\chromedriver.exe");
		String URL = "http://the-internet.herokuapp.com/";
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();

	}

	@Given("^User is on the Login page$")
	public void user_is_on_the_login_page() throws Throwable {

		Thread.sleep(3000);

		login1 = new POFormAuthenticationOnMenu(driver);

		login1.FormAuthenticationLink.click();
		Thread.sleep(3000);

	}

	@When("^User enters (.+) and (.+)$")
	public void user_enters_and(String username, String password) throws Throwable {
		login1 = new POFormAuthenticationOnMenu(driver);
		login1.login(username, password);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Then("^User fails in login and an error message is shown$")
	public void user_fails_in_login_and_an_error_message_is_shown() throws Throwable {

		login1.AssertionResultKO(ErrorMsg);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Then("^User should be able to login sucessfully and a secure page opens$")
	public void user_should_be_able_to_login_sucessfully_and_a_secure_page_opens() throws Throwable {

		login1.AssertionResultOK(URlSecure);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@When("^User clicks on logout$")
	public void user_clicks_on_logout() throws Throwable {
		login1.ClickLogout();

	}

	@Then("^User returns to the login page$")
	public void user_returns_to_the_login_page() throws Throwable {

		login1.AssertionResultOK(URlExpectedLogOut);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {

		driver.close();
		driver.quit();

	}

}

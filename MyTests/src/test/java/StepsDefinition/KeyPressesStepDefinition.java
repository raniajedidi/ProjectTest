package StepsDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PagesObjects.POKeyPresses;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KeyPressesStepDefinition {
	
	WebDriver driver1;
	POKeyPresses key1;
	
	

	@Before
	public void initData() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jedidi Rania\\ChromeDriver\\chromedriver.exe");
		String URL = "http://the-internet.herokuapp.com/";
		driver1 = new ChromeDriver();
		driver1.get(URL);
		driver1.manage().window().maximize();
	
	}
	
	@Given("^User is on the key presses page$")
	public void user_is_on_the_key_presses_page() throws Throwable {
		Thread.sleep(3000);
		key1 = new POKeyPresses(driver1);
		key1.KeyPressesLink.click();
		Thread.sleep(3000);

	}

	@When("He enters a key \"([^\"]*)\" and he clicks ENTER$")
	public void he_enters_a_key_something_and_he_clicks_enter(String strArg1) throws Throwable {

		
		key1.setKey(strArg1);

	}

	@Then("^a msg text is shown \"([^\"]*)\"$")
	public void a_msg_text_is_shown_something(String strArg2) throws Throwable {

		key1.getResultAssertion(strArg2);
		Thread.sleep(3000);

	}
	
	@After
	public void tearDown() {
		
		driver1.close();
		driver1.quit();

	}
}


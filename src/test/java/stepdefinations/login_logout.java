package stepdefinations;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class login_logout {

	WebDriver driver = null ;

	@Given("open browser")
	public void open_browser() {

		//relative path
		String projectpath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver",projectpath + "/src/test/resources/driver/chromedriver");

		driver = new ChromeDriver();


		System.out.print("user successfully able to open the browser");
	}

	@When("navigated to LinkedIn login page")
	public void navigated_to_linkedin_login_page() {

		driver.navigate().to("https://www.linkedin.com/login");

		//managing timeouts
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//manage pageloads
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		System.out.print("user successfully navigated to login page");

	}

	@Then("locate on SignIn on home page")
	public void click_on_signin_on_home_page() {

		System.out.print("user successfully located the SignIn Button on home page");

	}

	@When("provide login credentials with user_email and user_password")
	public void provide_login_details_emailorphone_and_userpassword() {

		//username textbox
		driver.findElement(By.id("username")).sendKeys("<linkedin_username>");

		//managing timeouts
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//password textbox
		driver.findElement(By.id("password")).sendKeys("<password>");

		//managing timeouts
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.print("user successfully provided username and password to login page");


	}

	@Then("click on SignInbutton")
	public void click_on_sign_inbutton() {

		driver.findElement(By.xpath("//*[@id=\"app__container\"]/main/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);

		//manage pageloads
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		System.out.print("user successfully click and login into the linkedin site");

	}

	@When("locate search_box and search user_profile")
	public void from_home_page_locale_search_box() {

		//manage pageloads
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		//search name in file
		driver.findElement(By.xpath("//*[@id=\"ember16\"]/input")).sendKeys("Profectus Kamaljeet");

		//manage pageloads
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		System.out.print("user successfully located search_box");
	}

	@Then("click on user_profile")
	public void user_profile_found() {

		//managing timeouts
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"ember16\"]/input")).sendKeys(Keys.ENTER);

		System.out.print("user_profile located");
	}

	@And("provide custom message in the text_box")
	public void provide_custom_message_in_the_textbox() {

		//managing timeouts
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//click connect button
		driver.findElement(By.xpath("//button[contains(@id,\"ember\")]/span[text()='Connect']")).click();


		//managing timeouts
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//locate and open message box
		driver.findElement(By.xpath("//*[text()='Add a note']")).click();

		//managing timeouts
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.print("successfully opened message box");

		//managing timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String message = "Hello, Kamaljeet. This is the auto message from Vivek";

		//Provide message to the custom message
		driver.findElement(By.xpath("//*[@id=\"custom-message\"]")).sendKeys(message);
	}

	@When("click on send button and message send")
	public void send_message() {

		//manage pageloads
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[span[text()='Send']]")));

		driver.findElement(By.xpath("//button[span[text()='Send']]")).click();

	}

	@Then("logout and close browser")
	public void logout_and_close_browser() {

		//locate profile page and click signout 
		driver.findElement(By.xpath("//button[contains(@id,\"ember\")]/span[text()='Me']")).click();

		driver.findElement(By.xpath("//a[contains(@href,\"logout\")]")).click();

		System.out.print("user successfully Signout of linked");
		
		//close the driver
		driver.close();


	}

}

package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import StepDefinations.pageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Applicationdemo {
		WebDriver driver=null;
		
		
	@Given("When user loads application URL")
	public void when_user_loads_application_url() {
		
		System.setProperty("webdriver.chrome.driver", "servers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.exercise1.com/values");
		
	   
	}

	@When("verify the right count of values appear on the screen")
	public void verify_the_right_count_of_values_appear_on_the_screen() {
		pageObjects objects= new pageObjects(driver);
		objects.Countlabels();
	}

	@Then("verify the values on the screen are greater than {int}")
	public void verify_the_values_on_the_screen_are_greater_than(Integer int1) throws Exception {
		pageObjects objects= new pageObjects(driver);
		objects.PrintvaluesGreaterThenZero();
	}

	@Then("verify the total balance is correct based on the values listed on the screen")
	public void verify_the_total_balance_is_correct_based_on_the_values_listed_on_the_screen() throws Exception {
		pageObjects objects= new pageObjects(driver);
		objects.Verifytotalbalance();
	}

	@Then("verify the values are formatted as currencies")
	public void verify_the_values_are_formatted_as_currencies() throws Exception {
		pageObjects objects= new pageObjects(driver);
		objects.currencyvalidator();
		
	}

	@Then("verify the total balance matches the sum of the values")
	public void verify_the_total_balance_matches_the_sum_of_the_values() throws Exception {
		pageObjects objects= new pageObjects(driver);
		objects.Verifytotalbalance();
	}

	
	
}

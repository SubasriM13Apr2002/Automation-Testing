package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class LoginDemo {
	WebDriver driver=null;
	@Given("Browser is open")
	public void browser_is_open(){
		System.out.println("Inside step-browser is open");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@And("User is on login page")
	public void user_is_on_login_page() throws InterruptedException{
		driver.navigate().to("https://www.google.com/search?q=amzon&oq=amzon&aqs=chrome..69i57j69i64j46i10i131i199i433i465i512j0i10i131i433i512l4j0i10i433i512.4894j0j15&sourceid=chrome&ie=UTF-8&dlnr=1&sei=QpT-ZOy9L_OSseMP9raNoAM");
		driver.findElement(By.xpath("//span[contains(text(),'Shop online at Amazon India - Great deals on Amazo')]")).click();
		System.out.println("clicks on 1st link");
		driver.manage().window().maximize();
		System.out.println("It maximizes the window");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		System.out.println("clicks on account section");
	}
	@When("^User enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(username);
		Thread.sleep(1000);
		System.out.println("Enters mail-id");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(password);
		Thread.sleep(1000);
		System.out.println("Enters password");
	}
	@And("User clicks on login")
	public void user_clicks_on_login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		Thread.sleep(1000);
		System.out.println("clicks on Sign-In");
	}
	@Then("Performing log-out")
	public void perform_logout() throws InterruptedException {
		Actions act = new Actions(driver);//for placing mouse over 'Music'
        WebElement option = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
    	act.moveToElement(option).perform();// it performs action of placing mouse over 'Music'
    	System.out.println("Done Mouse hover on account");
    	driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
    	System.out.println("finally log-outs from an amazon account");
    	//driver.close();
		//driver.quit();
	}
	
}

package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class demoQA {
	WebDriver driver=null;
	@Given("Browser is open")
	public void opening_the_browser() {
		System.out.println("Browser is open");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@And("Entering into DemoQA site and scrolling down")
	public void entering_the_site() throws InterruptedException{
		driver.navigate().to("https://www.google.com/search?q=demoqa&sca_esv=567523571&sxsrf=AM9HkKlLRCiSQ5l_lil0BEKsWlEIZWnIvw%3A1695377525371&ei=dWgNZbqcFsHT1e8PtfWCgAE&oq=&gs_lp=Egxnd3Mtd2l6LXNlcnAiACoCCAAyBxAjGOoCGCcyBxAjGOoCGCcyBxAjGOoCGCcyBxAjGOoCGCcyBxAjGOoCGCcyBxAjGOoCGCcyBxAjGOoCGCcyBxAjGOoCGCcyBxAjGOoCGCcyBxAjGOoCGCcyFhAAGAMYjwEY5QIY6gIYtAIYjAPYAQEyFhAAGAMYjwEY5QIY6gIYtAIYjAPYAQEyFhAAGAMYjwEY5QIY6gIYtAIYjAPYAQEyFhAAGAMYjwEY5QIY6gIYtAIYjAPYAQEyFhAAGAMYjwEY5QIY6gIYtAIYjAPYAQEyFhAAGAMYjwEY5QIY6gIYtAIYjAPYAQEyFhAAGAMYjwEY5QIY6gIYtAIYjAPYAQEyFhAAGAMYjwEY5QIY6gIYtAIYjAPYAQEyFhAAGAMYjwEY5QIY6gIYtAIYjAPYAQEyFhAAGAMYjwEY5QIY6gIYtAIYjAPYAQFIlR1QAFgAcAJ4AZABAJgBAKABAKoBALgBA8gBAPgBAagCFOIDBBgAIEGIBgG6BgYIARABGAs&sclient=gws-wiz-serp");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h3[contains(text(),'DEMOQA')]")).click();
		//Scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
	}
	@When("Clicking forms wizard and also clicking the practice forms which is on the left panel")
	public void forms() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]")).click();
		Thread.sleep(1000);
	}
	@When("Entering the firstname and lastname")
	public void entering_the_name() throws InterruptedException{
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Subasri");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("M");
		Thread.sleep(1000);
	}
	@And("Clicking female button- radio buttton")
	public void radio_button() throws InterruptedException{
		driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
		Thread.sleep(1000);
	}
	@And("Clicking sports,reading and music button-checkbox")
	public void checkbox() throws InterruptedException{
		driver.findElement(By.xpath("//label[contains(text(),'Sports')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("xpath(\"//label[contains(text(),'Reading')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Music')]")).click();
		Thread.sleep(1000);
	}
	@Then("Navigating to the home page 2 times")
	public void navigating_to_homepage() throws InterruptedException{
		driver.navigate().to("https://demoqa.com/");
		Thread.sleep(1000);
	}
	@Then("Scroll and select widgets and also select Select Menu in the left panel")
	public void drop_down_opertion() throws InterruptedException{
		// Scroll
		JavascriptExecutor ks = (JavascriptExecutor) driver;
		ks.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h5[contains(text(),'Widgets')]")).click();
		Thread.sleep(1000);
		// Scroll
		JavascriptExecutor ls = (JavascriptExecutor) driver;
		ls.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Select Menu')]")).click();
		Thread.sleep(1000);
	}
	@And("Click on colour select menu and click purple")
	public void selecting_1_color() throws InterruptedException{
		Select color = new Select(driver.findElement(By.id("oldSelectMenu")));
		color.selectByVisibleText("Purple");
		color.selectByIndex(5);
	}
	@And("Going back to the homepage")
	public void returning_back_to_homepage() throws InterruptedException{
		driver.navigate().to("https://demoqa.com/");
		
	}
}

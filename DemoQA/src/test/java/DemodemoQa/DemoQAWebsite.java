package DemodemoQa;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQAWebsite {
	private WebDriver driver;
    private String username;
    private String password;
    
	@Test
	public void forms_first_and_lastname() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/search?q=demoqa&oq=demoqa&aqs=chrome.0.69i59l3j0i512l7.4097j0j15&sourceid=chrome&ie=UTF-8");// Search on google for demoqa
		Thread.sleep(1000);// It waits for 1sec and performs next operation
		driver.manage().window().maximize();// Maximizes the window
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h3[contains(text(),'DEMOQA')]")).click();// Clicks on 1st link for DemoQA.com
		// Scroll
		JavascriptExecutor ls = (JavascriptExecutor) driver;
		ls.executeScript("window.scrollBy(0,250)", "");// Scroll by 250 vertically - x axis
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div[1]")).click();// Clicking the Forms wizard
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]")).click();// Clicking the Practice Form inside Forms
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Subasri");// Typing first name in Text box
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("M");// Typing last name in Text box 
		Thread.sleep(1000);
	}
	
	@Test(priority = 1)
	public void radio_and_checkbox_buttons() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");// In the page of Practice Form
		JavascriptExecutor ls = (JavascriptExecutor) driver;
		ls.executeScript("window.scrollBy(0,250)", "");// Scroll by 250 in x-axis
		driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();// Clicking Female radio button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Sports')]")).click();// Clicking Sports check box
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Reading')]")).click();// Clicking Reading check box
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Music')]")).click();// Clicking Music check box
		Thread.sleep(1000);
	}
	
	
	@Test(priority = 2)
	public void widgets_SelectMenu() throws InterruptedException{
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/");// It is back to the home page
		Thread.sleep(1000);
		JavascriptExecutor ls = (JavascriptExecutor) driver;
		ls.executeScript("window.scrollBy(0,250)", "");// Scrolling down at 250
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h5[contains(text(),'Widgets')]")).click();// Click widgets
		Thread.sleep(1000);
		JavascriptExecutor ms = (JavascriptExecutor) driver;
		ms.executeScript("window.scrollBy(0,500)", "");// Again scroll down by 500
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Select Menu')]")).click();// Click select menu
		Thread.sleep(1000);
	}
	@Test(priority=3)
	public void dropDown_colors() throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");// In the select menu page
		Thread.sleep(1000);
		JavascriptExecutor ms = (JavascriptExecutor) driver;
		ms.executeScript("window.scrollBy(0,400)", "");// Scroll by 400 down
		Thread.sleep(1000);
		Select color = new Select(driver.findElement(By.id("oldSelectMenu")));// Click old select menu
		color.selectByVisibleText("Purple");// Select purple color
		color.selectByIndex(5);// Then select black color
		Thread.sleep(1000);
		
	}
	@Test(priority=4)
	public void login_check_amazon_homepage() throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/search?q=amzon&oq=amzon&aqs=chrome..69i57j69i64j46i10i131i199i433i465i512j0i10i131i433i512l4j0i10i433i512.4894j0j15&sourceid=chrome&ie=UTF-8&dlnr=1&sei=QpT-ZOy9L_OSseMP9raNoAM");// Getting into google page
		Thread.sleep(1000);
		JavascriptExecutor ms = (JavascriptExecutor) driver;
		ms.executeScript("window.scrollBy(0,600)", "");// Scroll by 600 down
		driver.findElement(By.xpath("//h3[contains(text(),'Amazon.in')]")).click();// Click amazon.in
		System.out.println("clicks on 2nd link");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		System.out.println("It maximizes the window");// Maximize the current window
		Thread.sleep(1000);
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();// Click on account section to log-in
		System.out.println("clicks on account section");
		Thread.sleep(1000);
	}
	@Test(priority=5)
	public void read_data_from_excel() {
		
		String excelFilePath = "src/test/java/ExcelData/Login.xlsx";// Read the excel sheet to enter user name and password in amazon login

        try (FileInputStream fis = new FileInputStream(excelFilePath);

            XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(1);
            username = row.getCell(0).getStringCellValue();
            password = row.getCell(1).getStringCellValue();

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	@Test(priority=6)
    public void Sign_In_amazon_page() {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		WebElement emailField = driver.findElement(By.xpath("//input[@id='ap_email']"));//Enters user name from excel
        emailField.sendKeys(username);
        WebElement nextButton = driver.findElement(By.id("continue"));// Clicks continue
        nextButton.click();
        WebElement pass=driver.findElement(By.xpath("//input[@id='ap_password']"));// In the password page and writes password from excel
        pass.sendKeys(password);
        WebElement next = driver.findElement(By.xpath("//input[@id='signInSubmit']"));// Sign-in is done by clicking sign-in button
        next.click();
	}
}


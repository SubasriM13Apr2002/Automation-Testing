package LoginDemoExcel;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;


public class Login {
	
	private WebDriver driver;
    private String username;
    private String password;
    
    @Test
    public void iNavigateToGmailLoginPage() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
       
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/search?q=amzon&oq=amzon&aqs=chrome..69i57j69i64j46i10i131i199i433i465i512j0i10i131i433i512l4j0i10i433i512.4894j0j15&sourceid=chrome&ie=UTF-8&dlnr=1&sei=QpT-ZOy9L_OSseMP9raNoAM");
		driver.findElement(By.xpath("//span[contains(text(),'Shop online at Amazon India - Shopping Made Conven')]")).click();
		System.out.println("clicks on 1st link");
		driver.manage().window().maximize();
		System.out.println("It maximizes the window");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		System.out.println("clicks on account section");

    }
    @Test(priority=1)
    public void iEnterGmailUsernameAndPasswordFromExcel() {

        String excelFilePath = "src/test/java/ExcelData/Login.xlsx";

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
    @Test(priority=2)
    public void iClickGmailLoginButton() {
    	
        WebElement emailField = driver.findElement(By.xpath("//input[@id='ap_email']"));
        emailField.sendKeys(username);
        WebElement nextButton = driver.findElement(By.id("continue"));
        nextButton.click();
        WebElement pass=driver.findElement(By.xpath("//input[@id='ap_password']"));
        pass.sendKeys(password);
        WebElement next = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
        next.click();

    }

}

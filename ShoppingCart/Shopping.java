package ShoppingCart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Shopping {
	
	WebDriver driver;
	ExtentReports Reports;
	ExtentTest test;
	SoftAssert soft = new SoftAssert();
	
	
	@BeforeMethod
	public void setup()
	{
	
	System.setProperty("webdriver.chrome.driver", "chromedriver");
    
    driver = new ChromeDriver();
    
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    
    Reports = new ExtentReports("ExtentReport.html");
   
	}
	
	@Test
	@Parameters({"Username","Password"})
	
	public void LoginPass(String uname,String pword)
	{
	
		test = Reports.startTest("Logintestcase");
		
      
        
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys(uname);
        
        test.log(LogStatus.PASS, "Successfully passed the Username");
        
        WebElement Password =driver.findElement(By.id("password"));
        Password.sendKeys(pword);
        
        test.log(LogStatus.PASS, "Successfully passed the Password");
        
        
		
		WebElement Login = driver.findElement(By.name("login-button"));
		
		Login.click();
		
		test.log(LogStatus.PASS, "Successfully clicked on login link");

      
	}
	
	@Test(dependsOnMethods="LoginPass")
	@Parameters({"Username","Password"})
	
	
	public void AddtoCart(String uname,String pword)
	
	{
		WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys(uname);
        
        test.log(LogStatus.PASS, "Successfully passed the Username");
        
        WebElement Password =driver.findElement(By.id("password"));
        Password.sendKeys(pword);
        
        test.log(LogStatus.PASS, "Successfully passed the Password");
        
        
		
		WebElement Login = driver.findElement(By.name("login-button"));
		
		Login.click();
		
		test.log(LogStatus.PASS, "Successfully clicked on login link");
		
		WebElement AddinCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		
		AddinCart.click();
		
		test.log(LogStatus.PASS, "Successfully clicked on login link");
		
		WebElement CartResult = driver.findElement(By.xpath("//*[@class='shopping_cart_badge']"));
    	System.out.println(" CartResult: " + CartResult.getText());
    	
    	
		
		
		
	}
	
	@AfterMethod
	public void setupClose()
	{
		Reports.endTest(test);
		Reports.flush();
		driver.quit();
		soft.assertAll();
		
	}

}

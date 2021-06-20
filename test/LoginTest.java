package test;

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

public class LoginTest {
	
	WebDriver driver;
	ExtentReports Reports;
	ExtentTest test;
	SoftAssert soft = new SoftAssert();
	
	
	@BeforeMethod
	public void setup()
	{
	
	System.setProperty("webdriver.chrome.driver", "chromedriver");
    
    driver = new ChromeDriver();
    
    driver.get("https://www.simplilearn.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    
    Reports = new ExtentReports("ExtentReport.html");
   
	}
	
	@Test
	@Parameters({"Username","WrPassword"})
	
	public void LoginPass(String uname,String pword)
	{
	
		test = Reports.startTest("Logintestcase");
		
        WebElement Loginlink = driver.findElement(By.linkText("Log in"));
        Loginlink.click();
        
        test.log(LogStatus.PASS, "Successfully clicked on the login button");
        
        WebElement username = driver.findElement(By.name("user_login"));
        username.sendKeys(uname);
        
        test.log(LogStatus.PASS, "Successfully passed the Username");
        
        WebElement Password =driver.findElement(By.id("password"));
        Password.sendKeys(pword);
        
        test.log(LogStatus.PASS, "Successfully passed the Password");
        
        WebElement Rememberme = driver.findElement(By.className("rememberMe"));
		
		Rememberme.click();
		
		WebElement Login = driver.findElement(By.name("btn_login"));
		
		Login.click();
		
		test.log(LogStatus.PASS, "Successfully clicked on login link");

        
		System.out.println("Size of Window is :"+driver.manage().window().getSize());
        
        
		WebElement Error = driver.findElement(By.id("msg_box"));
        
        String ActMsg = Error.getText();
        String ExpMsg = "The email or password you have entered is invalid";
                
        Assert.assertTrue(Error.isDisplayed());
        
        soft.assertEquals(ActMsg, ExpMsg);
		
		System.out.println("After Soft Assert");
        
       /* try {
            Assert.assertEquals(ActMsg, ExpMsg);
            test.log(LogStatus.PASS, "Expected and Actual value matches");
            
        }catch(Throwable e) {
            test.log(LogStatus.FAIL, "Expected and Actual value does not match");
        }*/

		soft.assertEquals(ActMsg, ExpMsg);
		
		System.out.println("After Soft Assert");
	}
	
	@Test
	@Parameters({"Username","Password"})
	
	public void Login(String uname,String pword)
	{
	
		test = Reports.startTest("Logintestcase");
		
        WebElement Loginlink = driver.findElement(By.linkText("Log in"));
        Loginlink.click();
        
        test.log(LogStatus.PASS, "Successfully clicked on the login button");
        
        WebElement username = driver.findElement(By.name("user_login"));
        username.sendKeys(uname);
        
        test.log(LogStatus.PASS, "Successfully passed the Username");
        
        WebElement Password =driver.findElement(By.id("password"));
        Password.sendKeys(pword);
        
        test.log(LogStatus.PASS, "Successfully passed the Password");
        
        WebElement Rememberme = driver.findElement(By.className("rememberMe"));
		
		Rememberme.click();
		
		WebElement Login = driver.findElement(By.name("btn_login"));
		
		Login.click();
		
		test.log(LogStatus.PASS, "Successfully clicked on login link");

        
		System.out.println("Size of Window is :"+driver.manage().window().getSize());
        
        
		WebElement Error = driver.findElement(By.id("msg_box"));
        
        String ActMsg = Error.getText();
        String ExpMsg = "The email or password you have entered is invalid";
                
        Assert.assertTrue(Error.isDisplayed());
        
        soft.assertEquals(ActMsg, ExpMsg);
		
		System.out.println("After Soft Assert");
        
       /* try {
            Assert.assertEquals(ActMsg, ExpMsg);
            test.log(LogStatus.PASS, "Expected and Actual value matches");
            
        }catch(Throwable e) {
            test.log(LogStatus.FAIL, "Expected and Actual value does not match");
        }*/

		soft.assertEquals(ActMsg, ExpMsg);
		
		System.out.println("After Soft Assert");
       
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

package Ravi.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import ElementRepositary.LoginLocators;

public class BaseClass {
	
	public WebDriver driver;
	public DataUtlity du = new DataUtlity();
	public CommanUtility cu = new CommanUtility();
	public static WebDriver Listenerdriver;
	
	@BeforeClass(alwaysRun=true)
	public void launchBrowser() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(opt);
		Listenerdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	//@Parameters({"username","password"})
	@BeforeMethod(alwaysRun=true)
	public void login() throws IOException
	{

		driver.get(du.getDataFromProperties("url"));
		LoginLocators ll = new LoginLocators(driver);
		ll.loginApp(du.getDataFromProperties("username"),du.getDataFromProperties("password"));
	}
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	@AfterClass
	public void close()
	{
		driver.close();
	}

}
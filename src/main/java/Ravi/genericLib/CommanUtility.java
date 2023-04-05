package Ravi.genericLib;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.awt.Window;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class CommanUtility {
	
	public int getRandomNum(int range)
	{
	Random r=new Random();
	int num=r.nextInt(range);
	return num;
	}
	public String getMsgFromAlert(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		String msg=alt.getText(); 
		return null;
	}
	public void alertOK(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	public void alertCancel(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
		
	}
	
	public void getSelectByIndex(WebElement dropdown,int index)
	{
		Select s = new Select(dropdown);
		s.selectByIndex(index);
	}
	public void getVisivalText(WebElement dropdown,String Text)
	{
		Select s=new Select(dropdown);
		s.selectByVisibleText(Text);
	}
	
	public void getScrollBy(WebDriver driver,int x ,int y)
	{
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("Window.ScrollBy(x,y)");
	}
	public void getMoveToElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void getContextClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	public void getSoftAssert(WebDriver driver,WebElement actual,WebElement expected)
	{
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, expected);
		System.out.println("pass");
		sa.assertAll();
	}
	


}
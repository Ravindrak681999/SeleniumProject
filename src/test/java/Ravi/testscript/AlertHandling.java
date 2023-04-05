package Ravi.testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Ravi.genericLib.BaseClass;

public class AlertHandling  extends BaseClass {
	@Test
	public void alertHandlingPopup() throws InterruptedException {
		
	driver.findElement(By.xpath("//div[contains(@class,'popup_menu_button popup_menu_button_settings')]/div/div[1]")).click();
	driver.findElement(By.xpath("//a[text()='Leave Types']")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Create Leave Type')]")).click();
	driver.findElement(By.id("leaveTypeLightBox_nameField")).sendKeys("Aman");
	driver.findElement(By.id("leaveTypeLightBox_cancelBtn")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.alertIsPresent());
	cu.alertOK(driver);
	}

}



package Ravi.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.checkerframework.framework.qual.DefaultQualifier.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Ravi.genericLib.BaseClass;
import Ravi.genericLib.CommanUtility;

@Listeners(Ravi.genericLib.ListenerImplementation.class)
public class CustomerCreation extends BaseClass{
	
	@Test
	public void customerCreation() throws EncryptedDocumentException, IOException
	{
		
		int num=cu.getRandomNum(10000);
		String custName=du.getDataFromExcelSheet("sheet1",3,1);
		custName=custName+num;
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.className("addNewButton")).click();
		driver.findElement(By.className("createNewCustomer")).click();
		driver.findElement(By.className("newNameField")).sendKeys(custName);
		driver.findElement(By.xpath("//div[text()='Create ']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='titleEditButtonContainer']/div[1]"), custName));
		String expcustomername = driver.findElement(By.xpath("//div[@class='titleEditButtonContainer']/div[1]")).getText();
		System.out.println(expcustomername);
		
		
	}


}

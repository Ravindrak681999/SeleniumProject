package Ravi.testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Ravi.genericLib.BaseClass;


public class Dropdownhandle2 extends BaseClass {
	
	
	@Test
	public void dropdownHandling() throws IOException {
		
		driver.findElement(By.xpath("//div[@class='menuTable']/div[2]/descendant::div[@class='menu_icon']")).click();
		driver.findElement(By.xpath("//div[text()='Manage system settings & configure actiTIME']")).click();
		WebElement dropdown=driver.findElement(By.id("firstHierarchyLevelCodeSelect"));
		cu.getSelectByIndex(dropdown, 4);
		String msg = driver.findElement(By.id("FormModifiedTextCell")).getText();
		System.out.println(msg);
		Reporter.log(msg,true);
		String expmsg = "MODIFICATIONS NOT SAVED";
		AssertJUnit.assertEquals(expmsg, msg);
		System.out.println("dropdown Tc Is Pass");
		
		
	}

	
	

}

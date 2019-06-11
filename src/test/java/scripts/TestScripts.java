package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic.BasePage;
import generic.BaseTest;
import generic.Excel;
import generic.GenericUtils;
import pom.HomePage;

public class TestScripts extends BaseTest{
	@Test(enabled=false)
	public void testCreateEmployee() {
		HomePage pi=new HomePage(driver);
		pi.setUserName("Admin");
		pi.setPwd("admin123");
		pi.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		pi.clickPimMenu();
		pi.clickAddEmp();
		pi.setFirstName("Kevin");
		pi.setLastName("fernandes");
		pi.clickSaveBtn();
		pi.verifyFirstname("Kevin");
		
		
	}
	@Test(enabled=true)
	public void  testSortListBox() throws EncryptedDocumentException, IOException {
		HomePage pi=new HomePage(driver);
		pi.setUserName(Excel.readData("Sheet1", 0, 1));
		pi.setPwd(Excel.readData("Sheet1", 1, 1));
		pi.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		pi.clickPimMenu();
		pi.clickEmpList();
		GenericUtils.sortListBox(driver.findElement(By.xpath("//select[@id='empsearch_job_title']")));
		
	}

}

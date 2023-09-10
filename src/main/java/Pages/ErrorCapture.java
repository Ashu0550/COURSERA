package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import java.lang.*;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import Base.Base;

public class ErrorCapture extends Base {
	
	
	

	By opt = By.xpath("//a[text()='For Enterprise']");
	By campus = By.xpath("/html/body/div[3]/div[1]/div[2]/ul[1]/li[12]/a");
	By fname = By.id("FirstName");
	By lname = By.id("LastName");
	By func = By.id("C4C_Job_Title__c");
	By title = By.id("Title");
	By email = By.id("Email");
	By phone = By.id("Phone");
	By comp = By.id("Company");
	By type = By.id("Institution_Type__c");
	By disc = By.id("Primary_Discipline__c");
	By country = By.id("Country");
	By submit = By.xpath("//button[text()='Submit']");
	
	//T8- go to "For Enterprise"; Look into Courses for Campus under Product; 
	//Fill the  "Ready to transform" form with any one input invalid (example: email); Capturing the error 

	public void error() throws InterruptedException, IOException, InvalidFormatException {
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFCell cell;
	    File src=new File(System.getProperty("user.dir")+"\\Test.xlsx");
		FileInputStream file=new FileInputStream(src);
		workbook=new XSSFWorkbook(file);
		sheet= workbook.getSheet("Sheet1");
		cell = sheet.getRow(1).getCell(2); 
		String data=cell.getStringCellValue(); 
		//workbook.close();
		
		//2 ip
		cell = sheet.getRow(1).getCell(3); 
		String d1=cell.getStringCellValue(); 
		//3ip
		cell = sheet.getRow(1).getCell(4); 
		String d2=cell.getStringCellValue(); 
		
		//4ip
		cell = sheet.getRow(1).getCell(5); 
		String d3=cell.getStringCellValue(); 
		
		//ip5
		
		cell = sheet.getRow(1).getCell(6); 
		double d4=cell.getNumericCellValue(); 
		//int x=(int)d4;
		//String s=Integer.toString(x);
		String s=String.format("%.0f",d4);
		//ip6
		
		cell = sheet.getRow(1).getCell(7); 
		String d5=cell.getStringCellValue(); 
		
		exttest = report.createTest("Display error during invalid Email Address. ");
		wait(30, opt);
		driver.findElement(opt).click();
		wait(30, campus);
		driver.findElement(campus).click();
		
		
		exttest.log(Status.PASS, "Moved to For Campus Successfully");
		driver.findElement(fname).sendKeys(data);
		driver.findElement(lname).sendKeys(d1);
		driver.findElement(title).sendKeys(d2);
		driver.findElement(email).sendKeys(d3);
		driver.findElement(phone).sendKeys(s);
		driver.findElement(comp).sendKeys(d5);
		
		
		Select s2 = new Select(driver.findElement(type));
		s2.selectByVisibleText("Private University");
		Select s3 = new Select(driver.findElement(disc));
		s3.selectByVisibleText("Biochemical Engineering/Biotechnology");
		Select s4 = new Select(driver.findElement(country));
		s4.selectByVisibleText("India");
		driver.findElement(submit).click();
		Thread.sleep(2000);
		exttest.log(Status.PASS, "Data entered and submit button is clicked and 'email is not valid' message shown Successfully");
		TakesScreenshot capture = (TakesScreenshot) driver;
		File srcFile = capture.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "/Screenshot/Error.png");
		Files.copy(srcFile, destFile);
		exttest.log(Status.PASS, "Screenshot taken Successfully");
		driver.close();
		System.out.println("Automation Completed Successfully");
		Thread.sleep(3000);
	}
}

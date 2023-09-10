package Pages;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.Base;

public class LangLearn extends Base {
	By search = By.xpath(
			"//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/div[1]/input");
	By button = By.xpath(
			"//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div");
	By lang = By.xpath("//div[text()='Language']");
	By more = By.xpath("(//span[text()='Show more'])[4]");
	By langs = By.xpath("//div[@aria-label='Select Language options']/div/div/label/span[2]");
	By close = By.xpath("//span[text()='Close']");
	By level = By.xpath("//fieldset/div/div/div/div/label/span[2]");

	
		
		//T5-Searing For Language Learning 
		public void SearchForLanguageLearning()
		{
			
		
		exttest = report.createTest("Extract all languages and levels with counts for Learning Language. ");
		wait(50, search);
		driver.findElement(search).sendKeys("Learning Language");
		driver.findElement(button).click();
		driver.findElement(more).click();
		}
		//T6-extracting all languages
		public void AllLanguages()
		{
		System.out.println("");
		System.out.println("The languages are: ");
		System.out.println("");
		List<WebElement> langsall = driver.findElements(langs);
		for (int j = 0; j < langsall.size(); ++j) {
			System.out.println(langsall.get(j).getText());
		}
		driver.findElement(close).click();
		exttest.log(Status.PASS, "All Languages are extracted Successfully");
		}
		
		//T7-extracting all different levels
		
		public void AllLevels() throws InterruptedException
		{
		System.out.println("");
		System.out.println("The levels are: ");
		System.out.println("");
		List<WebElement> labels = driver.findElements(level);
		for (int j = 8; j < 12; ++j) {
			System.out.println(labels.get(j).getText());
		}
		exttest.log(Status.PASS, "All levels are extracted Successfully");
		Thread.sleep(3000);
	}
}

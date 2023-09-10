package Pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.Base;

public class Courses extends Base {
	By search = By.xpath(
			"//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/div[1]/input");
	By button = By.xpath(
			"//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div");
	By apply = By.xpath("//span[text()='Apply']");
	By Beginner = By.xpath("//span[text()='Beginner']");
	By more = By.xpath("(//span[text()='Show more'])[4]");
	By english = By.xpath("//span[text()='English']");
	By name = By.xpath("//a/div/div[2]/h2");
	By rating = By.className("ratings-text");
	

	public void find() throws InterruptedException, IOException,ElementNotInteractableException {
		exttest = report.createTest("Display two courses for beginner Web Development. ");
		wait(50, search);
		
		//T1-Searching Web Development in the search Box
		
		driver.findElement(search).sendKeys("Web Development");
		driver.findElement(button).click();
	}
	public void applyBeginner() {
		//T2-Selecting Beginner Check Box in the filter section
		wait(50, Beginner);
		driver.findElement(Beginner).click();
		exttest.log(Status.PASS, "Beginners selected Successfully");
		
		//T3-Clicking on more button on Language Filter and Select English
		
	}
	public void applyEnglish() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(more).click();
		wait(50, english);
		driver.findElement(english).click();
		Thread.sleep(5000);
		driver.findElement(apply).click();
		exttest.log(Status.PASS, "English selected Successfully");
	}
	public void courseNameRating() throws InterruptedException
	{
		Thread.sleep(5000);
		wait(50, name);
		System.out.println("");
		
		//T4- First Two course name,rating and durtion checking
		System.out.println("The courses and their ratings are: ");
		System.out.println("");
		List<WebElement> names = driver.findElements(name);
		List<WebElement> ratings = driver.findElements(rating);
		for (int j = 0; j < 2; ++j) {
			System.out.println(names.get(j).getText() + " - " + ratings.get(j).getText());
		}
		exttest.log(Status.PASS, "Couses are displayed Successfully");
	}
	public void DurationOfCourse() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/ul/li[1]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div/main/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/ul/li[2]/div/div/a/div/div[2]/h2")).click();
		
		Set<String> window=driver.getWindowHandles();
		Iterator<String> iterator=window.iterator();
		String parentpage=iterator.next();
		String child1=iterator.next();
		String child2=iterator.next();
		driver.switchTo().window(child2);
		System.out.println("Total learning hour for Course 1: ");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div/div/div[5]/div[2]/div[1]/span")).getText());
		driver.switchTo().window(child1);
        
		System.out.println("Total learning hour for Course 2: ");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div/div/div[5]/div[2]/div[1]")).getText());
		driver.switchTo().window(parentpage);
		
		
		
		
		Thread.sleep(3000);
	}
}

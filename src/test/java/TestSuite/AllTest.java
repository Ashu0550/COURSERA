package TestSuite;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import java.lang.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import Base.Base;
import Pages.Courses;
import Pages.ErrorCapture;
import Pages.LangLearn;


public class AllTest extends Base {
	Courses obj=new Courses();
	LangLearn obj1=new LangLearn();
	ErrorCapture obj2=new ErrorCapture();
	
	
	@Test(priority=0)
	public void SearchingForWebDevelopment() throws InterruptedException, IOException, NoSuchElementException, TimeoutException, InvalidFormatException
	{
		obj1.driverSetup();
		obj1.openUrl();
		obj.find();
		
	}
	
    @Test(priority=1)
	public void ApplyingBeginnerAsFilter()
	{
		obj.applyBeginner();
	}
     
	@Test(priority=2)
	public void ApplyingEnglishAsFilter() throws InterruptedException
	{
		obj.applyEnglish();
	}
	@Test(priority=3)
	public void ExtraxtingCourseNameAndRating() throws InterruptedException
	{
		obj.courseNameRating();
	}
	@Test(priority=4)
	public void ExtractingDurationOfCourse() throws InterruptedException
	{
		obj.DurationOfCourse();
	}
	@Test(priority=5)
	public void SearchingForLanguageLearning() throws InterruptedException
	{
		obj1.openUrl();
		obj1.SearchForLanguageLearning();
	}
	
	@Test(priority=6)
	public void ExtractingAllLanguageAndLevel() throws InterruptedException
	{
		obj1.AllLanguages();
		obj1.AllLevels();
	}
	@Test(priority=7)
	public void capturingError() throws InvalidFormatException, InterruptedException, IOException
	{
		obj1.openUrl();
		obj2.error();
		obj1.closeBrowser();
		
	}
	
}

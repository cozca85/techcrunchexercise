package smokeTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class latestNews {
	
	WebDriver driver;
	String url = "https://techcrunch.com/";

	@Before
	public void setUp() throws Exception {
		System.out.println("Preparing the test");
		driver = utilities.DriverFactory.open("chrome");
	}
	

	@Test
	public void testVerifyAuthorAndImages() {
		System.out.println("Starting the test");
		driver.get(url);
		String actualTitle = driver.getTitle();
		System.out.println("ActualTitle  " + actualTitle);
		
		// 20 articles on the latest news and front page
		
		
		WebElement secondArticle = driver.findElement(By.xpath("//*[@id=\"tc-main-content\"]/div[2]/div/div/div/article[2]/header/h2/a"));
		System.out.println(secondArticle.getText());
		System.out.println(secondArticle.getAttribute("post-block__title__link"));
		
		List<WebElement> webElements = driver.findElements(By.xpath("//*[@id=\"tc-main-content\"]/div[2]/div/div/div/article"));
		System.out.println(webElements.size());
		System.out.println(webElements.get(1).getText());
		System.out.println(webElements.get(1).getAttribute("river-byline__authors"));
		System.out.println(webElements.get(1).findElement(By.tagName("img")).getAttribute("src"));
		System.out.println(webElements.get(1).findElement(By.className("river-byline__authors")).getText());
		
		//implement for loop to show which article is been verified
		
		for (WebElement element : webElements)
		{
			if(
			!element.findElement(By.tagName("img")).getAttribute("src").isEmpty() &&
			!element.findElement(By.className("river-byline__authors")).getText().isEmpty()
			)
			{
				System.out.println("The article has an author and an image" );
				assertTrue(true);
			}
			else 
			{
				System.out.println("One of the articles does not have an author and/or an image" );
				assertTrue(false);
			}
		}
		
		//System.out.println(webElements.get(1).getAttribute("aria-label").toString());
		//System.out.println(webElements.get(1).getAttribute("src").toString());
		
		//iterate over the list and for each webelement, there must be 
		//img
		// "river-byline__authors"
		//a href author
			
		//picture 
		//driver.findElement(By.xpath("//*[@id="tc-main-content"]/div[2]/div/div/div/article[5]/footer/figure/picture"));
		
		//author
		//*[@id="tc-main-content"]/div[2]/div/div/div/article[4]/header/div/div/span/span/a
		//*[@id="tc-main-content"]/div[2]/div/div/div/article[4]/header/div/div/span
		//*[@id="tc-main-content"]/div[2]/div/div/div/article[4]/header/div/div/span
		//*[@id="tc-main-content"]/div[2]/div/div/div/article[2]
		//*[@id="tc-main-content"]/div[2]/div/div/div/article[1]
		//*[@id="tc-main-content"]/div[2]/div/div/div/article[3]
		//*[@id="tc-main-content"]/div[2]/div/div/div/article[8]
		
		
	}
	
	@Test
	public void testVerifyDetailsofOneArticle() {
		//click on the first article
		//verify browser title is the same as the news title
		//verify the links ??
	}
	

	@After
	public void tearDown() throws Exception {
		System.out.println("Closing the driver");
		//driver.close();
	}

}
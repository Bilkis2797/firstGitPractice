package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest1 {
	//dynamic webelement example
			//ul[@class='cn cn-list-hierarchical-xs cn--idx-0 cn-container_0078BF5B-84EB-F655-A296-D869DCB9B186']/descendant::strong
			//article[@class='cd cd--card cd--article cd--idx-1 cd--large cd--vertical cd--has-siblings cd--has-media cd--media__image']//descendant::span[2]
			
	WebDriver driver;
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void loginTest() {
		//storing webelement
		
		//type name = value; to reuse it
		//Storing in WebElement class
		//List of element
		WebElement USER_NAME_ELEMENT= driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement PASSWORD_ELEMENT= driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SIGNIN_BUTTON_ELEMENT= driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		//h2[text()=' Dashboard '] or
	    //h2[contains(text(),'Dashboard')]
		
		//Storing in by class
		By USER_NAME_FIELD = By.xpath("//*[@id=\"username\"]");
		By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
		By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBOARD_HEADER_FIELD = By.xpath("//h2[contains(text(),' Dashboard ')]");
		
		USER_NAME_ELEMENT.clear();
	//	USER_NAME_ELEMENT.sendKeys("demo@techfios.com");
		
	//	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("demo@techfios.com");
		
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc1234");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
	   
		
		boolean pageTitleDisplayStatus;
		try {
			WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));
			pageTitleDisplayStatus = true;
		}catch(Exception e) {
			pageTitleDisplayStatus = false;
			e.printStackTrace();
		}
		//explicit wait
		//WebDriverWait Wait= new WebDriverWait(driver, 15);
		//Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(DASHBOARD_HEADER_FIELD));
		 
		
		//Assert.assertTrue("Dashboard page not found!!", DASHBOARD_HEADER_ELEMENT.isDisplayed());
		Assert.assertTrue("Dashboard page not found!!", pageTitleDisplayStatus);
	
	
	
		
	}
	

}

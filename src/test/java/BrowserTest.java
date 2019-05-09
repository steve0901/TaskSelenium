import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BrowserTest {
	final Logger LOGGER = LogManager.getLogger(BrowserTest.class);

	WebDriver driver;

	@Test
	public void testSearhcImages() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.yahoo.com/");
		WebElement searchBar = driver.findElement(By.name("p"));
		searchBar.sendKeys("Apple");
		searchBar.submit();
		LOGGER.info("Title is : " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Apple - Yahoo Search Results");
		WebElement images = driver.findElement(By.xpath(("//a[@class=' t1 c-black-h td-n td-n-h c-dgray' and contains(text(),'Images')]")));
		images.click();
		LOGGER.info("Title is : " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Apple - Yahoo Image Search Results");

	}

	@AfterTest
	public void setDown() {
		driver.quit();
	}
}
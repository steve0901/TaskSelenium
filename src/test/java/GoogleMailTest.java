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

public class GoogleMailTest {
	final Logger LOGGER = LogManager.getLogger(BrowserTest.class);

	WebDriver driver;

	@Test
	public void sendLetterTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://mail.google.com/");
		WebElement loginInputBar = driver.findElement(By.id("identifierId"));
		loginInputBar.sendKeys("tester.toster2019@gmail.com");
		WebElement nextButton = driver.findElement(By.id("identifierNext"));
		nextButton.click();
		WebElement passwordInputBar = driver.findElement(By.name("password"));
		passwordInputBar.sendKeys("synoviat1994");
		WebElement enterButtom = driver.findElement(By.id("passwordNext"));
		enterButtom.click();
		WebElement newletterButton = driver.findElement(By.xpath("//div[text()='Написати']"));
		newletterButton.click();
		WebElement inputAdresseeBar = driver.findElement(By.cssSelector("textarea[name='to']"));
		inputAdresseeBar.sendKeys("stepan.synoviat@gmail.com");
		WebElement inputSubjectBar = driver.findElement(By.cssSelector("input[name='subjectbox']"));
		inputSubjectBar.sendKeys("Test");
		WebElement inputTextArea = driver.findElement(By.cssSelector("div[role='textbox']"));
		inputTextArea.sendKeys("Hello");
		WebElement sendButton = driver.findElement(By.cssSelector("div.T-I.J-J5-Ji.aoO.v7.T-I-atl.L3[role='button']"));
		sendButton.click();
		WebElement sendDialogWindow = driver.findElement(By.cssSelector("div.nH.Hd[role='dialog']"));
		Assert.assertFalse(sendDialogWindow.isDisplayed());
		WebElement sentLetterConfirmation = driver.findElement(By.xpath("//*[@id=\"link_vsm\"]"));
		Assert.assertTrue(sentLetterConfirmation.isDisplayed());
		sentLetterConfirmation.click();
	}

	@AfterTest
	public void setDown() {
		driver.quit();
	}

}

package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ChromeWebPageTests {

	private WebDriver driver;

	@Before
	public void setUp() {
		ChromeOptions chromeOptions = new ChromeOptions();

		// Disable pop-ups
		chromeOptions.addArguments("disable-popup-blocking");

		// Use browser caching
		chromeOptions.addArguments("enable-precise-memory-info");

		// Do not load images
		chromeOptions.addArguments("blink-settings=imagesEnabled=false");

		chromeOptions.addArguments("--remote-allow-origins=*");

		// Set up
		WebDriverManager.chromedriver().setup();

		// Create driver 
		driver = new ChromeDriver(chromeOptions);

		// Set implicit wait time to 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void chromeOpenNewTabAndNavigateToNewTab() {

		// Go to google.com
		driver.get("https://www.google.com/");

		// Find the search box and enter "amazon"
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("amazon");

		// Submit the search
		searchBox.submit();

		// Find the Amazon link and open it in a new tab
		WebElement amazonLink = driver.findElement(By.xpath("//h3[contains(text(),'Amazon')]"));
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).click(amazonLink).keyUp(Keys.CONTROL).perform();

		// Switch to the new tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		// Verify that we're on the Amazon website
		String expectedTitle = "Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}

	@Test
	public void chromeHoverOverDropdownMenuVerifyOptions() {

		// Go to Amazon.com
		driver.get("https://www.amazon.com/");

		// Hover over the "Account & Lists" menu
		WebElement accountLists = driver.findElement(By.id("nav-link-accountList"));
		Actions actions = new Actions(driver);
		actions.moveToElement(accountLists).perform();

		// Find the dropdown menu container
		WebElement dropdownContainer = driver.findElement(By.xpath("//div[@id='nav-al-container']"));

		// Find all the options inside the dropdown menu container
		List<WebElement> options = dropdownContainer.findElements(By.xpath(".//span[normalize-space()!='']"));

		// Count the number of options
		int numOptions = options.size();

		assertEquals(14, numOptions);
	}

}

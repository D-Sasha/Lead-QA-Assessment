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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

public class FireFoxWebPageTests {

	private WebDriver driver;

	@Before
	public void setUp() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();

		firefoxOptions.addArguments("--marionette-allow-origins=*");

		// Disable pop-ups
		firefoxOptions.addPreference("dom.disable_open_during_load", true);

		// Use browser caching
		firefoxOptions.addPreference("browser.cache.memory.enable", true);

		// Do not load images
		firefoxOptions.addPreference("permissions.default.image", 2);

		// Set up
		WebDriverManager.firefoxdriver().setup();

		// Create driver 
		driver = new FirefoxDriver(firefoxOptions);

		// Set implicit wait time to 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void fireFoxOpenNewTabAndNavigateToNewTab() {

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

	}

	@Test
	public void fireFoxhoverOverDropdownMenuVerifyOptions() {

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

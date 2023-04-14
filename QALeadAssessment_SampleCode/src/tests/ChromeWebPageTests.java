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
	
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void chromeOpenNewTabAndNavigateToNewTab() {

	}

	@Test
	public void chromeHoverOverDropdownMenuVerifyOptions() {

	}

}

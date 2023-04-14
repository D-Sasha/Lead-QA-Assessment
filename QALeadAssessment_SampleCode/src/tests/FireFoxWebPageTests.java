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
		

	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void fireFoxOpenNewTabAndNavigateToNewTab() {


	}

	@Test
	public void fireFoxhoverOverDropdownMenuVerifyOptions() {


	}

}

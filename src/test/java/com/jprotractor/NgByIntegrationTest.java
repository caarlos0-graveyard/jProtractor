package com.jprotractor;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NgByIntegrationTest {
	private static WebDriver driver;

	@BeforeClass
	public static void setup() throws IOException {
		JProtractorConfiguration.loadConfig(NgByIntegrationTest.class
				.getClassLoader().getResource("integrationTests.properties"));
		driver = JProtractorConfigurator.setup(new FirefoxDriver());
	}
	
	@Before
	public void beforeEach() {
		driver.navigate().to("https://angularjs.org");
	}

	@Test
	public void testByModel() throws Exception {
		assertThat(driver.findElement(NgBy.model("yourName")), notNullValue());
	}
	
	@Test
	public void testByBinding() throws Exception {
		driver.findElement(NgBy.model("yourName")).sendKeys("jProtractor");
		WebElement element = driver.findElements(NgBy.binding(
				"yourName", driver)).get(0);
		assertThat(element.getText(), equalTo("Hello jProtractor!"));
	}

	@AfterClass
	public static void teardown() {
		driver.close();
	}
}

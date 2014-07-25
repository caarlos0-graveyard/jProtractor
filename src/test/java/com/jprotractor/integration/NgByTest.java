package com.jprotractor.integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jprotractor.NgBy;
import com.jprotractor.categories.Integration;
import com.jprotractor.unit.NgDriverEnchancer;

@Category(Integration.class)
public class NgByTest {
	private static WebDriver driver;

	@BeforeClass
	public static void setup() throws IOException {
		driver = NgDriverEnchancer.enchance(new FirefoxDriver(), NgByTest.class
				.getClassLoader().getResource("integrationTests.properties"));
	}

	@Before
	public void beforeEach() {
		driver.navigate().to("https://angularjs.org");
	}

	@AfterClass
	public static void teardown() {
		driver.close();
	}

	@Test
	public void testByModel() throws Exception {
		assertThat(driver.findElement(NgBy.model("yourName")),
				notNullValue());
	}

	@Test
	public void testByBinding() throws Exception {
		driver.findElement(NgBy.model("yourName")).sendKeys("jProtractor");
		WebElement element = driver.findElements(NgBy.binding(
				"yourName", driver)).get(0);
		assertThat(element.getText(), equalTo("Hello jProtractor!"));
	}
}

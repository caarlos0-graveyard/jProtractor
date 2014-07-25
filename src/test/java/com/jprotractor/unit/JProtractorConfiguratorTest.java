package com.jprotractor.unit;

import static com.jprotractor.JProtractorConfiguration.DEFAULT_ANGULAR_TIMEOUT;
import static com.jprotractor.JProtractorConfiguration.DEFAULT_PAGE_LOAD_TIMEOUT;
import static com.jprotractor.JProtractorConfiguration.DEFAULT_WEBDRIVER_TIMEOUT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jprotractor.JProtractorConfigurator;
import com.jprotractor.mocks.WebDriverSpy;

public class JProtractorConfiguratorTest {

	private static WebDriverSpy driver;

	@BeforeClass
	public static void init() throws Exception {
		driver = new WebDriverSpy();
		JProtractorConfigurator.setup(driver);
	}

	@Test
	public void testPageLoadTimeout() throws Exception {
		assertThat(driver.getPageLoadTimeout(),
				equalTo(DEFAULT_PAGE_LOAD_TIMEOUT));
	}

	@Test
	public void testImplicitWait() throws Exception {
		assertThat(driver.getImplicitTimeout(),
				equalTo(DEFAULT_WEBDRIVER_TIMEOUT));
	}

	@Test
	public void testScriptTimeout() throws Exception {
		assertThat(driver.getScriptTimeout(),
				equalTo(DEFAULT_ANGULAR_TIMEOUT));
	}
}

package com.jprotractor;

import static com.jprotractor.JProtractorConfiguration.getAngularTimeout;
import static com.jprotractor.JProtractorConfiguration.getPageLoadTimeout;
import static com.jprotractor.JProtractorConfiguration.getWebDriverTimeout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class JProtractorConfigurator {
	private static TimeUnit TIMEUNIT = TimeUnit.MILLISECONDS;

	public static WebDriver setup(WebDriver driver) {
		driver.manage().timeouts()
				.pageLoadTimeout(getPageLoadTimeout(), TIMEUNIT)
				.implicitlyWait(getWebDriverTimeout(), TIMEUNIT)
				.setScriptTimeout(getAngularTimeout(), TIMEUNIT);
		return driver;
	}

}

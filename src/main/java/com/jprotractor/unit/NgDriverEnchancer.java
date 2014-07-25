package com.jprotractor.unit;

import static com.jprotractor.NgConfiguration.getAngularTimeout;
import static com.jprotractor.NgConfiguration.getPageLoadTimeout;
import static com.jprotractor.NgConfiguration.getWebDriverTimeout;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.jprotractor.NgConfiguration;

public class NgDriverEnchancer {
	private static TimeUnit TIMEUNIT = TimeUnit.MILLISECONDS;

	public static WebDriver enchance(WebDriver driver) throws IOException {
		return enchance(driver, null);
	}

	public static WebDriver enchance(WebDriver driver, URL configFile)
			throws IOException {
		NgConfiguration.loadConfig(configFile);
		return setup(driver);
	}

	private static WebDriver setup(WebDriver driver) {
		if (driver == null)
			return null;
		manageTimeouts(driver);
		return driver;
	}

	private static void manageTimeouts(WebDriver driver) {
		driver.manage().timeouts()
				.pageLoadTimeout(getPageLoadTimeout(), TIMEUNIT)
				.implicitlyWait(getWebDriverTimeout(), TIMEUNIT)
				.setScriptTimeout(getAngularTimeout(), TIMEUNIT);
	}
}

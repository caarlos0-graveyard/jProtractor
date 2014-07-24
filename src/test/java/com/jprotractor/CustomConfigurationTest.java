package com.jprotractor;

import static com.jprotractor.JProtractorConfiguration.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomConfigurationTest {

	@BeforeClass
	public static void setup() throws Exception {
		URL properties = CustomConfigurationTest.class.getClassLoader()
				.getResource("jprotractor.properties");
		JProtractorConfiguration.loadConfig(properties);
	}

	@Test
	public void testPageLoadTimeout() throws Exception {
		assertThat(getPageLoadTimeout(), equalTo(100l));
	}

	@Test
	public void testSyncPageTimeout() throws Exception {
		assertThat(getPageSyncTimeout(), equalTo(100l));
	}

	@Test
	public void testAngularTimeout() throws Exception {
		assertThat(getAngularTimeout(), equalTo(100l));
	}

	@Test
	public void testWebDriverTimeout() throws Exception {
		assertThat(getWebDriverTimeout(), equalTo(100l));
	}

	@AfterClass
	public static void revert() throws Exception {
		JProtractorConfiguration.loadConfig(null);
	}

}

package com.jprotractor.unit;

import static com.jprotractor.NgConfiguration.DEFAULT_ANGULAR_TIMEOUT;
import static com.jprotractor.NgConfiguration.DEFAULT_PAGE_LOAD_TIMEOUT;
import static com.jprotractor.NgConfiguration.DEFAULT_PAGE_SYNC_TIMEOUT;
import static com.jprotractor.NgConfiguration.DEFAULT_WEBDRIVER_TIMEOUT;
import static com.jprotractor.NgConfiguration.getAngularTimeout;
import static com.jprotractor.NgConfiguration.getPageLoadTimeout;
import static com.jprotractor.NgConfiguration.getPageSyncTimeout;
import static com.jprotractor.NgConfiguration.getWebDriverTimeout;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.jprotractor.NgConfiguration;

@RunWith(Enclosed.class)
public class NgConfigurationTest {
	public static class WithCustomConfiguration {
		@BeforeClass
		public static void setup() throws Exception {
			URL properties = NgConfigurationTest.class.getClassLoader()
					.getResource("jprotractor.properties");
			NgConfiguration.loadConfig(properties);
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
			NgConfiguration.loadConfig(null);
		}
	}

	public static class WithDefaultConfiguration {
		@Test
		public void testPageLoadTimeout() throws Exception {
			assertThat(getPageLoadTimeout(), equalTo(DEFAULT_PAGE_LOAD_TIMEOUT));
		}

		@Test
		public void testSyncPageTimeout() throws Exception {
			assertThat(getPageSyncTimeout(), equalTo(DEFAULT_PAGE_SYNC_TIMEOUT));
		}

		@Test
		public void testAngularTimeout() throws Exception {
			assertThat(getAngularTimeout(), equalTo(DEFAULT_ANGULAR_TIMEOUT));
		}

		@Test
		public void testWebDriverTimeout() throws Exception {
			assertThat(getWebDriverTimeout(),
					equalTo(DEFAULT_WEBDRIVER_TIMEOUT));
		}
	}
}

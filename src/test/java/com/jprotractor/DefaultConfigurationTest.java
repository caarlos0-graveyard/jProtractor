package com.jprotractor;

import static com.jprotractor.JProtractorConfiguration.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultConfigurationTest {

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
		assertThat(getWebDriverTimeout(), equalTo(DEFAULT_WEBDRIVER_TIMEOUT));
	}

}

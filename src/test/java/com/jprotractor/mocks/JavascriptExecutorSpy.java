package com.jprotractor.mocks;

import org.openqa.selenium.JavascriptExecutor;

public class JavascriptExecutorSpy extends WebDriverSpy implements
		JavascriptExecutor {

	@Override
	public Object executeScript(String script, Object... args) {
		return null;
	}

	@Override
	public Object executeAsyncScript(String script, Object... args) {
		return null;
	}
}

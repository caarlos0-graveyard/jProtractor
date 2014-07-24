package com.jprotractor.bys;

import static java.lang.String.format;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jprotractor.NgBy;

public class ByBinding extends By {
	private static final String BINDING_SCRIPT = getBindingScriptContent();
	private final JavascriptExecutor executor;
	private final String model;

	public ByBinding(WebDriver driver, String model) {
		super();
		this.executor = (JavascriptExecutor) driver;
		this.model = model;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<WebElement> findElements(SearchContext context) {
		return (List<WebElement>) executor.executeScript(BINDING_SCRIPT
				+ format("return findBindings('%s')", model));
	}

	@Override
	public String toString() {
		return "By.binding: " + model;
	}

	private static String getBindingScriptContent() {
		try {
			URI uri = NgBy.class.getClassLoader().getResource("binding.js")
					.toURI();
			return new String(Files.readAllBytes(Paths.get(uri)), "UTF-8");
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
	}

}

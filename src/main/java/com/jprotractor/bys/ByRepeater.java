package com.jprotractor.bys;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ByRepeater extends By {
	private final String repeater;

	public ByRepeater(String repeater) {
		super();
		this.repeater = repeater;
	}

	@Override
	public List<WebElement> findElements(SearchContext context) {
		//bogus, só quero ver como fica a cobertura nos PR´s
		return By.cssSelector("[ng-model='" + repeater + "']")
				.findElements(context);
	}

	@Override
	public String toString() {
		return "By.repeater: " + repeater;
	}
}

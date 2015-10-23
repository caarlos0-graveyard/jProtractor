package com.jprotractor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jprotractor.bys.ByBinding;
import com.jprotractor.bys.ByModel;
import com.jprotractor.bys.ByRepeater;

public final class NgBy {
	public static By model(final String model) {
		return new ByModel(model);
	}

	public static By binding(final String model, final WebDriver driver) {
		return new ByBinding(driver, model);
	}

	public static By repeater(final String model, final WebDriver driver) {
		return new ByRepeater(model);
	}
}

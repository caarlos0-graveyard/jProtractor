package com.jprotractor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jprotractor.bys.ByBinding;
import com.jprotractor.bys.ByModel;
<<<<<<< HEAD
import com.jprotractor.bys.ByRepeater;
=======
import com.jprotractor.bys.ByOptions;
>>>>>>> upstream/master

public abstract class NgBy extends By {
	public static By model(final String model) {
		return new ByModel(model);
	}

	public static By binding(final String model, final WebDriver driver) {
		return new ByBinding(driver, model);
	}

	public static By repeater(final String model, final WebDriver driver) {
		return new ByRepeater(model);
	}

	public static By options(final String options, final WebDriver driver) {
		return new ByOptions(options, driver);
	}
}

package com.jprotractor;

import com.jprotractor.scripts.Evaluate;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsElement;

public final class NgWebElement implements WebElement, WrapsElement {

    private NgWebDriver ngDriver;
    private WebElement element;

    public NgWebElement(final NgWebDriver ngDriver, final WebElement element) {
        this.ngDriver = ngDriver;
        this.element = element;
    }

    public WebElement getWrappedElement() {
        return this.element;
    }

    public void clear() {
        this.ngDriver.waitForAngular();
        this.element.clear();

    }

    public void click() {
        this.ngDriver.waitForAngular();
        this.element.click();
    }

    public Object evaluate(final String expression) {
        this.ngDriver.waitForAngular();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this.ngDriver
            .getWrappedDriver();
        return jsExecutor.executeScript(
            new Evaluate().content(),
            this.element,
            expression
        );
    }

    public NgWebElement findElement(By by) {
        if (by instanceof JavaScriptBy) {
            ((JavaScriptBy) by).root = this.element;
        }
        this.ngDriver.waitForAngular();
        return new NgWebElement(this.ngDriver, this.element.findElement(by));
    }

    public List<NgWebElement> findNgElements(By by) {
        final List<WebElement> temp = findElements(by);
        final List<NgWebElement> elements = new ArrayList<>();
        for (final WebElement element : temp) {
            elements.add(new NgWebElement(this.ngDriver, element));
        }
        return elements;
    }

    public List<WebElement> findElements(By by) {
        if (by instanceof JavaScriptBy) {
            ((JavaScriptBy) by).root = this.element;
        }
        final List<WebElement> returnElements = this.element.findElements(by);
        this.ngDriver.waitForAngular();
        return returnElements;
    }

    public String getAttribute(String arg0) {
        this.ngDriver.waitForAngular();
        return this.element.getAttribute(arg0);
    }

    public String getCssValue(String arg0) {
        this.ngDriver.waitForAngular();
        return this.element.getCssValue(arg0);
    }

    public Point getLocation() {
        this.ngDriver.waitForAngular();
        return this.element.getLocation();
    }

    public Dimension getSize() {
        this.ngDriver.waitForAngular();
        return this.element.getSize();
    }

    public String getTagName() {
        this.ngDriver.waitForAngular();
        return this.element.getTagName();
    }

    public String getText() {
        this.ngDriver.waitForAngular();
        return this.element.getText();
    }

    public boolean isDisplayed() {
        this.ngDriver.waitForAngular();
        return this.element.isDisplayed();
    }

    public boolean isEnabled() {
        this.ngDriver.waitForAngular();
        return this.element.isEnabled();
    }

    public boolean isSelected() {
        this.ngDriver.waitForAngular();
        return this.element.isSelected();
    }

    public void sendKeys(CharSequence... arg0) {
        this.ngDriver.waitForAngular();
        this.element.sendKeys(arg0);

    }

    public void submit() {
        this.ngDriver.waitForAngular();
        this.element.submit();
    }
}

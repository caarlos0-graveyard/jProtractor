package com.jprotractor;

import com.jprotractor.scripts.Script;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public final class JavaScriptBy extends By {
    /**
     * Script to use.
     */
    private final transient Script script;
    /**
     * Root element.
     */
    private final transient WebElement root;

    /**
     * Ctor.
     * @param scrpt Script to use.
     * @param elem Root WebElement.
     */
    public JavaScriptBy(final Script scrpt, final WebElement elem) {
        super();
        this.script = scrpt;
        this.root = elem;
    }

    @Override
    public WebElement findElement(final SearchContext context) {
        final List<WebElement> elements = this.findElements(context);
        WebElement result = null;
        if (!elements.isEmpty()) {
            result = elements.get(0);
        }
        return result;
    }

    @Override
    public List<WebElement> findElements(final SearchContext context) throws WebDriverException {
        final Object[] scriptargs = new Object[this.args.length + 1];
        scriptargs[0] = this.root;
        System.arraycopy(this.args, 0, scriptargs, 1, this.args.length);
        return this.elements(context, scriptargs);
    }

    private List<WebElement> elements(
        final SearchContext context,
        final Object[] jsargs
    ) {
        @SuppressWarnings("unchecked")
        List<WebElement> elements = (List<WebElement>) this.executor(context)
            .executeScript(this.script.content(), jsargs);
        if (elements == null) {
            elements = new ArrayList<>(0);
        }
        return elements;
    }

    private JavascriptExecutor executor(final SearchContext context) {
        JavascriptExecutor jsexecutor = null;
        if (!(context instanceof WebElement)) {
            jsexecutor = (JavascriptExecutor) context;
        }
        if (jsexecutor == null) {
            final WrapsDriver driver = (WrapsDriver) context;
            if (driver != null) {
                jsexecutor = (JavascriptExecutor) driver.getWrappedDriver();
            }
        }
        if (jsexecutor == null) {
            throw new WebDriverException(
                "Could not get an JavaScriptExecutor instance from the context."
            );
        }
        return jsexecutor;
    }
}

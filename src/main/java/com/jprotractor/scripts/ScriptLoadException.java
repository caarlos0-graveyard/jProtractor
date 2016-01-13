package com.jprotractor.scripts;

/**
 * Class thrown when a script failed to load.
 * @author Carlos Alexandro Becker (caarlos0@gmail.com)
 */
public class ScriptLoadException extends RuntimeException {
    /**
     * Ctor.
     * @param cause Cause of the error.
     * @param filename Name of the file caused the failure.
     */
    public ScriptLoadException(final Throwable cause, final String filename) {
        super(
            String.format(
                "Failed to get script contents for file %s",
                filename
            ),
            cause
        );
    }
}

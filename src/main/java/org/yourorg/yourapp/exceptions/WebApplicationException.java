package org.yourorg.yourapp.exceptions;

public class WebApplicationException extends Exception {
    private static final long serialVersionUID = 123L;

    public WebApplicationException() {
    }

    public WebApplicationException(String msg) {
        super(msg);
    }
}

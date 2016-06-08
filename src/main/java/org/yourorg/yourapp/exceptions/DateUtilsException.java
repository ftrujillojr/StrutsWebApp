package org.yourorg.yourapp.exceptions;

public class DateUtilsException extends Exception {
    private static final long serialVersionUID = 123L;

    public DateUtilsException() {
    }

    public DateUtilsException(String msg) {
        super(msg);
    }
}

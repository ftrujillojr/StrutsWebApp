package org.yourorg.yourapp.exceptions;

public class SysUtilsException extends Exception {
    private static final long serialVersionUID = 123L;

    public SysUtilsException() {
    }

    public SysUtilsException(String msg) {
        super(msg);
    }
}

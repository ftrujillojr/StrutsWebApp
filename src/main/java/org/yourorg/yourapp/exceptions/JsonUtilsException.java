package org.yourorg.yourapp.exceptions;

public class JsonUtilsException extends Exception {
    private static final long serialVersionUID = 123L;

    public JsonUtilsException() {
    }

    public JsonUtilsException(String msg) {
        super(msg);
    }
}

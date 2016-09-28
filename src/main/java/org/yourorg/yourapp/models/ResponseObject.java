package org.yourorg.yourapp.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseObject {

    private int status;
    private String message;
    private Object data;
    private String method;
    private String uri;
    /* 
        Do NOT add any List<***>'s here.  JAXb does not like.
        There is a work around, but clunky.
    */
    
    public ResponseObject() {
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

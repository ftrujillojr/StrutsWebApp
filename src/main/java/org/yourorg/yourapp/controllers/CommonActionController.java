package org.yourorg.yourapp.controllers;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

public abstract class CommonActionController extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {

    private static final long serialVersionUID = 123L;

    protected HttpServletRequest requestAttrs = null;
    protected HttpServletResponse response = null;
    protected Map<String, Object> sessionAttrs = null;

    public CommonActionController() {
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionAttrs = map;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.requestAttrs = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}

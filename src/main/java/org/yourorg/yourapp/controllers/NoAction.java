package org.yourorg.yourapp.controllers;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.yourorg.yourapp.models.EmailData;

public class NoAction extends ActionSupport implements SessionAware, ServletRequestAware {

    private static final long serialVersionUID = 123L;
    private static final Logger LOGGER = Logger.getLogger(NoAction.class.getName());
    
    private HttpServletRequest requestAttrs = null;
    private Map<String, Object> sessionAttrs = null;

    private EmailData emailData; // this object is marshalled from Json.
    
    public NoAction() {
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionAttrs = map;
    }
    
    @Override
    public void setServletRequest(HttpServletRequest requestAttrs) {
        this.requestAttrs = requestAttrs;
    }

    @Override
    public String execute() {
        return ActionSupport.SUCCESS;
    }

    // curl -ss -i -H "Accept: application/json" -H "Content-Type: application/json" \
    //       --data {"emailData":{"email":"ftrujillojr@gmail.com","firstName":"Francis","lastName":"Trujillo"}} \
    //       --request POST http://nsglnxdev1.micron.com:8080/StrutsWebApp/homeJson
    public String homeJson() {
        String contextPath = this.requestAttrs.getContextPath();  // /Struts2Demo
        String method = this.requestAttrs.getMethod();            // GET
        String queryString = this.requestAttrs.getQueryString();  // ?id=1&message=3
        String uri = this.requestAttrs.getRequestURI();           // /Struts2Demo/query
        StringBuffer urlBuf = this.requestAttrs.getRequestURL();  // http://localhost:8080/Struts2Demo/query?id=1&message=3'
        if(this.requestAttrs.getHeader("X-HTTP-Method-Override") != null) {
            System.out.println("\n ******** X-HTTP-Method-Override: " + this.requestAttrs.getHeader("X-HTTP-Method-Override"));
        }
        
        System.out.println("\n******** METHOD: " + method);
       
        
        return "json";
    }

    public String noAction() {
        return ActionSupport.SUCCESS;
    }

    public EmailData getEmailData() {
        return emailData;
    }

    public void setEmailData(EmailData emailData) {
        this.emailData = emailData;
    }

}

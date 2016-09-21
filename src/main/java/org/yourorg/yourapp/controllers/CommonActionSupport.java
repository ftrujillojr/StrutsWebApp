package org.yourorg.yourapp.controllers;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.yourorg.yourapp.interfaces.RestConvention; // This is my Rest Convention
import org.yourorg.yourapp.models.JsonResponse;

public abstract class CommonActionSupport extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware, RestConvention {

    private static final Logger LOGGER = Logger.getLogger(CommonActionSupport.class.getName());
    private static final long serialVersionUID = 123L;
    protected JsonResponse jsonResponse; // this object is marshalled from Json.

    // Variables for request/response/session.
    private HttpServletRequest httpServletRequest = null;
    private HttpServletResponse httpServletResponse = null;
    private Map<String, Object> sessionAttrs = null;

    // Variables for business logic.
    private String accept = null;
    private String contextPath = null;
    private String method = null;         // Original method, e.g.  POST
    private String methodOverride = null; // X-HTTP-Method-Override  e.g. PUT
    private String currentMethod = null;  // resolved method vs methodOverride e.g PUT
    private String queryString = null;
    private String uri = null;
    private String url = null;

    public CommonActionSupport() {
        System.out.println("JsonResponse initialized.");
        this.jsonResponse = new JsonResponse();
    }

    /**
     * This method can be overridden in sub class.
     */
    @Override
    public void validate() {
        if (this.contextPath == null) {
            LOGGER.debug("initVars() called from validate() in CommonActionSupport");
            this.initVars();
        }
    }

    protected final void initVars() {
        if (this.contextPath == null && this.httpServletRequest != null && this.httpServletResponse != null) {
            
            this.accept = this.httpServletRequest.getHeader("Accept");
            this.contextPath = this.httpServletRequest.getContextPath();            // /Struts2Demo
            this.method = this.httpServletRequest.getMethod().trim().toUpperCase(); // GET
            this.queryString = this.httpServletRequest.getQueryString();            // ?id=1&message=3
            this.uri = this.httpServletRequest.getRequestURI();                     // /Struts2Demo/query
            StringBuffer urlBuf = this.httpServletRequest.getRequestURL();          // http://localhost:8080/Struts2Demo/query?id=1&message=3'
            this.url = urlBuf.toString();
            if (this.httpServletRequest.getHeader("X-HTTP-Method-Override") != null) {
                this.methodOverride = this.httpServletRequest.getHeader("X-HTTP-Method-Override").trim().toUpperCase();
            }
            this.currentMethod = (methodOverride != null) ? this.methodOverride : this.method;

            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("        accept: ").append(this.accept).append("\n");
            sb.append("   contextPath: ").append(this.contextPath).append("\n");
            sb.append("        method: ").append(this.method).append("\n");
            sb.append("   queryString: ").append(this.queryString).append("\n");
            sb.append("           uri: ").append(this.uri).append("\n");
            sb.append("           url: ").append(this.url).append("\n");
            sb.append("methodOverride: ").append(this.methodOverride).append("\n");
            sb.append(" currentMethod: ").append(this.currentMethod).append("\n");

            LOGGER.debug(sb.toString());
        }
    }

    public String restDispatch() {
        String result = "";
        if (this.contextPath == null) {
            LOGGER.debug("initVars() called from restDispatch()");
            this.initVars();
        }
        switch (this.currentMethod) {
            case ("GET"):
                if(this.uri.matches(".+/new$")) {
                    result = this._new();
                } 
                else if(this.uri.matches(".+/[0-9]+$")) {
                    result = this.show();
                }
                else if(this.uri.matches(".+/[0-9]+/edit$")) {
                    result = this.edit();
                } else {
                    result = this.index();
                }
                break;
            case ("POST"):
                result = this.create();
                break;
            case ("PUT"):
            case ("PATCH"):
                result = this.update();
                break;
            case ("DELETE"):
                result = this.delete();
                break;
            default:
                String msg = "ERROR: restDispatch() had incorrect METHOD or override => " + this.currentMethod;
                LOGGER.debug(msg);
                break;
        }

        return result;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionAttrs = map;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.httpServletRequest = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }


    // Getters ONLY
    
    public String getCurrentMethod() {
        return this.currentMethod;
    }
    
    public String getMethodOverride() {
        return this.methodOverride;
    }
    
    public String getMethod() {
        return  this.method;
    }

    public String getContextPath() {
        return this.contextPath;
    }

    public String getQueryString() {
        return this.queryString;
    }

    public String getUri() {
        return this.uri;
    }

    public String getUrl() {
        return this.url;
    }
    
    public String getAccept() {
        return this.accept;
    }

/*
######   #######   #####   ######   #######  #     #   #####   #######  
#     #  #        #     #  #     #  #     #  ##    #  #     #  #        
#     #  #        #        #     #  #     #  # #   #  #        #        
######   #####     #####   ######   #     #  #  #  #   #####   #####    
#   #    #              #  #        #     #  #   # #        #  #        
#    #   #        #     #  #        #     #  #    ##  #     #  #        
#     #  #######   #####   #        #######  #     #   #####   #######  
*/    
    protected void errorResponse(String message) {
        this.errorResponse(message, HttpServletResponse.SC_BAD_REQUEST);
    }
    
    protected void errorResponse(String message, int status) {
        this.httpServletResponse.setStatus(status);
        this.jsonResponse.setStatus(status);
        this.jsonResponse.setMessage(message);
        this.jsonResponse.setMethod(this.currentMethod);
        this.jsonResponse.setUri(this.uri);
    }

    protected void successResponse(Object obj) {
        this.successResponse(obj, HttpServletResponse.SC_OK);
    }
    
    protected void successResponse(Object obj, int status) {
        this.httpServletResponse.setStatus(status);
        this.jsonResponse.setStatus(status);
        this.jsonResponse.setData(obj);
        this.jsonResponse.setMethod(this.currentMethod);
        this.jsonResponse.setUri(this.uri);
    }
    
    protected void successResponse(List<Object> objList) {
        this.successResponse(objList, HttpServletResponse.SC_OK);
    }
    
    protected void successResponse(List<Object> objList, int status) {
        this.httpServletResponse.setStatus(status);
        this.jsonResponse.setStatus(status);
        this.jsonResponse.setDataList(objList);
        this.jsonResponse.setMethod(this.currentMethod);
        this.jsonResponse.setUri(this.uri);
    }
    
}

package org.yourorg.yourapp.controllers;

import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.yourorg.yourapp.interfaces.RestConvention; // This is my Rest Convention
import org.yourorg.yourapp.models.ResponseObject;
import org.yourorg.yourapp.support.RegExp;

public abstract class CommonActionSupport extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware, RestConvention {

    private static final Logger LOGGER = Logger.getLogger(CommonActionSupport.class.getName());
    private static final long serialVersionUID = 123L;
    protected ResponseObject responseObject;
    protected InputStream inputStream;

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
        this.responseObject = new ResponseObject();
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

            List<String> acceptList = RegExp.split(",", this.accept);

            for (String item : acceptList) {
                item = item.trim();
                if (item.matches("text/html")) {
                    this.accept = "text/html";
                    break;
                }
                if (item.matches("application/json")) {
                    this.accept = "application/json";
                    break;
                }
                if (item.matches("application/xml")) {
                    this.accept = "application/xml";
                    break;
                }
            }

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
                if (this.uri.matches(".+/new$")) {
                    result = this._new();
                } else if (this.uri.matches(".+/[0-9]+$")) {
                    result = this.show();
                } else if (this.uri.matches(".+/[0-9]+/edit$")) {
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

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    // Getters ONLY
    public String getCurrentMethod() {
        return this.currentMethod;
    }

    public String getMethodOverride() {
        return this.methodOverride;
    }

    public String getMethod() {
        return this.method;
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
    private void initSuccess() {
        if (this.currentMethod.equals("POST")) {
            this.httpServletResponse.setStatus(HttpServletResponse.SC_CREATED);
            this.responseObject.setStatus(HttpServletResponse.SC_CREATED);

        } else {
            this.httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            this.responseObject.setStatus(HttpServletResponse.SC_OK);
        }

        this.responseObject.setMethod(this.currentMethod);
        this.responseObject.setUri(this.uri);
    }

    private void initError() {
        this.httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        this.responseObject.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        this.responseObject.setMethod(this.currentMethod);
        this.responseObject.setUri(this.uri);
    }

    private void marshallResponseObject2InputStream() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JAXBContext jaxbContext = JAXBContext.newInstance(ResponseObject.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(this.responseObject, outputStream);
            outputStream.flush();
            this.inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        } catch (JAXBException ex) {
            java.util.logging.Logger.getLogger(NoActionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(CommonActionSupport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getResponseType() {
        String responseType = null;
        String accept = this.getAccept();

        if (accept.matches(".*text/html.*")) {
            responseType = "html";
        } else if (accept.matches(".*application/xml.*")) {
            this.marshallResponseObject2InputStream();
            responseType = "xml";
        } else if (accept.matches(".*application/json.*")) {
            responseType = "json";
        } else {
            responseType = "html";
        }

        if (responseType.equals("html")) {
            int status = this.httpServletResponse.getStatus();

            if (status >= 200 && status < 300) {
                responseType = ActionSupport.SUCCESS;
            } else {
                responseType = ActionSupport.ERROR;
            }
        }

        return responseType;
    }

    protected String errorResponse(String message) {
        this.responseObject.setMessage(message);
        this.initError();
        return this.getResponseType();
    }

    protected String errorResponse(Object obj) {
        this.responseObject.setData(obj);
        this.initError();
        return this.getResponseType();
    }

    protected String errorResponse(List<Object> objList) {
        this.responseObject.setDataList(objList);
        this.initError();
        return this.getResponseType();
    }

    protected String successResponse(String message) {
        this.responseObject.setMessage(message);
        this.initSuccess();
        return this.getResponseType();
    }

    protected String successResponse(Object obj) {
        this.responseObject.setData(obj);
        this.initSuccess();
        return this.getResponseType();
    }

    protected String successResponse(List<Object> objList) {
        this.responseObject.setDataList(objList);
        this.initSuccess();
        return this.getResponseType();
    }
}

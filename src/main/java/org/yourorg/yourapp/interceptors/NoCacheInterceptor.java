package org.yourorg.yourapp.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;
import org.yourorg.yourapp.support.CustomHttpServletWrapper;

// http://stackoverflow.com/questions/21820741/jersey-rest-response-in-angular-js
// http://www.codingpedia.org/ama/how-to-add-cors-support-on-the-server-side-in-java-with-jersey/
//
//      Access-Control-Allow-Origin: specifies the authorized domains to make cross-domain request (you should include the domains of your REST clients or * if you want the resource public and available to everyone  the latter is not an option if credentials are allowed during CORS requests)
//    Access-Control-Expose-Headers: lets a server white list headers that browsers are allowed to access
//           Access-Control-Max-Age: indicates how long the results of a preflight request can be cached.
// Access-Control-Allow-Credentials: indicates if the server allows credentials during CORS requests
//     Access-Control-Allow-Methods: indicates the methods allowed when accessing the resource
//     Access-Control-Allow-Headers: used in response to a preflight request to indicate which HTTP headers can be used when making the actual request.
//
// https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol
//
// GET     The GET method requests a representation of the specified resource. Requests using GET should only retrieve data and should have no other effect. 
// HEAD    The HEAD method asks for a response identical to that of a GET request, but without the response body. 
// POST    The POST method requests that the server accept the entity enclosed in the request as a new web resource identified by the URI.
// PUT     The PUT method requests that the enclosed entity be stored under the supplied URI. If the URI refers to an already existing resource, it is modified.
// DELETE  The DELETE method deletes the specified resource.
// OPTIONS The OPTIONS method returns the HTTP methods that the server supports for the specified URL.
//
// http://www.bennadel.com/blog/2568-preventing-cross-site-request-forgery-csrf-xsrf-with-angularjs-and-coldfusion.htm
//        // https://en.wikipedia.org/wiki/List_of_HTTP_header_fields
//
// Origin                 - Initiates a request for cross-origin resource sharing (asks server for an 'Access-Control-Allow-Origin' response field).
// X-Requested-With       - mainly used to identify Ajax requests. Most JavaScript frameworks send this field with value of XMLHttpRequest.
// X-HTTP-Method-Override - Requests a web application override the method specified in the request (typically POST) with the method given in the header field (typically PUT or DELETE).
//
//  https://blog.httpwatch.com/2008/10/15/two-important-differences-between-firefox-and-ie-caching/
//  http://www.codedisqus.com/CSVVUqUPVX/caching-headers-interceptor-does-nothing-struts2.html
//  https://struts.apache.org/maven/struts2-core/apidocs/com/opensymphony/xwork2/util/ValueStack.html

public class NoCacheInterceptor implements Interceptor {

    // Make sure you import => org.apache.log4j.Logger 
    private static final Logger LOGGER = Logger.getLogger(NoCacheInterceptor.class.getName());

    // change this when you add/delete variables or the order of them.
    private static final long serialVersionUID = 1436553694L;

    public NoCacheInterceptor() {
    }

    @Override
    public void init() {
        LOGGER.debug("========= NoCacheInterceptor.init() ===============");
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {

        ActionContext ac = ai.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
        HttpServletResponse response = (HttpServletResponse) ac.get(StrutsStatics.HTTP_RESPONSE);

        // You MUST modify request or response headers prior to invoke() or nothing will happen.
        if (response != null) {
            response.addHeader("Content-Style-Type", "text/css");
            response.addHeader("Cache-control", "no-cache, no-store, must-revalidate");
            response.addHeader("Pragma", "no-cache");
            response.addHeader("Expires", "-1"); // NEVER

            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS,HEAD");
            response.addHeader("Access-Control-Allow-Headers",
                    "Content-Type,Access-Control-Allow-Headers,Authorization,X-Requested-With,Cache-Control,Origin,Accept,X-Jersey-Tracing-Accept,X-HTTP-Method-Override");
        }
        
//        CustomHttpServletWrapper customHttpServletWrapper = new CustomHttpServletWrapper(request);
//        
//        if(customHttpServletWrapper.getBody().isEmpty() == false) {
//            System.out.println("*** BODY  ***");
//            System.out.println(customHttpServletWrapper.getBody());
//        }
                
        this.displayRequestParams(request);
        // ****************************************************************************************
        String result = ai.invoke(); // Invokes the next interceptor (if one exists) or the action
        // ****************************************************************************************
        this.displayResponseParams(response);
        
        return (result);
    }

    @Override
    public void destroy() {
        LOGGER.debug("========= NoCacheInterceptor.destroy() ===============");
    }

    private void displayRequestParams(HttpServletRequest request) {
        if (request != null) {
            StringBuilder sb = new StringBuilder();

            sb.append("\nREQUEST:").append("\n");
            sb.append("\tContextPath: ").append(request.getContextPath()).append("\n");
            sb.append("\t     Method: ").append(request.getMethod()).append("\n");
            sb.append("\t RequestURI: ").append(request.getRequestURI()).append("\n");
            sb.append("\t   AuthType: ").append(request.getAuthType()).append("\n");
            sb.append("\tQueryString: ").append(request.getQueryString()).append("\n");
            sb.append("\t RequestURL: ").append(request.getRequestURL().toString()).append("\n");

            
            
            sb.append("\t\t-------------- REQUEST Headers --------------").append("\n");

            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                if (headerName.equals("cookie")) {
                    String cookie = request.getHeader("cookie");
                    if (cookie != null) {
                        sb.append("\t\t\t------------REQUEST cookies---------------").append("\n");
                        String[] cookies = cookie.split(";");
                        for (int ii = 0; ii < cookies.length; ii++) {
                            if (cookies[ii] != null) {
                                sb.append("\t\t\t").append(cookies[ii].trim()).append("\n");
                            }
                        }
                    }
                } else {
                    sb.append("\t\t").append(headerName).append(": ").append(request.getHeader(headerName)).append("\n");
                }
            }

            LOGGER.debug(sb.toString());
        }
    }

    private void displayResponseParams(HttpServletResponse response) {
        if (response != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\nRESPONSE:").append("\n");
            sb.append("\t Status: ").append(response.getStatus()).append("\n");

            sb.append("\t\t-------------- RESPONSE Headers --------------").append("\n");

            Collection<String> headerNames = response.getHeaderNames();
            Iterator<String> itr = headerNames.iterator();
            while (itr.hasNext()) {
                String headerName = itr.next();
                if (headerName.equals("Set-Cookie")) {
                    String cookie = response.getHeader("Set-Cookie");
                    if (cookie != null) {
                        sb.append("\t\t\t------------RESPONSE cookies---------------").append("\n");
                        String[] cookies = cookie.split(";");
                        for (int ii = 0; ii < cookies.length; ii++) {
                            if (cookies[ii] != null) {
                                sb.append("\t\t\t").append(cookies[ii].trim()).append("\n");
                            }
                        }
                    }
                } else {
                    sb.append("\t\t").append(headerName).append(": ").append(response.getHeader(headerName)).append("\n");
                }
            }
            LOGGER.debug(sb.toString());
        }
    }

}

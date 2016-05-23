package org.yourorg.yourapp.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

//  https://blog.httpwatch.com/2008/10/15/two-important-differences-between-firefox-and-ie-caching/
//  http://www.codedisqus.com/CSVVUqUPVX/caching-headers-interceptor-does-nothing-struts2.html
public class NoCacheInterceptor implements Interceptor {

    // Make sure you import => org.apache.log4j.Logger 
    private static final Logger LOGGER = Logger.getLogger(NoCacheInterceptor.class.getName());

    // change this when you add/delete variables or the order of them.
    private static final long serialVersionUID = 1436553694L;

    public NoCacheInterceptor() {
    }

    @Override
    public void init() {
        //LOGGER.debug("========= NoCacheInterceptor.init() ===============");
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {

        ActionContext ac = ai.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
        this.displayRequestParams(request);

        ServletInputStream sis = request.getInputStream();

        if (sis != null) {
            StringBuilder sb = new StringBuilder();
            
            try (BufferedReader br = new BufferedReader(new InputStreamReader(sis, "UTF-8"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException ex) {
                throw ex;
            }

            LOGGER.debug("\nREQUEST STREAM ENTITY: " + sb.toString());
        }

//        String className = ai.getAction().getClass().getName();
//        long startTime = System.currentTimeMillis();
//        LOGGER.debug("Before calling action: " + className);
        // ****************************************************************************************
        String result = ai.invoke(); // Invokes the next interceptor (if one exists) or the action
        // ****************************************************************************************

//        long endTime = System.currentTimeMillis();
//        LOGGER.debug("After calling action: " + className + " Time taken: " + (endTime - startTime) + " ms");
        HttpServletResponse response = (HttpServletResponse) ac.get(StrutsStatics.HTTP_RESPONSE);

        if (response != null) {
            response.addHeader("Content-Style-Type", "text/css");
            response.addHeader("Cache-control", "no-cache, no-store, must-revalidate");
            response.addHeader("Pragma", "no-cache");
            response.addHeader("Expires", "-1"); // NEVER
        }

        this.displayResponseParams(response);
        return (result);
    }

    @Override
    public void destroy() {
        //LOGGER.debug("========= NoCacheInterceptor.destroy() ===============");
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

            sb.append("\t\t-------------- Headers --------------").append("\n");

            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                if (headerName.equals("cookie")) {
                    String cookie = request.getHeader("cookie");
                    if (cookie != null) {
                        sb.append("\t\t\t------------cookies---------------").append("\n");
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

            sb.append("\t\t-------------- Headers --------------").append("\n");

            Collection<String> headerNames = response.getHeaderNames();
            Iterator<String> itr = headerNames.iterator();
            while (itr.hasNext()) {
                String headerName = itr.next();
                sb.append("\t\t").append(headerName).append(": ").append(response.getHeader(headerName)).append("\n");
            }
            LOGGER.debug(sb.toString());
        }
    }

}

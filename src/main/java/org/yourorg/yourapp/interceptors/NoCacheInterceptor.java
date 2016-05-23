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
        LOGGER.debug("========= NoCacheInterceptor.init() ===============");
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
                System.out.println(headerName + ": " + request.getHeader(headerName));
                sb.append("\t\t").append(headerName).append(": ").append(request.getHeader(headerName)).append("\n");
            }

            LOGGER.debug(sb.toString());
        }
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {

        ActionContext ac = ai.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
        this.displayRequestParams(request);

        String className = ai.getAction().getClass().getName();
        long startTime = System.currentTimeMillis();
        LOGGER.debug("Before calling action: " + className);

        // ****************************************************************************************
        String result = ai.invoke(); // Invokes the next interceptor (if one exists) or the action
        // ****************************************************************************************

        long endTime = System.currentTimeMillis();
        LOGGER.debug("After calling action: " + className + " Time taken: " + (endTime - startTime) + " ms");

        HttpServletResponse response = (HttpServletResponse) ac.get(StrutsStatics.HTTP_RESPONSE);

        if (response != null) {
            response.setHeader("Content-Style-Type", "text/css");
            response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "-1"); // NEVER

            StringBuilder sb = new StringBuilder();
            sb.append("RESPONSE:").append("\n");
            sb.append("\t Status: ").append(response.getStatus()).append("\n");

            Collection<String> headerNames = response.getHeaderNames();
            Iterator<String> itr = headerNames.iterator();
            while (itr.hasNext()) {
                String headerName = itr.next();
                sb.append(headerName).append(": ").append(response.getHeader(headerName));
            }
            
            LOGGER.debug(sb.toString());
        }

        return (result);
    }

    @Override
    public void destroy() {
        System.out.println("========= NoCacheInterceptor.destroy() =============");
    }
}

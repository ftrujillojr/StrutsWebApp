package org.yourorg.yourapp.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.StrutsStatics;

//  https://blog.httpwatch.com/2008/10/15/two-important-differences-between-firefox-and-ie-caching/
//  http://www.codedisqus.com/CSVVUqUPVX/caching-headers-interceptor-does-nothing-struts2.html
public class NoCacheInterceptor implements Interceptor {

    // change this when you add/delete variables or the order of them.
    private static final long serialVersionUID = 1436553694L;

    private static final boolean debug = true; // set to true to debug

    public NoCacheInterceptor() {
    }

    @Override
    public void init() {
        System.out.println("========= NoCacheInterceptor.init() ===============");
    }

    private void displayRequestParams(HttpServletRequest request) {
        if (request != null) {
            System.out.println("ContextPath: " + request.getContextPath());
            System.out.println("     Method: " + request.getMethod());
            System.out.println(" RequestURI: " + request.getRequestURI());
            System.out.println("   AuthType: " + request.getAuthType());
            System.out.println("QueryString: " + request.getQueryString());
            System.out.println(" RequestURL: " + request.getRequestURL().toString());
            System.out.println("-------------- Headers --------------");
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                System.out.println(headerName + ": " + request.getHeader(headerName));
            }
        }
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        ActionContext ac = ai.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);

        if (debug) {
            this.displayRequestParams(request);
        }

        String className = ai.getAction().getClass().getName();
        long startTime = System.currentTimeMillis();

        if (debug) {
            System.out.println("Before calling action: " + className);
        }

        String result = ai.invoke(); // Invokes the next interceptor (if one exists) or the action

        long endTime = System.currentTimeMillis();
        if (debug) {
            System.out.println("After calling action: " + className
                    + " Time taken: " + (endTime - startTime) + " ms");
        }
        
        HttpServletResponse response = (HttpServletResponse) ac.get(StrutsStatics.HTTP_RESPONSE);
        
        if (debug) {
            if (response != null) {
                response.setHeader("Content-Style-Type", "text/css");
                response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Expires", "-1"); // NEVER

                System.out.println("Status: " + response.getStatus());

                Collection<String> headerNames = response.getHeaderNames();
                Iterator<String> itr = headerNames.iterator();
                while (itr.hasNext()) {
                    String headerName = itr.next();
                    System.out.println(headerName + ": " + response.getHeader(headerName));
                }
            }
        }

        return (result);
    }

    @Override
    public void destroy() {
        System.out.println("========= NoCacheInterceptor.destroy() =============");
    }
}

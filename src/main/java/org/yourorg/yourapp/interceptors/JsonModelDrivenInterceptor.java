package org.yourorg.yourapp.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ModelDriven;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.json.JSONInterceptor;
import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;
import org.yourorg.yourapp.support.CustomHttpServletWrapper;

public class JsonModelDrivenInterceptor extends JSONInterceptor {

    // Make sure you import => org.apache.log4j.Logger 
    private static final Logger LOGGER = Logger.getLogger(JsonModelDrivenInterceptor.class.getName());
    // change this when you add/delete variables or the order of them.
    private static final long serialVersionUID = 1436553694L;

    public JsonModelDrivenInterceptor() {
    }

    @Override
    public void init() {
        LOGGER.debug("========= JsonModelDrivenInterceptor.init() ===============");
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ac = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
        
        if (invocation.getAction() instanceof ModelDriven) {
            setRoot("model");
        } else {
            setRoot(null);
        }
        
//        CustomHttpServletWrapper customHttpServletWrapper = new CustomHttpServletWrapper(request);
//        
//        if(customHttpServletWrapper.getBody().isEmpty() == false) {
//            System.out.println("*** BODY2  ***");
//            System.out.println(customHttpServletWrapper.getBody());
//        }
        
        LOGGER.debug("========= JsonModelDrivenInterceptor.invoke() BEFORE ===============");
        String result = invocation.invoke(); // Invokes the next interceptor (if one exists) or the action
        LOGGER.debug("========= JsonModelDrivenInterceptor.invoke() AFTER ===============");

        setRoot(null);

        return result;
    }

    @Override
    public void destroy() {
        LOGGER.debug("========= JsonModelDrivenInterceptor.destroy() ===============");
    }

}

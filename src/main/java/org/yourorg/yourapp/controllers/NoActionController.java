package org.yourorg.yourapp.controllers;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.yourorg.yourapp.models.EmailData;

public class NoActionController extends CommonActionController {

    private static final long serialVersionUID = 123L;
    private static final Logger LOGGER = Logger.getLogger(NoActionController.class.getName());

    private EmailData emailData; // this object is marshalled from Json.

    public NoActionController() {
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
        if (this.requestAttrs.getHeader("X-HTTP-Method-Override") != null) {
            System.out.println("\n ******** X-HTTP-Method-Override: " + this.requestAttrs.getHeader("X-HTTP-Method-Override"));
        }

        if(emailData == null) {
            emailData = new EmailData();
            emailData.setEmail("wilecoyote@warnerbros.com");
        }
        
        System.out.println("\n******** METHOD: " + method);

        System.out.println("\n******** DATA: " + emailData.toString());

//        try {
//            this.response.setContentType("application/json");
            this.response.setStatus(HttpServletResponse.SC_OK);
//            this.response.getWriter().write(JsonUtils.objectToJsonPrettyNoNulls(this.emailData));
//        } catch (IOException ex) {
//            java.util.logging.Logger.getLogger(NoActionController.class.getName()).log(Level.SEVERE, null, ex);
//        }


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

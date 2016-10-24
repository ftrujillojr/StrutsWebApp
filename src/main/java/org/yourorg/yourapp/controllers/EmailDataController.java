package org.yourorg.yourapp.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.yourorg.yourapp.models.EmailData;

//public class EmailDataController extends CommonActionSupport implements ModelDriven<EmailData> {
public class EmailDataController extends CommonActionSupport {

    private static final long serialVersionUID = 123L;
    private static final Logger LOGGER = Logger.getLogger(EmailDataController.class.getName());

    // These variables are automatically filled in from web request jsp page.
    private EmailData emailData = null;
    private EmailData savedEmailData = null;
    private List<EmailData> emailDataList = null;
    private Integer emailDataListTable_length; // This is on index() page.

    public EmailDataController() {
        super();
        this.emailData = new EmailData();
        this.emailDataList = new ArrayList<>();
    }

    @Override
    public void validate() {
        this.savedEmailData = new EmailData(this.emailData);
        System.out.println(this.savedEmailData.toString());

        if (this.getContextPath() == null) {
            LOGGER.debug("initVars() called from validate() in EmailDataController");
            this.initVars();
        }

        if (this.getAccept().equals("text/html")) {
            if (this.getCurrentMethod().equals("POST")) {
                if (this.emailData.getEmail().isEmpty()) {
                    addFieldError("emailData.email", "Field 'email' must not be null or empty.");
                }
                if (this.emailData.getFirstName().isEmpty()) {
                    addFieldError("emailData.firstName", "Field 'firstName' must not be null or empty.");
                }
                if (this.emailData.getLastName().isEmpty()) {
                    addFieldError("emailData.lastName", "Field 'lastName' must not be null or empty.");
                }
            }
        }
    }

    /*
######   #######   #####   #######  
#     #  #        #     #     #     
#     #  #        #           #     
######   #####     #####      #     
#   #    #              #     #     
#    #   #        #     #     #     
#     #  #######   #####      #     
     */
    /**
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public String index() {
        String response;

        try {
            this.beginTransaction(10);

            Criteria cr = this.session.createCriteria(EmailData.class);
            cr.addOrder(Order.asc("id"));
            this.emailDataList = cr.list();

            if (this.emailDataList == null) {
                this.emailDataList = new ArrayList<>();
            }
            response = this.successResponse(this.emailDataList);

            this.commitTransaction();
        } catch (Exception ex) {
            response = this.rollbackTransaction(ex);
        } finally {
            this.closeSession();
        }

        return response;
    }

    @Override
    public String _new() {
        String response = this.successResponse("_new() is just a pass through for HTML MVC side.");
//        try {
//            this.beginTransaction(10);
//            // your code
//            response = this.successResponse("");
//            this.commitTransaction();
//        } catch (Exception ex) {
//            response = this.rollbackTransaction(ex);
//        } finally {
//            this.closeSession();
//        }

        return response;
    }

    /*

curl -ss -i -H "Accept: application/json" -H "Content-Type: application/json" \
--data '{"emailData":{"email":"ftrujillojr@gmail.com","firstName":"Francis","lastName":"Trujillo"}}' \
--request POST \
http://nsglnxdev1:8085/StrutsWebApp/emailData/
    
     */
    @Override
    public String create() {   // POST  /emailData/
        String response = this.errorResponse("Unable to create() for emailData.");

        System.out.println("emailData => " + this.emailData.toString());
        System.out.println("accept => " + this.getAccept());

        int errorCount = 0;

        if (this.hasActionErrors()) {
            errorCount++;
        } else if (this.hasActionMessages()) {
            Collection<String> actionMessages = this.getActionMessages();
            Iterator<String> itr = actionMessages.iterator();
            while (itr.hasNext()) {
                String message = itr.next();
                if (message.matches(".*[Ee][Rr][Rr][Oo][Rr].*")) {
                    errorCount++;
                }
            }
        }

        if (errorCount > 0) {
            response = this.errorResponse(this.emailData);
        } else {
            response = this.successResponse(this.emailData);
        }

        return response;
    }

    @Override
    public String show() {
        String response;

        if (emailData == null) {
            response = this.errorResponse("Did you forget to SHOW a json payload or a /ID on the end?  emailData was null.");
        } else {
            // Just sending back data inside jsonResponse object.
            // The jsonResponse object will be serialized to json by struts2. (see struts.xml)
            response = this.successResponse(this.emailData);
        }

        return response;
    }

    @Override
    public String edit() {
        String response = this.successResponse("edit() is just a pass through for HTML MVC side.");
        return response;
    }
    
    @Override
    public String invalid() {
        String response = this.errorResponse("invalid()  METHOD / URL");
        return response;
    }

    @Override
    public String update() {
        String response;

        if (emailData == null) {
            response = this.errorResponse("Did you forget to PUT a json payload or a /ID on the end?  emailData was null.");
        } else {
            // Just sending back data inside jsonResponse object.
            // The jsonResponse object will be serialized to json by struts2. (see struts.xml)
            response = this.successResponse(this.emailData);
        }
        this.addActionError("Hello World");
        this.addActionMessage("Action message");
        return response;
    }

    @Override
    public String delete() {
        String response = this.successResponse("DELETE was successful.");
        return response;
    }

    /*    
 #####   #######  #######  #######  #######  ######   
#     #  #           #        #     #        #     #  
#        #           #        #     #        #     #  
 #####   #####       #        #     #####    ######   
      #  #           #        #     #        #   #    
#     #  #           #        #     #        #    #   
 #####   #######     #        #     #######  #     #  


 #####   #######  #######  #######  #######  ######   
#     #  #           #        #     #        #     #  
#        #           #        #     #        #     #  
#  ####  #####       #        #     #####    ######   
#     #  #           #        #     #        #   #    
#     #  #           #        #     #        #    #   
 #####   #######     #        #     #######  #     #  
     */
    public Integer getEmailDataListTable_length() {
        return emailDataListTable_length;
    }

    public void setEmailDataListTable_length(Integer emailDataListTable_length) {
        this.emailDataListTable_length = emailDataListTable_length;
    }

    public EmailData getEmailData() {
        return emailData;
    }

    public void setEmailData(EmailData emailData) {
        System.out.println(emailData.toString());
        this.emailData = emailData;
    }

    public List<EmailData> getEmailDataList() {
        return emailDataList;
    }

    public void setEmailDataList(List<EmailData> emailDataList) {
        this.emailDataList = emailDataList;
    }
}

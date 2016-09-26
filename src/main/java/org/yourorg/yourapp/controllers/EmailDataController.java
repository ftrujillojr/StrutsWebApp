package org.yourorg.yourapp.controllers;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.yourorg.yourapp.models.EmailData;
import org.yourorg.yourapp.models.ResponseObject;

public class EmailDataController extends CommonActionSupport {

    private static final long serialVersionUID = 123L;
    private static final Logger LOGGER = Logger.getLogger(EmailDataController.class.getName());

    // These variables are automatically filled in from web request jsp page.
    private EmailData emailData;
    List<EmailData> emailDataList;
    private String bestFriend;
    private String progLang;
    private String email;
    private String password;
    private Integer emailDataListTable_length;

    public EmailDataController() {
        super();
        this.emailDataList = new ArrayList<>();
    }

//    @Override
//    public void validate() {
//        if (this.getContextPath() == null) {
//            LOGGER.debug("initVars() called from validate() in EmailDataController");
//            this.initVars();
//        }
//    }


    /*
######   #######   #####   #######  
#     #  #        #     #     #     
#     #  #        #           #     
######   #####     #####      #     
#   #    #              #     #     
#    #   #        #     #     #     
#     #  #######   #####      #     
     */
    @Override
    public String index() {

        EmailData obj = new EmailData();
        obj.setEmail("ftrujillojr@gmail.com");
        obj.setFirstName("Francis");
        obj.setLastName("Trujillo");
        obj.setPhone("208-555-5555");
        obj.setAge(51);

        this.emailDataList.add(obj);

        EmailData obj2 = new EmailData();
        obj2.setEmail("n/a");
        obj2.setFirstName("Brisia");
        obj2.setLastName("Trujillo");
        obj2.setPhone("208-123-4567");
        obj2.setAge(8);

        this.emailDataList.add(obj2);

        //this.addActionError("This is a forced Action Error!!  I will take out later.");
        
        String response = this.successResponse(this.emailDataList);

        return response;
    }

    @Override
    public String _new() {
        throw new UnsupportedOperationException("_new() Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // curl -ss -i -H "Accept: application/json" -H "Content-Type: application/json" \
    //       --data {"emailData":{"email":"ftrujillojr@gmail.com","firstName":"Francis","lastName":"Trujillo"}} \
    //       --request POST http://nsglnxdev1.micron.com:8080/StrutsWebApp/homeJson
    @Override
    public String create() {
        String response;
        
        if (emailData == null) {
            response = this.errorResponse("Did you forget to POST a json payload?  emailData was null.");
        } else {
            // Showing emailData was populated from POST payload.
            LOGGER.debug("\n********   DATA: \n" + emailData.toString());

            // Just sending back data inside jsonResponse object.
            // The jsonResponse object will be serialized to json by struts2. (see struts.xml)
            response = this.successResponse(this.emailData);
        }
        return response;
    }

    @Override
    public String show() {
        throw new UnsupportedOperationException("show() Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit() {
        throw new UnsupportedOperationException("edit() Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update() {
        throw new UnsupportedOperationException("update() Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete() {
        throw new UnsupportedOperationException("delete() Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        this.emailData = emailData;
    }

    public List<EmailData> getEmailDataList() {
        return emailDataList;
    }

    public void setEmailDataList(List<EmailData> emailDataList) {
        this.emailDataList = emailDataList;
    }

    public ResponseObject getResponseObject() {
        return responseObject;
    }

    public void setJsonResponse(ResponseObject responseObject) {
        this.responseObject = responseObject;
    }

    public String getBestFriend() {
        return bestFriend;
    }

    public void setBestFriend(String bestFriend) {
        this.bestFriend = bestFriend;
    }

    public String getProgLang() {
        return progLang;
    }

    public void setProgLang(String progLang) {
        this.progLang = progLang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package org.yourorg.yourapp.controllers;

import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.log4j.Logger;
import org.yourorg.yourapp.models.EmailData;
import org.yourorg.yourapp.models.ResponseObject;

public class NoActionController extends CommonActionSupport {

    private static final long serialVersionUID = 123L;
    private static final Logger LOGGER = Logger.getLogger(NoActionController.class.getName());

    // These variables are automatically filled in from web request jsp page.
    private EmailData emailData;
    private String bestFriend;
    private String progLang;
    private String email;
    private String password;

    public NoActionController() {
        super();
    }

//    @Override
//    public void validate() {
//        if (this.getContextPath() == null) {
//            LOGGER.debug("initVars() called from validate() in NoActionController");
//            this.initVars();
//        }
//    }
    public String noAction() {
        StringBuilder sb = new StringBuilder();
        sb.append("  progLang: ").append(this.progLang).append("\n");
        sb.append("bestFriend: ").append(this.bestFriend).append("\n");

        LOGGER.debug(sb.toString());

        String response = ActionSupport.SUCCESS;
        
        this.successResponse("Just testing noAction() method.");
        
        if (this.getAccept().matches(".*application/xml.*")) {
            this.marshallResponseObject2InputStream();
            response = "xml";
        }
        if (this.getAccept().matches(".*application/json.*")) {
            response = "json";
        }

        return response;
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
    @Override
    public String index() {
        List<Object> emailDataList = new ArrayList<>();

        EmailData obj = new EmailData();
        obj.setEmail("ftrujillo@micron.com");
        obj.setFirstName("Francis");
        obj.setLastName("Trujillo");
        obj.setPhone("208-555-5555");
        obj.setAge(51);

        emailDataList.add(obj);

        EmailData obj2 = new EmailData();
        obj2.setEmail("ftrujillojr@gmail.com");
        obj2.setFirstName("Francis");
        obj2.setLastName("Trujillo");
        obj2.setPhone("208-555-4321");
        obj2.setAge(52);

        //this.jsonResponse.addToDataList(obj2);
        emailDataList.add(obj2);

        this.successResponse(emailDataList, HttpServletResponse.SC_OK);

        return "json";
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
        if (emailData == null) {
            String errMsg = "Did you forget to POST a json payload?  emailData.";
            this.errorResponse(errMsg, HttpServletResponse.SC_BAD_REQUEST);
        } else {
            // Showing emailData was populated from POST payload.
            LOGGER.debug("\n********   DATA: \n" + emailData.toString());

            // Just sending back data inside jsonResponse object.
            // The jsonResponse object will be serialized to json by struts2. (see struts.xml)
            this.successResponse(this.emailData, HttpServletResponse.SC_CREATED);
        }
        return "json";
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
    public EmailData getEmailData() {
        return emailData;
    }

    public void setEmailData(EmailData emailData) {
        this.emailData = emailData;
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

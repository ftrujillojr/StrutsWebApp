package org.yourorg.yourapp.controllers;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.yourorg.yourapp.models.EmailData;

public class NoActionController extends CommonActionSupport {

    private static final long serialVersionUID = 123L;
    private static final Logger LOGGER = Logger.getLogger(NoActionController.class.getName());

    private EmailData emailData; // this object is marshalled from Json.

    private String bestFriend;
    private String progLang;
    private String email;
    private String password;

    public NoActionController() {
    }

    public String noAction() {
        if (emailData == null) {
            emailData = new EmailData();
            emailData.setEmail("wilecoyote@warnerbros.com");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("  progLang: ").append(this.progLang).append("\n");
        sb.append("bestFriend: ").append(this.bestFriend).append("\n");
        sb.append(" emailData: ").append(this.emailData.toString()).append("\n");

        LOGGER.debug(sb.toString());

        return ActionSupport.SUCCESS;
    }

    public EmailData getEmailData() {
        return emailData;
    }

    public void setEmailData(EmailData emailData) {
        this.emailData = emailData;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String _new() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // curl -ss -i -H "Accept: application/json" -H "Content-Type: application/json" \
    //       --data {"emailData":{"email":"ftrujillojr@gmail.com","firstName":"Francis","lastName":"Trujillo"}} \
    //       --request POST http://nsglnxdev1.micron.com:8080/StrutsWebApp/homeJson
    @Override
    public String create() {
        System.out.println("\n******** create()");

        if (emailData == null) {
            emailData = new EmailData();
            emailData.setEmail("wilecoyote@warnerbros.com");
        }

        System.out.println("\n********   DATA: " + emailData.toString());

//        try {
//            this.response.setContentType("application/json");
        this.response.setStatus(HttpServletResponse.SC_OK);
//            this.response.getWriter().write(JsonUtils.objectToJsonPrettyNoNulls(this.emailData));
//        } catch (IOException ex) {
//            java.util.logging.Logger.getLogger(NoActionController.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return "json";
    }

    @Override
    public String show() {
        throw new UnsupportedOperationException("Not supported yet.  Please override"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit() {
        throw new UnsupportedOperationException("Not supported yet.  Please override"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update() {
        throw new UnsupportedOperationException("Not supported yet.  Please override"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete() {
        throw new UnsupportedOperationException("Not supported yet.  Please override"); //To change body of generated methods, choose Tools | Templates.
    }
}

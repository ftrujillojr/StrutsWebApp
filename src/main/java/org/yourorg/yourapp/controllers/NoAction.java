package org.yourorg.yourapp.controllers;

import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import org.apache.log4j.Logger;
import org.yourorg.yourapp.models.EmailData;

public class NoAction extends ActionSupport implements Serializable {

    private static final long serialVersionUID = 123L;
    private static final Logger LOGGER = Logger.getLogger(NoAction.class.getName());

    private EmailData emailData; // this object is marshalled from Json.
    
    public NoAction() {
    }

    @Override
    public String execute() {
        return ActionSupport.SUCCESS;
    }

    // curl -ss -i -H "Accept: application/json" -H "Content-Type: application/json" \
    //       --data {"emailData":{"email":"ftrujillojr@gmail.com","firstName":"Francis","lastName":"Trujillo"}} \
    //       --request POST http://nsglnxdev1.micron.com:8080/StrutsWebApp/homeJson
    public String homeJson() {
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

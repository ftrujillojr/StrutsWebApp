package org.yourorg.yourapp.controllers;

import com.opensymphony.xwork2.ActionSupport;
import org.yourorg.yourapp.models.EmailData;

public class NoAction extends ActionSupport {
    private static final long serialVersionUID = 123L;
    
    EmailData emailData; // this is from Json
    
    @Override
    public String execute() {
        return ActionSupport.SUCCESS;
    }
    
    public String noAction() {
        return ActionSupport.SUCCESS;
    }
}

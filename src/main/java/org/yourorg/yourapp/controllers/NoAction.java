package org.yourorg.yourapp.controllers;

import com.opensymphony.xwork2.ActionSupport;

public class NoAction extends ActionSupport {
    private static final long serialVersionUID = 123L;
    
    @Override
    public String execute() {
        return ActionSupport.SUCCESS;
    }
    
    public String noAction() {
        return ActionSupport.SUCCESS;
    }
}

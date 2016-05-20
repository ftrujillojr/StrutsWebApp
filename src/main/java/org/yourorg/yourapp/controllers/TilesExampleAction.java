package org.yourorg.yourapp.controllers;

import com.opensymphony.xwork2.ActionSupport;

public class TilesExampleAction extends ActionSupport {
    private static final long serialVersionUID = 1436553694L;

    public String tiger() {
        return "tiger";
    }

    public String lion() {
        return "lion";
    }
    
}

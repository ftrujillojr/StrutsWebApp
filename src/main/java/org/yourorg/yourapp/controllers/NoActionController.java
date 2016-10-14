package org.yourorg.yourapp.controllers;

import org.apache.log4j.Logger;
import org.yourorg.yourapp.models.ResponseObject;

public class NoActionController extends CommonActionSupport {

    private static final long serialVersionUID = 123L;
    private static final Logger LOGGER = Logger.getLogger(NoActionController.class.getName());

    // These variables are automatically filled in from web request jsp page.
    private Integer id;
    private Integer emailDataListTable_length;

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
        String response = this.successResponse("Just testing noAction() method.");
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
        String response = this.successResponse("Testing index() method.");
        return response;
    }

    @Override
    public String _new() {
        throw new UnsupportedOperationException("_new() Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String create() {
        String response = this.successResponse("Testing create() method.");
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
    
    

    public ResponseObject getResponseObject() {
        return responseObject;
    }

    public void setJsonResponse(ResponseObject responseObject) {
        this.responseObject = responseObject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}

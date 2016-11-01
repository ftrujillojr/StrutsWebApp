package org.yourorg.yourapp.controllers;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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

        this.displayErrorResponseObjectToJSPIfHTML();
        return response;
    }

    @Override
    public String _new() {
        String response = this.successResponse("_new() is just a pass through for HTML MVC side.");
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

        try {
            this.beginTransaction(10);
            
            Query query = this.session.createQuery("SELECT count(*) FROM EmailData WHERE email=:EMAIL");
            query.setString("EMAIL", this.emailData.getEmail());
            Long numRows = (Long) query.uniqueResult();

            // Insert new row only if no rows exist for EMAIL.
            if (numRows != null && numRows == 0) {
                this.emailData.setId(null);        // ensure ID is null.
                this.session.save(this.emailData); // persist data

                Criteria cr = this.session.createCriteria(EmailData.class);
                cr.add(Restrictions.eq("email", this.savedEmailData.getEmail()));
                this.emailData = (EmailData) cr.uniqueResult();

                if (this.emailData != null) {
                    response = this.successResponse(this.emailData);
                } else {
                    response = this.errorResponse("Unable to read back record after create()", this.savedEmailData);
                }
            } else {
                response = this.errorResponse("Row has been inserted for EMAIL already", this.emailData);
            }

            this.commitTransaction();
        } catch (Exception ex) {
            response = this.rollbackTransaction(ex);
        } finally {
            this.closeSession();
        }

        this.displayErrorResponseObjectToJSPIfHTML();
        return response;
    }

    @Override
    public String show() {   // GET /emailData/12
        String response = this.errorResponse("Unable to show() id => " + this.getId1());

        try {
            this.beginTransaction(10);
            Query query = this.session.createQuery("SELECT count(*) FROM EmailData WHERE id=:ID1");
            query.setInteger("ID1", this.getId1());
            Long numRows = (Long) query.uniqueResult();

            if (numRows != null && numRows == 1) {
                Criteria cr = this.session.createCriteria(EmailData.class);
                cr.add(Restrictions.eq("id", this.getId1()));
                this.emailData = (EmailData) cr.uniqueResult();
                response = this.successResponse(this.emailData);
            } else {
                response = this.errorResponse("Could not find row with ID " + this.getId1());
            }

            this.commitTransaction();
        } catch (Exception ex) {
            response = this.rollbackTransaction(ex);
        } finally {
            this.closeSession();
        }

        this.displayErrorResponseObjectToJSPIfHTML();
        return response;
    }

    @Override
    public String edit() {
        String response = this.errorResponse("Unable to edit() id => " + this.getId1());

        try {
            this.beginTransaction(10);
            Query query = this.session.createQuery("SELECT count(*) FROM EmailData WHERE id=:ID1");
            query.setInteger("ID1", this.getId1());
            Long numRows = (Long) query.uniqueResult();

            if (numRows != null && numRows == 1) {
                Criteria cr = this.session.createCriteria(EmailData.class);
                cr.add(Restrictions.eq("id", this.getId1()));
                this.emailData = (EmailData) cr.uniqueResult();
                response = this.successResponse(this.emailData);
            } else {
                response = this.errorResponse("Could not find row with ID " + this.getId1());
            }

            this.commitTransaction();
        } catch (Exception ex) {
            response = this.rollbackTransaction(ex);
        } finally {
            this.closeSession();
        }

        this.displayErrorResponseObjectToJSPIfHTML();
        return response;
    }

    @Override
    public String invalid() {
        String response = this.errorResponse("invalid()  METHOD / URL", this.emailData);
        this.displayErrorResponseObjectToJSPIfHTML();
        return response;
    }

    @Override
    public String update() {
        String response = this.errorResponse("Unable to update() emailData.", this.emailData);

        try {
            this.beginTransaction(10);
            Criteria cr = this.session.createCriteria(EmailData.class);
            cr.add(Restrictions.eq("id", this.getId1()));
            EmailData recordToUpdate = (EmailData) cr.uniqueResult();

            if (recordToUpdate != null) {
                recordToUpdate.setEmail(this.emailData.getEmail());
                recordToUpdate.setFirstName(this.emailData.getFirstName());
                recordToUpdate.setLastName(this.emailData.getLastName());
                recordToUpdate.setPhone(this.emailData.getPhone());
                recordToUpdate.setAge(this.emailData.getAge());

                this.session.update(recordToUpdate);
                this.emailData = new EmailData(recordToUpdate);
                response = this.successResponse("Record update() SUCCESS.", this.emailData);
            } else {
                response = this.errorResponse("ERROR: There is no record to update().", this.emailData);
            }

            this.commitTransaction();
        } catch (Exception ex) {
            response = this.rollbackTransaction(ex);
        } finally {
            this.closeSession();
        }

        this.displayResponseObjectToJSPIfHTML();
        return response;
    }

    @Override
    public String delete() {
        String response = this.errorResponse("delete() FAILED", this.emailData);
        try {
            this.beginTransaction(10);
            Criteria cr = this.session.createCriteria(EmailData.class);
            cr.add(Restrictions.eq("id", this.getId1()));
            EmailData recordToDelete = (EmailData) cr.uniqueResult();

            if (recordToDelete != null) {
                this.session.delete(recordToDelete);
                response = this.successResponse("delete() SUCCESS for ID " + this.getId1());
            } else {
                response = this.errorResponse("There is no record to delete() for ID " + this.getId1());
            }

            this.commitTransaction();
        } catch (Exception ex) {
            response = this.rollbackTransaction(ex);
        } finally {
            this.closeSession();
        }

        this.displayResponseObjectToJSPIfHTML();
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

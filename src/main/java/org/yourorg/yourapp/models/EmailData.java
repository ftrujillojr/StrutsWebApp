package org.yourorg.yourapp.models;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.yourorg.yourapp.exceptions.DateUtilsException;
import org.yourorg.yourapp.support.DateUtils;

@Entity
@Table(name = "EmailData")
public class EmailData implements Serializable {

    private static final long serialVersionUID = 123L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "phone", nullable = true)
    private String phone;
    @Column(name = "age", nullable = true)
    private Integer age;
    @Column(name = "modifiedDateTime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDateTime;
    @Column(name = "createdDateTime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    

    public EmailData() {
    }

    public EmailData(EmailData rhs) {
        this.id = rhs.getId();
        this.email = rhs.getEmail();
        this.firstName = rhs.getFirstName();
        this.lastName = rhs.getLastName();
        this.phone = rhs.getPhone();
        this.age = rhs.getAge();
        this.modifiedDateTime = rhs.getModifiedDateTime();
        this.createdDateTime = rhs.getCreatedDateTime();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmailData").append("\n");
        sb.append("              id:").append(this.id).append("\n");
        sb.append("           email:").append(this.email).append("\n");
        sb.append("       firstName:").append(this.firstName).append("\n");
        sb.append("        lastName:").append(this.lastName).append("\n");
        sb.append("           phone:").append(this.phone).append("\n");
        sb.append("             age:").append(this.age).append("\n");
        sb.append("modifiedDateTime:").append(this.getModifiedDateTimeString()).append("\n");
        sb.append(" createdDatetime:").append(this.getCreatedDateTimeString()).append("\n\n");
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
    
    public String getCreatedDateTimeString() {
        return DateUtils.getProjectDateString(createdDateTime);
    }

    public void setCreatedDateTimeString(String createdDateTime) throws ParseException, DateUtilsException {
        this.createdDateTime = DateUtils.parse(createdDateTime);
    }
    
    public String getModifiedDateTimeString() {
        return DateUtils.getProjectDateString(modifiedDateTime);
    }
    
    public void setModifiedDateTimeString(String modifiedDateTime) throws ParseException, DateUtilsException {
        this.modifiedDateTime = DateUtils.parse(modifiedDateTime);
    }
}

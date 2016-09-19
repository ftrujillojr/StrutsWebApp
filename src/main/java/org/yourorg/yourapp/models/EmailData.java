package org.yourorg.yourapp.models;

import java.io.Serializable;

public class EmailData implements Serializable {
    private static final long serialVersionUID = 123L;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Integer age;

    public EmailData() {}
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmailData").append("\n");
        sb.append("       email:").append(this.email).append("\n");
        sb.append("   firstName:").append(this.firstName).append("\n");
        sb.append("    lastName:").append(this.lastName).append("\n");
        sb.append("       phone:").append(this.phone).append("\n");
        return sb.toString();
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
    
}

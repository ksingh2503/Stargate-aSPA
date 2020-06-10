package com.spa.stargate.stargatespa.model;

public class LoginObject {
    
    private String s_emailId;
    private String s_password;

    /**
     * @return String return the s_emailId
     */
    public String getS_emailId() {
        return s_emailId;
    }

    /**
     * @param s_emailId the s_emailId to set
     */
    public void setS_emailId(String s_emailId) {
        this.s_emailId = s_emailId;
    }

    /**
     * @return String return the s_password
     */
    public String getS_password() {
        return s_password;
    }

    /**
     * @param s_password the s_password to set
     */
    public void setS_password(String s_password) {
        this.s_password = s_password;
    }


    public LoginObject() {
    }

    public LoginObject(String s_emailId, String s_password) {

        this.s_emailId = s_emailId;
        this.s_password = s_password;
    }


}
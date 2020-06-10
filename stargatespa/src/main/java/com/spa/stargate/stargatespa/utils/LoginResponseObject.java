package com.spa.stargate.stargatespa.utils;

public class LoginResponseObject {

    private int id;
    private String s_email;
    private String s_password;
    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the s_email
     */
    public String getS_email() {
        return s_email;
    }

    /**
     * @param s_email the s_email to set
     */
    public void setS_email(String s_email) {
        this.s_email = s_email;
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

}

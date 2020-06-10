package com.spa.stargate.stargatespa.dao;

import com.spa.stargate.stargatespa.model.LoginObject;


public interface LoginDao {
    
    Boolean checkUserExists(LoginObject loginObject);

    String saveLoginToken(String userEmail);

}
package com.spa.stargate.stargatespa.facadeImpl;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.spa.stargate.stargatespa.dao.LoginDao;
import com.spa.stargate.stargatespa.facade.LoginFacade;
import com.spa.stargate.stargatespa.model.LoginObject;
import com.spa.stargate.stargatespa.utils.JwtUtil;

@Bean
public class LoginFacadeImpl implements LoginFacade {

    @Inject
    private LoginDao loginDao;

    JwtUtil jwtutil = new JwtUtil();

    @Override
    public String doLoginFcd(LoginObject loginObject) {
        String token = "";
        boolean validateLogin = validateLoginParamFromDb(loginObject);
        if(validateLogin){
            token = generateUserToken(loginObject.getS_emailId());
        }
        if(token.length()>0){
            return token;
        }
        else{
            return "You are not authorized";
        }
    }
    
    public Boolean validateLoginParamFromDb(LoginObject loginObject){
        boolean validateLogin = loginDao.checkUserExists(loginObject);
        return validateLogin;
    }

    public String generateUserToken(String userEmail){
        String jwtToken = jwtutil.generateToken(userEmail);
        return jwtToken;
    }
}
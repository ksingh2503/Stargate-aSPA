package com.spa.stargate.stargatespa.controller;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.spa.stargate.stargatespa.facade.LoginFacade;
import com.spa.stargate.stargatespa.model.LoginObject;

@Path
public class LoginController {

    @Inject
    LoginFacade loginFacade;

    @PostRoute("/doLogin")
    @JSON
    public String doLogin(@Param LoginObject loginObject){
        String token = loginFacade.doLoginFcd(loginObject);
        return token;
    }
}
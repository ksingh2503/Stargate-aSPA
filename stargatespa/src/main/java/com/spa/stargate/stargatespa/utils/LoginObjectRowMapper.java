package com.spa.stargate.stargatespa.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

public class LoginObjectRowMapper implements RowMapper<LoginResponseObject> {

    @Override
    public LoginResponseObject mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        LoginResponseObject loginResObject = new LoginResponseObject();
        if(rs.next()){
            loginResObject.setId(rs.getInt("id"));
            loginResObject.setS_email(rs.getString("email"));
            loginResObject.setS_password(rs.getString("password"));
        }
        return loginResObject;

    }
    
}
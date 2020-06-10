package com.spa.stargate.stargatespa.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.spa.stargate.stargatespa.config.DatabaseConfig;
import com.spa.stargate.stargatespa.dao.LoginDao;
import com.spa.stargate.stargatespa.model.LoginObject;
import org.springframework.jdbc.core.JdbcTemplate;

@Bean
public class LoginDaoImpl implements LoginDao {

    @Inject
    private DatabaseConfig pgConfig;

    /**
     * @Getter method of DatabaseConfig to access database
     * @return JdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(pgConfig.getDMDataSource());
    }
    
    @Override
    public Boolean checkUserExists(LoginObject loginObject) {
        
        List<LoginObject> loginObjectList = new ArrayList<>();
        ResultSet rs = null;
        String Query = "Select email, password from UserMaster where email = ? and password = ?";
        try (Connection connection = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/LoginTbl", "postgres", "harry000");

            PreparedStatement preparedStatement = connection.prepareStatement(Query);) {  
            preparedStatement.setString(1, loginObject.getS_emailId());
            preparedStatement.setString(2, loginObject.getS_password());
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LoginObject lFoundObject = new LoginObject();
                lFoundObject.setS_emailId(rs.getString("email"));
                lFoundObject.setS_emailId(rs.getString("password"));
                loginObjectList.add(lFoundObject);
            }
            
        } catch (Exception e) {
        e.printStackTrace();
    }
    finally{
        try {
            rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        System.out.println(loginObjectList.size());
        if(loginObjectList.size()>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String saveLoginToken(String userEmail) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
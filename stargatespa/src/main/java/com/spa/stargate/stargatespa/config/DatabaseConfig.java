package com.spa.stargate.stargatespa.config;

import javax.sql.DataSource;
import com.blade.Blade;
import com.blade.ioc.annotation.Bean;
import com.blade.loader.BladeLoader;
import com.spa.stargate.stargatespa.utils.PropertyFileReader;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Bean
public class DatabaseConfig implements BladeLoader {

    private PropertyFileReader propFileReader;
    private DriverManagerDataSource driverManagerDataSource;

    
    @Override
    public void load(Blade blade) {
        this.propFileReader = new PropertyFileReader(blade.environment().getOrNull("sql.library.file"));
        this.driverManagerDataSource = new DriverManagerDataSource();
        this.driverManagerDataSource.setDriverClassName(blade.environment().getOrNull("jdbc.driver"));
        this.driverManagerDataSource.setUrl(blade.environment().getOrNull("jdbc.url"));
        this.driverManagerDataSource.setUsername(blade.environment().getOrNull("jdbc.username"));
        this.driverManagerDataSource.setPassword(blade.environment().getOrNull("jdbc.password"));
    }

    public PropertyFileReader getPropertyFileReader(){
        return this.propFileReader;
    }

    public DataSource getDMDataSource(){
        return this.driverManagerDataSource;
    }
    
}
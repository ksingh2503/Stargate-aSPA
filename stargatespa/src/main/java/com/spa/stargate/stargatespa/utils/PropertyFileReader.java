package com.spa.stargate.stargatespa.utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
    private String filename;
    private InputStream inputStream;

    public PropertyFileReader(){}
    public PropertyFileReader(String filename) {
        this.filename = filename;
    }
    public void setFilename(String fname){
        this.filename = fname;
    }

    public String getValue(String key) throws FileNotFoundException {
        String value = null;
        Properties property = new Properties();
        this.inputStream = getClass().getClassLoader().getResourceAsStream(this.filename);
        try {
            property.load(inputStream);
            value = property.getProperty(key);
        } catch (IOException e) {
            throw new FileNotFoundException("property file '" + this.filename + "' not found in the classpath");
        } finally {
            try{
                if(this.inputStream!=null)
                    this.inputStream.close();
            }catch(IOException e){}
        }
        return value;
    }
}
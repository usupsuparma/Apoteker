/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Setting;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author user
 */
public class Config {

    private Properties properties;
    private String host;
    private String username;
    private String password;
    private String database;

    public Config() {
        File file = new File("setting//aturdb.properties");
        try {
            InputStream in = new FileInputStream(file);
            properties = new Properties();
            properties.load(in);
            host = properties.getProperty("host");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            database = properties.getProperty("database");
        } catch (Exception ex) {
            System.out.println("Error");
            
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }
    
}

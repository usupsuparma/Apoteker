/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Setting;
import java.sql.*;


/**
 *
 * @author user
 */
public class Koneksi {
    private Connection c=null;
    private Statement st=null;
    private Config config;
    private String url;
    private String user;
    private String pass;
    
    public Koneksi() {
        config = new Config();
        url="jdbc:mysql://"+config.getHost()+"/"+config.getDatabase();
        user= config.getUsername();
        pass = config.getPassword();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("error koneksi");
        }
    }

    public boolean query (String q) {
        try {
            c= DriverManager.getConnection(url, user, pass);
            st= c.createStatement();
            st.executeUpdate(q);
            return true;
        } catch (SQLException e) {
            System.out.println("error query");
            return false;
        }
    }
    
    public ResultSet select (String q) {
        ResultSet rs=null;
        try {
            c= DriverManager.getConnection(url, user, pass);
            st = c.createStatement();
            rs= st.executeQuery(q);
        }catch (SQLException e) {
            System.out.println("error ambil data");
        }
        return rs;
    }
    
}

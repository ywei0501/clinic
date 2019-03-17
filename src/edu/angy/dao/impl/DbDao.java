package edu.angy.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbDao {
	private Connection connection;
    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql:///Clinic";
    private String username="root";
    private String pass="123456";
    
    public DbDao(){
        
    }
    
    public DbDao(String driver, String url, String username, String pass) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.pass = pass;
    }

    public Connection getConn() {
        return connection;
    }

    public void setConn(Connection conn) {
        this.connection = conn;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    // get database connection
    public Connection getConnection() throws Exception {
        if(connection == null){
            Class.forName(this.driver);
            connection = (Connection) DriverManager.getConnection(url, username, this.pass);
        }
        return connection;
    }
    
    // insert records
    public boolean insert(String sql, Object... args) throws Exception{
        PreparedStatement pstmt = (PreparedStatement) getConnection().prepareStatement(sql);
        for(int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]); 
        }
        if(pstmt.executeUpdate() != 1)   //判断记录的更新是否加1
            return false;
        return true;
    }
    
    // execute query
    public ResultSet query(String sql, Object...args) throws Exception{
        PreparedStatement pstmt = (PreparedStatement) getConnection().prepareStatement(sql);
        for(int i=0; i< args.length; i++) {
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt.executeQuery();
    }
    
    public ResultSet query2(String sql) throws Exception{
        PreparedStatement pstmt = (PreparedStatement) getConnection().prepareStatement(sql);      
        return pstmt.executeQuery();
    }
    
    public void modify(String sql, Object...args) throws Exception{
        PreparedStatement pstmt = (PreparedStatement)getConnection().prepareStatement(sql);
        for(int i = 0; i< args.length; i++) {
            pstmt.setObject(i+1, args[i]);
        }
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    public void closeConn() throws Exception{
        if(connection != null && !connection.isClosed())
        	connection.close();
    }

}

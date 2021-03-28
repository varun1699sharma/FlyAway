package com.simplilearn.workshop;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Validate {
    public  User checkUser(String username,String password) throws SQLException, ClassNotFoundException, ClassNotFoundException
    {
       //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://localhost:3306/studentdb?useSSL=false";
            String dbUser = "root";
            String dbPassword = "root";
            
            //creating connection with the database
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            String sql = "select * from login where username=? and password=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs =statement.executeQuery();
          
            
            User user= null;
            if (rs.next()) {
            	user = new User();
            	user.setUsername(username);
            	user.setPassword(password);
            }
            connection.close();
            return user;
        
             }   
}
   
    
package com.test;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoClass
{
    public static void main(String[] args) throws Exception {
        String url ="jdbc:mysql://localhost:3306/spring";
        String uame = "root";
        String pass = "Chand#2022";
        String query = "select * from employee";

        //Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uame,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        String userData = " ";
       while(rs.next()) {  //keeping cursor to first value of the table
            userData = rs.getInt(1) + " : " + rs.getString(2);
            System.out.println(userData);
       }
//        rs.next();  //keeping cursor to first value of the table
//        userData = rs.getInt(1) + " : " + rs.getString(2);
//        System.out.println(userData);
//
        st.close();
        con.close();
    }
}

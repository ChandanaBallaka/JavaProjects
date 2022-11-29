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
        int id=1;
        String name="Deepu";
        int salary=200000;
        String query = "insert into employee values (?,?,?)";

        Connection con = DriverManager.getConnection(url,uame,pass);
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,id);
        st.setString(2,name);
        st.setInt(3,salary);
        int count = st.executeUpdate();
        System.out.println(count + "rows affected");
//        String userData = " ";
//        while(rs.next()) {  //keeping cursor to first value of the table
//            userData = rs.getInt(1) + " : " + rs.getString(2);
//            System.out.println(userData);
//        }
////        rs.next();  //keeping cursor to first value of the table
//        userData = rs.getInt(1) + " : " + rs.getString(2);
//        System.out.println(userData);
//
        st.close();
        con.close();
    }
}

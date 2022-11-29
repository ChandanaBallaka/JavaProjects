package com.test;
import java.sql.*;
public class DemoClass
{
    public static void main(String[] args) throws Exception {
        String url ="jdbc:mysql://localhost:3306/spring";
        String uame = "root";
        String pass = "Chand#2022";
        String query = "select name from employee where id =  44";

       //Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uame,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);//execute querry returns the objects.
        rs.next();  //keeping cursor to first value of the table
        String name = rs.getString("name");

        System.out.println(name);
        st.close();
        con.close();
    }
}

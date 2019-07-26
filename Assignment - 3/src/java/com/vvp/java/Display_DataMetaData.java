/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 *
 * @author PRIYANK DHRUV
 */
public class Display_DataMetaData {
    
    public static void main(String a[]) throws ClassNotFoundException{
        
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "");
            DatabaseMetaData dm = con.getMetaData();
            System.out.println(dm.getDriverVersion());
            System.out.println(dm.getDriverName());
            System.out.println(dm.getDatabaseProductName());
            System.out.println(dm.getDatabaseProductVersion());
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            
            if(con != null){
                try {
                    con.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

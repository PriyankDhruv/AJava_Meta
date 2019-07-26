/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;
import java.sql.*;


/**
 *
 * @author PRIYANK DHRUV
 */
public class Display_StudentData{
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
    
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
    
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            stmt = con.createStatement();
            String sql = "Select * from student";
            rs = stmt.executeQuery(sql);
            System.out.println("EnrollmentNo " + "StudentName " + "Semester " + "Branch " + "\n");
            
            while(rs.next()){
                
                System.out.println(rs.getInt("EnrollmentNo") +  "           " + 
                                   rs.getString("StudentName") + "        " +
                                   rs.getInt("Semester") + "        " +
                                   rs.getString("Branch"));
            }
            
        }finally{
            
            con.close();  
        } 
    }
}

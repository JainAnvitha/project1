package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SignUpDB 
{
 
     public boolean register(String fname,String lname,String uname,String pwd)
    {
        boolean flagForRegistration=false ;
        Connection connectionObject=null;
        PreparedStatement statementObject=null;
        ResultSet resultSetObject=null;
        
        String query="INSERT INTO USER(fname,lname,uname,pwd) VALUES (?,?,?,?)";
        
        DBConnect databaseObject=new DBConnect();
        connectionObject = databaseObject.makeConnection();
        
        if(connectionObject!=null)
        {
            try 
           {
                statementObject=connectionObject.prepareStatement(query);
                System.out.println("Query is:"+query);
                statementObject = connectionObject.prepareStatement(query);
                statementObject.setString(1, fname);
                statementObject.setString(2, lname);  
                statementObject.setString(3, uname);
                statementObject.setString(4, pwd);
                
              flagForRegistration= statementObject.execute();
  
                
           } 
            catch (SQLException ex) 
            {
                System.out.println("exception:"+ex);
          }
           
        
        }
  
        return flagForRegistration;
    }
    
}


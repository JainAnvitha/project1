package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginDB 
{

    
    public boolean login(String username,String password)
    {
        boolean flagForLogin=false ;
        Connection connectionObject=null;
        PreparedStatement statementObject=null;
        ResultSet resultSetObject=null;
        
        String query="select * from USER where uname=? and pwd=?";
        
        DBConnect databaseObject=new DBConnect();
        connectionObject = databaseObject.makeConnection();
        
        if(connectionObject!=null)
        {
            try 
           {
                statementObject=connectionObject.prepareStatement(query);
                System.out.println("Query:"+query);
                statementObject = connectionObject.prepareStatement(query);
                statementObject.setString(1, uname);
                statementObject.setString(2, pwd);
                resultSetObject = statementObject.executeQuery();
                
                if(resultSetObject.next())
                    flagForLogin=true; 
                else
                    flagForLogin=false;
                
                
                
                
           } 
            catch (SQLException ex) 
            {
                System.out.println("Exception is:"+ex);
          }
            
        
        }
  
        return flagForLogin;
    }
}
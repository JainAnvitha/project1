package com.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileDeleteFromDB {
    
    public void del(String filename)
    {
        Connection connectionObject=null;
        
        ResultSet resultSetObject=null;
        
        String query0 = "SET SQL_SAFE_UPDATES = 0";
        String query="delete from filedetails where filename=?";
        
        DBConnect databaseObject=new DBConnect();
        connectionObject = databaseObject.makeConnection();
        
        if(connectionObject!=null)
        {
            try 
           {
               
                statementObject=connectionObject.prepareStatement(query);
                System.out.println("dbquery:"+query);
                statementObject = connectionObject.prepareStatement(query);
                statementObject.setString(1, filename);
                statementObject.executeUpdate();
                
                      
                
                
           } 
            catch (SQLException ex) 
            {
                System.out.println("exception:"+ex);
          }
        
        }
  
      
    }
    
}


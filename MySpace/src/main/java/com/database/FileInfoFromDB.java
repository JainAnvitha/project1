package com.database;

import com.pojo.DBPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileInfoFromDB 
{
    
     public  ArrayList<DBPojo> fetchData(String username)
    {
       
       
        Connection connectionObject=null;
        PreparedStatement statementObject=null;
        ResultSet resultSetObject=null;
        
         ArrayList<DBPojo> pojo=new ArrayList<DBPojo>();
         DBPojo pojoObject;
         
        String query= "select * from filedetails where username=?";

        
        DBConnect databaseObject=new DBConnect();
        connectionObject = databaseObject.makeConnection();
        
        System.out.println("db connection is made");
        
        if(connectionObject!=null)
        {
            
            try 
           {
               
                statementObject=connectionObject.prepareStatement(query);
              
                statementObject.setString(1, username);
             
                
                
               resultSetObject = statementObject.executeQuery();
            
                while(resultSetObject.next())
                {
                     System.out.println("db file_detail");
                    pojoObject=new DBPojo();
                    String file_name=resultSetObject.getString("filename");
                    String file_upload_time=resultSetObject.getString("uploadtime");
                    String file_description=resultSetObject.getString("description");
                    String user_name=resultSetObject.getString("username");
                   
                    
                  
                    pojoObject.setFileName(file_name);
                    pojoObject.setFileDescription(file_description);
                    pojoObject.setFileUploadTime(file_upload_time);
                    pojoObject.setUserName(user_name);
                   
                    pojo.add(pojoObject);  
                    System.out.println("all object details from db");
                }
                
             
                
                
           } 
            catch (SQLException ex) 
            {
              ex.printStackTrace();
          }
    
        
        }
        return pojo;

    }
    
    
}

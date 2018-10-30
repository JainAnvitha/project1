package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileDetailsToDatabase 
{
    public void addDataIntoDatabase(String username,ArrayList<String> arrayListOfFile)
    {
        
         boolean flagForLogin=false ;
        Connection connectionObject=null;
        PreparedStatement statementObject=null;
        ResultSet resultSetObject=null;
        int primary_key_one;
        
        String query2;
        query2 = "INSERT INTO filedetails(username,filename,description,uploadtime) VALUES (?,?,?,?)";
        
        DBConnect databaseObject=new DBConnect();
        connectionObject = databaseObject.makeConnection();
        
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date date = new Date();
         String dateString=dateFormat.format(date);
      
        
        if(connectionObject!=null)
        {
            try 
           {
                statementObject=connectionObject.prepareStatement(query2);
                System.out.println("Query is:"+query2);
                statementObject = connectionObject.prepareStatement(query2);
           
                
               for(int i=0;i<arrayListOfFile.size();i++)
               {

                    String filename=arrayListOfFile.get(i).toString();
                    String description=filename.substring(filename.lastIndexOf(".") + 1);
                    statementObject.setString(1, username);
                    statementObject.setString(2,filename );
                    statementObject.setString(3, description);
                    statementObject.setString(4, dateString);
                    
                    statementObject.execute();
               }
               
                System.out.println("DB update information.");
               
                
                
                
                
                
           } 
            catch (SQLException ex) 
            {
                System.out.println("exception:"+ex);
          }
        
        }
  

        
        
    }
    
    
}

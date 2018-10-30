package com.database;

import java.sql.*;  
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect 
{
    
    public Connection makeConnection()
    {
       Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
         
            //enter ur database details with database anme username and passwprd
            con=DriverManager.getConnection("jdbc:mysql://anvidb.c9pnqonon6wn.us-east-1.rds.amazonaws.com:3306/anvidb","anvidb","123456789");
            
            if(con!=null)
                System.out.println("success db connect");
            else
                System.out.println("failed dbconnection");          
            
         
        }
        catch(ClassNotFoundException | SQLException e  )
        {
            System.out.println("Problem"+e);
        }
     return con;   
    }
    
    //to close db connect
    public void closeConnection(Connection con)
    {
        if(con!=null)
        try 
            {
                con.close();
        } catch (SQLException ex) 
        {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
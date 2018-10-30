package com.serverside;

import com.database.FileInfoFromDB;
import com.pojo.DBPojo;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetInfoFromDaB extends HttpServlet {

    private ArrayList<DBPojo> ObjectOfDatabaseFile;
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String uname;
        uname = request.getSession(false).getAttribute("uname").toString();
        FileInfoFromDB show=new FileInfoFromDB();
        ObjectOfDatabaseFile=show.fetchData(username);
        request.setAttribute("DBval",ObjectOfDatabaseFile);
      
    }


}


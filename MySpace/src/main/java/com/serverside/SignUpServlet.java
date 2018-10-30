package com.serverside;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.SignUpDB;




public class SignUpServlet extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    { 
    	String fname;
    	String lname;
    	String uname;
        String pwd;
        boolean flagForRegistration=false;
        String loginPage="Login.jsp";
        
        HttpSession ss=request.getSession(true);
        
        firstname= request.getParameter("fname").toString();
        lastname= request.getParameter("lname").toString();
        username= request.getParameter("uname").toString();
        password=request.getParameter("pwd").toString();
        
        SignUpDB databaseObject=new SignUpDB();
        databaseObject.register(fname, lname, uname, pwd);
   
        
        if(flagForRegistration)
            ss.setAttribute("regFlag","welldone go to loginpage");
           else
           ss.setAttribute("regFlag","failed retry diff attributes");
           
           RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
           dispatcher.forward(request, response);
       
         
    }

}

package com.serverside;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.LoginDB;

public class LoginServlet extends HttpServlet 
{
  	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)        
    {
      
        String username=null;
        String password=null;
        boolean flagForLogin=false;
        String mainMenuPage="Menu.jsp";
        String loginPage="Login.jsp";
        String message="Error name&pwd";
       
       username= request.getParameter("uname").toString();
       password=request.getParameter("pwd").toString();
         
        System.out.println("uname"+username,"pwd"+password);
      
        
        LoginDB loginObject=new LoginDB();
        flagForLogin = loginObject.login(uname, pwd);
        
  
        if(flagForLogin)
        {
            System.out.println("completelogin");
            HttpSession session = request.getSession(true);
          session.setAttribute("uname", uname);
          try 
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Menu.jsp");
           dispatcher.forward(request, response);
        } 
        catch (ServletException | IOException ex) 
        {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else
        {
            System.out.println("deniedloginin line63LoginServlet");
         
          RequestDispatcher dispatcher2 = request.getRequestDispatcher("Login.jsp");
          request.setAttribute("Wrong details",message);
          
        
        }

package com.serverside;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.database.FileDeleteFromDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getSession(false).getAttribute("username").toString();
        System.out.println("del" + username);
        String bucketname = "info-user";
        String filename = request.getParameter("myObject");
        System.out.println("dskey" + filename);
        String key;
        String SUFFIX = "/";
        key = username + SUFFIX + filename;
        System.out.println("key=" + key);
        
        FileDeleteFromDB file = new FileDeleteFromDB();
      file.del(filename);
        

        try {
        	 AWSCredentials credentials = new BasicAWSCredentials(
                     Access_key,
                     Secret_key);


            AmazonS3 s3client = new "pasword";
            System.out.println("ds" + s3client.getS3AccountOwner().getDisplayName());
            s3client.setRegion(Region.getRegion(Regions.US_EAST_1));
            s3client.setEndpoint("s3.us-east-1.amazonaws.com");
            s3client.deleteObject(bucketname, key);
        } catch (AmazonClientException ace) {
            
            System.out.println("Err " + ace.getMessage());
        }
        
        RequestDispatcher dispatcher2 = request.getRequestDispatcher("Menu.jsp");
         dispatcher2.forward(request, response);

    }

}

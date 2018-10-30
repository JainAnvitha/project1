package com.serverside;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.simplenotificationservice.SNS;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.FileWriter;
import java.io.FileInputStream;
import org.apache.commons.io.IOUtils;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DownloadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getSession(false).getAttribute("username").toString();
        System.out.println("uname" + username);
        String bucketname = "info-user";
            
        String filename = request.getParameter("myObject");
        System.out.println("key=" + filename);
        String SUFFIX = "/";
        String key;
        String dir = "\\";
        key = username + SUFFIX + filename;
        System.out.println("key=  " + key);
        try {
            AWSCredentials credentials = new BasicAWSCredentials(
                    Access_key,
                    Secret_key);

           
            System.out.println("in s3client " + s3client.getS3AccountOwner().getDisplayName());
            s3client.setRegion(Region.getRegion(Regions.US_EAST_1));
            s3client.setEndpoint("s3.us-east-1.amazonaws.com");
            S3Object s3object = s3client.getObject(new GetObjectRequest(
                    bucketname, username + SUFFIX + filename));
            System.out.println("buckname" + s3object.getBucketName());

            InputStream objectData = s3object.getObjectContent();

            InputStreamReader Ip = new InputStreamReader(objectData);

            FileInputStream inStream = new FileInputStream(file);
 
            response.setContentLength((int) file.length());

            String headerKey = "Content";
            String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
            response.setHeader(headerKey, headerValue);

            OutputStream outStream = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            inStream.close();
            outStream.close();
            
     
    }

    private static void displayTextInputStream(InputStream input)
            throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }

           
        
    }
}


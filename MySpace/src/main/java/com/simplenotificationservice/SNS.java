package com.simplenotificationservice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.DeleteTopicRequest;





public class SNS {
    public void setNotificationMethod() {
         try
         {
             System.out.println("in sns");
             AWSCredentials credentials = new BasicAWSCredentials(
                     Access_key,
                     Secret_key);

            //awsssn credentials
            
            AmazonSNSClient snsClient = new AmazonSNSClient(credentials);		                           
            snsClient.setRegion(Region.getRegion(Regions.US_EAST_1));
           
 
String topicArn = "arn:aws:sns:us-west-1:227047525444:SNSImplementation";
String msgToSubscribers = "file has been downloaded from bucket";
PublishRequest publishRequest = new PublishRequest(topicArn, msgToSubscribers);
PublishResult publishResult = snsClient.publish(publishRequest);
System.out.println("User's Id" + publishResult.getMessageId());    
    }
    catch(Exception e)
    {
     e.printStackTrace();
    }
    }
    }

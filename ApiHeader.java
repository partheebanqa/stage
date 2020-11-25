package com.awign.utilities;
import io.restassured.builder.RequestSpecBuilder;
import org.json.JSONArray;

import com.awign.dataprovider.BaseController;
import com.awign.dataprovider.TestDataFactory;

import java.util.LinkedList;

public class ApiHeader extends BaseController{


    public void setHeaders( JSONArray apiHeaders, RequestSpecBuilder builder) {
        LinkedList<String> headers = new LinkedList<String>();
        for (int i=0;i<apiHeaders.length();i++) {
            headers.add(apiHeaders.get(i).toString());
        }
        for (String header : headers) {
            switch (header) {
                case "Content-Type":
                  builder.addHeader("Content-Type","application/json");
                    break;
                case "authority":
                		builder.addHeader("authority","auth-api.awign.com");
                		break;
                case "orgin":
                		builder.addHeader("orgin","https://clients.awigntest.com");
                		break;
                case "accept-language":
                	    builder.addHeader("accept-language","en-GB,en-US;q=0.9,en;q=0.8");
                	    break;
                case "Connection":
            	    	builder.addHeader("Connection", "keep-alive");
            	    	break;
                case "Server":
            	    	builder.addHeader("Server", "nginx/1.10.3 (Ubuntu)");
            	    	break;

                case "X-Frame-Options":
                		builder.addHeader("X-Frame-Options", "DENY");
                		break;

                case "X-Content-Type-Options":
            	    	builder.addHeader("X-Content-Type-Options", "nosniff");
            	    	break;

                case "X-XSS-Protection":
            	    	builder.addHeader("X-XSS-Protection", "1; mode=block");
            	    	break;
                case "Content-Security-Policy":
            	    	builder.addHeader("Content-Security-Policy", "form-action 'self'; frame-ancestors 'self'; base-uri 'self'; default-src 'none'; script-src 'self'; connect-src 'self'; img-src 'self' https: data:; style-src 'self' 'unsafe-inline' https:; font-src 'self'; object-src 'none'; plugin-types application/pdf; child-src 'self'; frame-src 'self'; media-src 'self'");
            	    	break;

                case "Vary":
            	    	builder.addHeader("Vary", "Origin");
            	    	break;
                case "access-token":
	    				builder.addHeader("access-token",testdata.getAccess_token());	
	    				break;
                case "client":
    					builder.addHeader("client",testdata.getClient());	
    					break;     
                case "uid":
    					builder.addHeader("uid",testdata.getUid());	
    					break;                	 


            }
        }
    }
    
    
    
}

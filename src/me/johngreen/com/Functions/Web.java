package me.johngreen.com.Functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Web {

	public static void sendWebsiteData(String website, String data){
		
	    URL url;
	    InputStream is = null;

	    try {
	        url = new URL(website+data);
	        is = url.openStream();  // throws an IOException
	    } catch (MalformedURLException mue) {
	         mue.printStackTrace();
	    } catch (IOException ioe) {
	         ioe.printStackTrace();
	    } finally {
	        try {
	            if (is != null) is.close();
	        } catch (IOException ioe) {
	        }
	    }
	}
		
	
	
	public static String getWebsiteData(String website, String data){
		
	    URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;

	    try {
	        url = new URL(website+data);
	        is = url.openStream();  // throws an IOException
	        br = new BufferedReader(new InputStreamReader(is));
	        String str = "";
	        while ((line = br.readLine()) != null) {
	            str = str + line;
	        }
	        return str;
	    } catch (MalformedURLException mue) {
	         mue.printStackTrace();
	    } catch (IOException ioe) {
	         ioe.printStackTrace();
	    } finally {
	        try {
	            if (is != null) is.close();
	        } catch (IOException ioe) {
	        }
	    }
		return null;
	}
	
}

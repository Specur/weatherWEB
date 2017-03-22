package com.packt.webstore.service;

import java.net.*;
import java.io.*;
import java.util.*;

public class Download {
	private static URL url;
	private static String fname;
	
	public Download(URL url , String fname){
		this.url = url;
		this.fname = fname;
		
	}

 public void readAndSave() throws Exception {

   BufferedReader in = new BufferedReader(
                         new InputStreamReader(
                          url.openStream()   // zwraca InputStream zwi¹zany z URLem
                          )
                          );
   
   BufferedWriter out = new BufferedWriter(new FileWriter(fname));

   String s;
   while ((s = in.readLine()) != null) {
	   
         out.write(s);                  	
         out.newLine();
         }
   in.close();    					   		
   out.close();
   }

 
}

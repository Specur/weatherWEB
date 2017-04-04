package com.packt.webstore.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

import com.packt.webstore.domain.Smog;

public class ParsingSmog {
	
	private Smog pageResults = new Smog();
	
	public ParsingSmog(Smog smog){
		pageResults = smog;
	}
	
	
	public void getSmog(URL url){
		
		String word = null;
		String word2 = null;
		StringTokenizer stringTokenizer = null;
		String oneHtmlLine = null;
		BufferedReader allHtml = null;
		try {
			allHtml = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while ((oneHtmlLine = allHtml.readLine()) != null) {

				stringTokenizer = new StringTokenizer(oneHtmlLine, "=;<>\"&,()Â");

				while (stringTokenizer.hasMoreTokens()) {
					word2=word;
					word = stringTokenizer.nextToken();
					if (word.equals("µg/m3") && word2.length()<5) {
						pageResults.setAmountUGM3(Integer.parseInt(word2.trim()));
					}

				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

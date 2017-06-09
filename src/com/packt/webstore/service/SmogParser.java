package com.packt.webstore.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

import com.packt.webstore.domain.Smog;

public class SmogParser {

	private Smog pageResults = new Smog();

	public SmogParser(Smog smog) {
		pageResults = smog;
	}

	public void fetchDataFromPowietrzewkrakowie(URL url) {
		String word = null;
		BufferedReader contentAllWebside = null;
		contentAllWebside = downloadWebside(url, contentAllWebside);
		try {
			divisionWebsideOnSmallPartAndSaveCorrectData(word, contentAllWebside);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private BufferedReader downloadWebside(URL url, BufferedReader contentAllWebside) {
		try {
			contentAllWebside = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return contentAllWebside;
	}

	private void divisionWebsideOnSmallPartAndSaveCorrectData(String word, BufferedReader allHtml) throws IOException {
		
		StringTokenizer stringTokenizer;
		String oneHtmlLine;
		while ((oneHtmlLine = allHtml.readLine()) != null) {
			stringTokenizer = new StringTokenizer(oneHtmlLine, "=;<>\"&,()Â");
			word = characterSearch(word, stringTokenizer);
		}

	}

	private String characterSearch(String word, StringTokenizer stringTokenizer) {
		String word2;
		while (stringTokenizer.hasMoreTokens()) {
			word2 = word;
			word = stringTokenizer.nextToken();
			checkCorrectDataForPowietrzewkrakowie(word, word2);
		}
		return word;
	}

	private void checkCorrectDataForPowietrzewkrakowie(String word, String word2) {
		if (word.equals("µg/m3") && word2.length() < 5) {
			pageResults.setAmountUGM3(Integer.parseInt(word2.trim()));
		}else{
			pageResults.setAmountUGM3(0);
		}
	}

}

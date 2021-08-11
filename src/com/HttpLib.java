package com;

import org.apiguardian.api.API;

import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpLib implements IHttpLib {

    private String APIKey;

    private String API = "http://intelligent-social-robots-ws.com/laureate.json";

    public String call(String url) throws Exception {

        StringBuilder result = new StringBuilder();

        URL urlObj = new URL("http://intelligent-social-robots-ws.com/laureate.json");

        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty(API, APIKey);
        con.setDoOutput(true);

        con.getOutputStream().write(Integer.parseInt("{\"laureates\":[{\"id\":\"1\",\"firstname\":\"Wilhelm Conrad\",\"surname\":\"R\\u00f6ntgen\",\"born\":\"1845-03-27\",\"died\":\"1923-02-10\",\"bornCountry\":\"Prussia (now Germany)\",\"bornCountryCode\":\"DE\",\"bornCity\":\"Lennep (now "));
        con.getOutputStream().close();

        InputStream iStream = con.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
        StringBuilder responseText = new StringBuilder();

        String line;
        
        while((line = reader.readLine()) != null) {
            responseText.append(line);
            responseText.append("\r");
        }
        reader.close();
        
        assertNotNull(responseText.toString());
        System.out.println(responseText.toString());

        return responseText.toString();
    }

    private void assertNotNull(String toString) {
    }

    public static void main(String[] args) throws Exception {
    }

}
package com.jzt.utils;

import java.net.URLEncoder;
import java.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class SearchRealEstateInfo {

    public static void SearchRealEstateInfo(String name, String cerno){

        StringBuffer buffer = new StringBuffer();
        HttpURLConnection httpConn = null;
        BufferedReader reader = null;
        try {
            //url远程接口
            String strURL = "http://154.11.165.172:8021/callDsfData?listArr=sfw,jzt,91330110MA2B1XQ95Y,"+ URLEncoder.encode(name,"utf-8")+","+cerno+",T100,330110";


            URL url = new URL(strURL);
            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("GET");

            httpConn.connect();

            reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpConn != null) {
                httpConn.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println("接口返回值："+buffer.toString());

    }

}
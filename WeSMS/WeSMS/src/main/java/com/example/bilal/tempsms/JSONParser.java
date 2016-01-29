package com.example.bilal.tempsms;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by bilal on 1/5/16.
 */
public class JSONParser {

    static InputStream is = null;
    JSONArray jObj = null;
    static String json = "";

    // constructor
    public JSONParser() {

    }

    public JSONArray getJSONFromUrl(String url, List<NameValuePair> params) {

        // Making HTTP request
        try {
/*
			HttpParams httpParameters = new BasicHttpParams();
			 int timeoutConnection = 3000;
		        HttpConnectionParams.setConnectionTimeout(httpParameters,
		                timeoutConnection);
		        /*int timeoutSocket = 5000;
		        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
				*/
            //DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
            Log.e("JSONparser", url + " :" + json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        try {
            jObj = new JSONArray(json);
        } catch (JSONException e) {
            Log.e("JSON Parser Bilal", "Error parsing data " + e.toString());
        }

        // return JSON Array
        return jObj;

    }
}

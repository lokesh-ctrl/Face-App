package com.aconex.FaceRecognition.services;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class HttpEntityToJsonParserService {

    public static String getFaceId(HttpEntity httpEntity){

        try {

            String httpResponseBody = EntityUtils.toString(httpEntity);

            JSONArray jsonArray = new JSONArray(httpResponseBody);

            return jsonArray.getJSONObject(0).getString("faceId");
        }catch(Exception e){
            return null;
        }
    }

    public static String getPersonId(HttpEntity httpEntity){

        try {

            String httpResponseBody = EntityUtils.toString(httpEntity);

            JSONArray jsonArrayBody = new JSONArray(httpResponseBody);

            JSONObject jsonObject = jsonArrayBody.getJSONObject(0);

            JSONArray jsonArrayCandidates = jsonObject.getJSONArray("candidates");

            return jsonArrayCandidates.getJSONObject(0).getString("personId");

        }catch (Exception e){

            return null;

        }

    }
    public static String getRegisteredPersonId(HttpEntity httpEntity){

        try {
            String httpResponseBody = EntityUtils.toString(httpEntity);
            JSONObject jsonObject=new JSONObject(httpResponseBody);

            return jsonObject.getString("personId");


        }catch(Exception e){
            return null;
        }
    }
    public static String getRegPersonId(String httpResponseBody){

        try {
            //String httpResponseBody = EntityUtils.toString(httpEntity);
            JSONObject jsonObject=new JSONObject(httpResponseBody);

            return jsonObject.getString("personId");


        }catch(Exception e){
            return null;
        }
    }
}

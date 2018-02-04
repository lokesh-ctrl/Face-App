package com.aconex.FaceRecognition.services;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class HttpEntityToJsonParserService {

    public static String getFaceId(HttpEntity httpEntity)throws IOException{

        String httpResponseBody= EntityUtils.toString(httpEntity);

        JSONArray jsonArray=new JSONArray(httpResponseBody);

        return jsonArray.getJSONObject(0).getString("faceId");
    }

    public static String getPersonId(HttpEntity httpEntity)throws IOException{

        String httpResponseBody= EntityUtils.toString(httpEntity);

        JSONArray jsonArrayBody=new JSONArray(httpResponseBody);

        JSONObject jsonObject=jsonArrayBody.getJSONObject(0);

        JSONArray jsonArrayCndidates=jsonObject.getJSONArray("candidates");

        return jsonArrayCndidates.getJSONObject(0).getString("personId");

    }
}

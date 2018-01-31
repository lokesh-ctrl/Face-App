package com.aconex.FaceRecognition.services;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;


@Service
public class FaceDetector{

    public static final String subscriptionKey = "a57575674bb44929b470d4e60a4994f0";
    public static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect";

    private FaceIdentity faceIdentity;

    @Autowired
    FaceDetector(FaceIdentity faceIdentity){

        this.faceIdentity=faceIdentity;
    }


    public void detectFace(byte[] imageBytes){

        HttpClient httpclient = new DefaultHttpClient();

        try{

            URIBuilder builder = new URIBuilder(uriBase);
            builder.setParameter("returnFaceId", "true");
            builder.setParameter("returnFaceLandmarks", "false");
            builder.setParameter("returnFaceAttributes", "");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);


            request.setHeader("Content-Type", "application/octet-stream");
            request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);


            ByteArrayEntity reqEntity = new ByteArrayEntity(imageBytes, ContentType.APPLICATION_OCTET_STREAM);
            request.setEntity(reqEntity);


            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null){

                String faceID= EntityUtils.toString(entity).substring(12,48);
                faceIdentity.identifyFace(faceID);

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
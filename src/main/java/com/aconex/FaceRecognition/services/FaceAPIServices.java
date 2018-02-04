package com.aconex.FaceRecognition.services;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class FaceAPIServices {

    static HttpClient httpclient = new DefaultHttpClient();

    @Value("${subscriptionKey}")
    public String subscriptionKey;

    public HttpEntity faceDetectionRequestToFaceAPI(byte[] imageBytes){

        String faceDetectionURL="https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect";

        try {

            URIBuilder builder = new URIBuilder(faceDetectionURL);
            builder.setParameter("returnFaceId", "true");

            URI uri = builder.build();

            HttpPost request = new HttpPost(uri);

            request.setHeader("Content-Type", "application/octet-stream");
            request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

            ByteArrayEntity reqEntity = new ByteArrayEntity(imageBytes, ContentType.APPLICATION_OCTET_STREAM);
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity httpEntity = response.getEntity();

            return httpEntity;

        }catch (Exception e){}

        return null;

    }

    public  HttpEntity faceIdentifyRequestToFaceAPI(String faceId){

        String faceIdentifyURL="https://westcentralus.api.cognitive.microsoft.com/face/v1.0/identify";

        try{

            URIBuilder builder = new URIBuilder(faceIdentifyURL);

            URI uri = builder.build();

            HttpPost request = new HttpPost(uri);

            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

            String body = "{\"personGroupId\":\"interns-group-00\",\"faceIds\":[\""+faceId+"\"],\"maxNumOfCandidatesReturned\":1,\"confidenceThreshold\": \"0.2\"}";

            StringEntity reqEntity = new StringEntity(body);
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity httpEntity = response.getEntity();

            return httpEntity;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

}
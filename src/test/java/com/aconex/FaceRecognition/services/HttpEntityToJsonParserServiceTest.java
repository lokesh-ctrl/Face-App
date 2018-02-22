package com.aconex.FaceRecognition.services;

import org.junit.Test;

import static org.junit.Assert.*;

public class HttpEntityToJsonParserServiceTest {

    HttpEntityToJsonParserService httpEntityToJsonParserService=new HttpEntityToJsonParserService();

    @Test
    public void CheckRegPersonId() {

        assertEquals("3e14799a-18d4-428e-8fdf-9f022eb6d7f0",httpEntityToJsonParserService.getRegPersonId("{\"personId\":\"3e14799a-18d4-428e-8fdf-9f022eb6d7f0\"}"));


    }
}
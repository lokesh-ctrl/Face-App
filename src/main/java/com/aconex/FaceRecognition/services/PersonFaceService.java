package com.aconex.FaceRecognition.services;

import com.aconex.FaceRecognition.representation.FindFaceStatusDto;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;


@Service
public class PersonFaceService {

    @Value("${cascadefilePath}")
    public String CascadeFile;

    @Value("${sourceImagePath}")
    public  String SourceImage;

    @Value("${javaNativeLibraryPath}")
    public String NativeLibrary;

    public FindFaceStatusDto FindFace(byte[] imageBytes)throws IOException{

        System.load(NativeLibrary);

        CascadeClassifier faceDetector = new CascadeClassifier();
        faceDetector.load(CascadeFile);

        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
        BufferedImage bufferedImage = ImageIO.read(bis);
        bis.close();

        File outputfile = new File(SourceImage);
        ImageIO.write(bufferedImage, "png", outputfile);


        Mat image = Imgcodecs.imread(SourceImage);

        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        Rect[] rects=faceDetections.toArray();
        if(rects.length==0){
            return new FindFaceStatusDto("Failure");
        }
        return new FindFaceStatusDto("success");

    }
}
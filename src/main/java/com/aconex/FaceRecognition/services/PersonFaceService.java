package com.aconex.FaceRecognition.services;

import com.aconex.FaceRecognition.representation.FindFaceStatusDto;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class PersonFaceService {

   /* static {
       // System.loadLibrary("opencv_java320");
    }
*/
    public static FindFaceStatusDto FindFace(byte[] imageBytes)throws IOException{


        System.out.println("\n\n\n\n\n"+System.getProperty("java.library.path")+"\n\n\n\n");

        //System.load("/home/manoj/Documents/Projects/Face-App/libs/libopencv_java320.so");




        CascadeClassifier faceDetector = new CascadeClassifier();
        faceDetector.load("/home/manoj/Documents/Projects/Face-App/src/main/resources/haarcascade_frontalface_alt.xml");

        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
        BufferedImage bufferedImage = ImageIO.read(bis);
        bis.close();

        File outputfile = new File("/home/manoj/face.png");
        ImageIO.write(bufferedImage, "png", outputfile);


        Mat image = Imgcodecs.imread("/home/manoj/face.png");

        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        Rect[] rects=faceDetections.toArray();
        if(rects.length==0){
            return new FindFaceStatusDto("Failure");
        }
        return new FindFaceStatusDto("success");

    }
}
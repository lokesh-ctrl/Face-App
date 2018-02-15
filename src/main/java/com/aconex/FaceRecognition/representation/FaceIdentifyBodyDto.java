package com.aconex.FaceRecognition.representation;

public class FaceIdentifyBodyDto {

    private String personGroupId;

    private String[] faceIds;

    private String maxNumOfCandidatesReturned;

    private String confidenceThreshold;

    public FaceIdentifyBodyDto(){

    }

    public FaceIdentifyBodyDto(String personGroupId, String[] faceIds,String maxNumOfCandidatesReturned,String confidenceThreshold){

        this.personGroupId=personGroupId;
        this.faceIds=faceIds;
        this.maxNumOfCandidatesReturned=maxNumOfCandidatesReturned;
        this.confidenceThreshold=confidenceThreshold;


    }
    public void setPersonGroupId(String personGroupId){
        this.personGroupId=personGroupId;
    }

    public void setFaceIds(String[] faceIds) {
        this.faceIds = faceIds;
    }

    public void setMaxNumOfCandidatesReturned(String maxNumOfCandidatesReturned) {
        this.maxNumOfCandidatesReturned = maxNumOfCandidatesReturned;
    }

    public void setConfidenceThreshold(String confidenceThreshold) {
        this.confidenceThreshold = confidenceThreshold;
    }

    public String getPersonGroupId() {
        return personGroupId;
    }

    public String[] getFaceIds() {
        return faceIds;
    }

    public String getMaxNumOfCandidatesReturned() {
        return maxNumOfCandidatesReturned;
    }

    public String getConfidenceThreshold() {
        return confidenceThreshold;
    }
}
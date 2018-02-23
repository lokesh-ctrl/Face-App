package com.aconex.FaceRecognition.model;

public class EmployeeDetails {

    private String eid;

    private String ename;

    private String edesignation;

    EmployeeDetails(){

    }

    EmployeeDetails(String eid,String ename,String edesignation){

        this.eid=eid;

        this.ename=ename;

        this.edesignation=edesignation;
    }


    public String getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public String getEdesignation() {
        return edesignation;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setEdesignation(String edesignation) {
        this.edesignation = edesignation;
    }
}
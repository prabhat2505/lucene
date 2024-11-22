package com.example.spring_kubernetes;

public class InsightValueResponse {

    private String outageId;
    private String milestoneName;
    private String outageStartDatetime;
    private String outageUpdatedDatetime;
    private int resolutionTime;
    private String isFwa;
    private String isMobility;
    private boolean multiCityImpact;
    private String city;
    private String state;
    private String eventType;
    private String eventTs;

    // Getters and Setters
    public String getOutageId() {
        return outageId;
    }

    public void setOutageId(String outageId) {
        this.outageId = outageId;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public String getOutageStartDatetime() {
        return outageStartDatetime;
    }

    public void setOutageStartDatetime(String outageStartDatetime) {
        this.outageStartDatetime = outageStartDatetime;
    }

    public String getOutageUpdatedDatetime() {
        return outageUpdatedDatetime;
    }

    public void setOutageUpdatedDatetime(String outageUpdatedDatetime) {
        this.outageUpdatedDatetime = outageUpdatedDatetime;
    }



    public String getIsFwa() {
        return isFwa;
    }

    public void setIsFwa(String isFwa) {
        this.isFwa = isFwa;
    }

    public String getIsMobility() {
        return isMobility;
    }

    public void setIsMobility(String isMobility) {
        this.isMobility = isMobility;
    }

    public boolean isMultiCityImpact() {
        return multiCityImpact;
    }

    public void setMultiCityImpact(boolean multiCityImpact) {
        this.multiCityImpact = multiCityImpact;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTs() {
        return eventTs;
    }

    public void setEventTs(String eventTs) {
        this.eventTs = eventTs;
    }

    public int getResolutionTime() {
        return resolutionTime;
    }

    public void setResolutionTime(int resolutionTime) {
        this.resolutionTime = resolutionTime;
    }

    @Override
    public String toString() {
        return "InsightValueResponse{" +
                "outageId='" + outageId + '\'' +
                ", milestoneName='" + milestoneName + '\'' +
                ", outageStartDatetime='" + outageStartDatetime + '\'' +
                ", outageUpdatedDatetime='" + outageUpdatedDatetime + '\'' +
                ", resolutionTime='" + resolutionTime + '\'' +
                ", isFwa='" + isFwa + '\'' +
                ", isMobility='" + isMobility + '\'' +
                ", multiCityImpact=" + multiCityImpact +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventTs='" + eventTs + '\'' +
                '}';
    }
}

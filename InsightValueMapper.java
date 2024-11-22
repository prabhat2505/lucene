package com.example.spring_kubernetes;

public class InsightValueMapper {

    public static InsightValueResponse mapToResponse(InsightValue insightValue) {
        InsightValueResponse response = new InsightValueResponse();
        response.setOutageId(insightValue.getOutageId());
        response.setMilestoneName(insightValue.getMilestoneName());
        response.setOutageStartDatetime(insightValue.getOutageStartDatetime());
        response.setOutageUpdatedDatetime(insightValue.getOutageUpdatedDatetime());
        response.setResolutionTime(insightValue.getResolutionTime());
        response.setIsFwa(insightValue.getIsFwa());
        response.setIsMobility(insightValue.getIsMobility());
        response.setMultiCityImpact(insightValue.isMultiCityImpact());
        response.setCity(insightValue.getCity());
        response.setState(insightValue.getState());
        response.setEventType(insightValue.getEventType());
        response.setEventTs(insightValue.getEventTs());
        return response;
    }
}

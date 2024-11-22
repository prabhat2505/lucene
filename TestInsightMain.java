package com.example.spring_kubernetes;

import java.util.ArrayList;
import java.util.List;

public class TestInsightMain {
    public static void main(String[] args){
        List<InsightValue> records = new ArrayList<>();
        // Sample Data
        InsightValue insightValue1 = new InsightValue();
        insightValue1.setIsFwa("Y");
        insightValue1.setIsNenSubscribed("N");
        insightValue1.setMilestoneName("Outage Resolved");
        insightValue1.setResolutionTime(3);
        records.add(insightValue1);


        InsightValue insightValue2 = new InsightValue();
        insightValue2.setIsFwa("Y");
        insightValue2.setIsNenSubscribed("Y");
        insightValue2.setMilestoneName("Outage Resolved");
        insightValue2.setResolutionTime(3);
        records.add(insightValue2);

        InsightValue insightValue3 = new InsightValue();
        insightValue3.setIsFwa("Y");
        insightValue3.setIsNenSubscribed("N");
        insightValue3.setMilestoneName("Outage Detected");
        insightValue3.setResolutionTime(3);

        records.add(insightValue3);


        InsightValue insightValue4 = new InsightValue();
        insightValue4.setIsFwa("Y");
        insightValue4.setIsNenSubscribed("N");
        insightValue4.setMilestoneName("Outage Detected");
        insightValue4.setResolutionTime(7);
        records.add(insightValue4);

        InsightValue insightValue5 = new InsightValue();
        insightValue5.setIsFwa("Y");
        insightValue5.setIsNenSubscribed("Y");
        insightValue5.setMilestoneName("Outage Resolved");
        insightValue5.setResolutionTime(5);
        records.add(insightValue5);

        System.out.println(records.toString());

        // Perform search with a time limit of 2 hours
        List<InsightValueResponse> result = searchInsights(records);


        // Print the filtered records
        for (InsightValueResponse insight : result) {
            System.out.println(insight);
        }
    }

    // Search method implementing the logic
    public static List<InsightValueResponse> searchInsights(List<InsightValue> records) {
        List<InsightValueResponse> result = new ArrayList<>();


        for (InsightValue record : records) {
            InsightValueResponse response = null;

            if ("Y".equalsIgnoreCase(record.getIsFwa()) && "N".equalsIgnoreCase(record.getIsNenSubscribed())) {
                // If milestone name is not "Outage Resolved", include in result
                if (!"Outage Resolved".equalsIgnoreCase(record.getMilestoneName())) {
                        // removeing  is_nen_subscribed form paylaod
                        response = InsightValueMapper.mapToResponse(record);
                        result.add(response);
                } else {
                    // If milestone is "Outage Resolved", check if resolution time is within the limit
                    if (isResolutionWithinLimit(record.getResolutionTime())) {
                        // remove is_nen_subscribed
                        response = InsightValueMapper.mapToResponse(record);
                        result.add(response);
                    }
                }
            }
        }

        return result;
    }

    // Helper method to check if the resolution time is within the specified limit
    private static boolean isResolutionWithinLimit(int limit) {
        return limit < 4;
    }
}

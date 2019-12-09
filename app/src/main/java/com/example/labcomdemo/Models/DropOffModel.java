package com.example.labcomdemo.Models;

public class DropOffModel {

    String requestId,engineerName,NumberOfTerminals,deliveryTime;

    public DropOffModel(String requestId, String engineerName, String numberOfTerminals, String deliveryTime) {
        this.requestId = requestId;
        this.engineerName = engineerName;
        NumberOfTerminals = numberOfTerminals;
        this.deliveryTime = deliveryTime;
    }


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public String getNumberOfTerminals() {
        return NumberOfTerminals;
    }

    public void setNumberOfTerminals(String numberOfTerminals) {
        NumberOfTerminals = numberOfTerminals;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}

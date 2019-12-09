package com.example.labcomdemo.Models;

public class progressModel {

    String clientName,progress;

    public progressModel(String clientName, String progress) {
        this.clientName = clientName;
        this.progress = progress;
    }


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}

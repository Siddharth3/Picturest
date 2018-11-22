package com.picturest11.picturest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Siddharth on 21/11/18.
 */
public class DefaultResponse {

    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private String status;

    public DefaultResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

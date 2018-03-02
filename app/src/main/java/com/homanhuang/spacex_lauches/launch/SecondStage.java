package com.homanhuang.spacex_lauches.launch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Homan on 3/1/2018.
 */

public class SecondStage {
    @SerializedName("payloads")
    List<Payloads> payloadsList;

    public List<Payloads> getPayloadsList() {
        return payloadsList;
    }

    public void setPayloadsList(List<Payloads> payloadsList) {
        this.payloadsList = payloadsList;
    }
}

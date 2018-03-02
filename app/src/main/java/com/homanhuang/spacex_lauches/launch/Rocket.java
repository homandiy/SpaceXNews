package com.homanhuang.spacex_lauches.launch;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Homan on 2/28/2018.
 */

public class Rocket {
    @SerializedName("rocket_id")
    private String rocket_id;
    @SerializedName("rocket_name")
    private String rocket_name;
    @SerializedName("rocket_type")
    private String rocket_type;
    @SerializedName("first_stage")
    private FirstStage first_stage;
    @SerializedName("second_stage")
    private SecondStage second_stage;

    public SecondStage getSecond_stage() {
        return second_stage;
    }

    public void setSecond_stage(SecondStage second_stage) {
        this.second_stage = second_stage;
    }

    public FirstStage getFirst_stage() {
        return first_stage;
    }

    public void setFirst_stage(FirstStage first_stage) {
        this.first_stage = first_stage;
    }

    public String getRocket_id() {
        return rocket_id;
    }

    public void setRocket_id(String rocket_id) {
        this.rocket_id = rocket_id;
    }

    public String getRocket_name() {
        return rocket_name;
    }

    public void setRocket_name(String rocket_name) {
        this.rocket_name = rocket_name;
    }

    public String getRocket_type() {
        return rocket_type;
    }

    public void setRocket_type(String rocket_type) {
        this.rocket_type = rocket_type;
    }
}

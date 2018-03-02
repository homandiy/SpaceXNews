package com.homanhuang.spacex_lauches.launch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Homan on 3/1/2018.
 */

public class FirstStage {
    @SerializedName("cores")
    private List<Cores> coresList;

    public List<Cores> getCoresList() {
        return coresList;
    }

    public void setCoresList(List<Cores> coresList) {
        this.coresList = coresList;
    }
}

package com.homanhuang.spacex_lauches.launch;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Homan on 2/28/2018.
 */

public class Reuse {

    @SerializedName("core")
    private Boolean core;
    @SerializedName("side_core1")
    private Boolean side_core1;
    @SerializedName("side_core2")
    private Boolean side_core2;
    @SerializedName("fairings")
    private Boolean fairings;
    @SerializedName("capsule")
    private Boolean capsule;

    public Boolean isCore() {
        return core;
    }

    public void setCore(Boolean core) {
        this.core = core;
    }

    public Boolean isSide_core1() {
        return side_core1;
    }

    public void setSide_core1(Boolean side_core1) {
        this.side_core1 = side_core1;
    }

    public Boolean isSide_core2() {
        return side_core2;
    }

    public void setSide_core2(Boolean side_core2) {
        this.side_core2 = side_core2;
    }

    public Boolean isFairings() {
        return fairings;
    }

    public void setFairings(Boolean fairings) {
        this.fairings = fairings;
    }

    public Boolean isCapsule() {
        return capsule;
    }

    public void setCapsule(Boolean capsule) {
        this.capsule = capsule;
    }

    @Override
    public String toString() {
        return "Reuse{" +
                "\ncore=" + core +
                ", \nside_core1=" + side_core1 +
                ", \nside_core2=" + side_core2 +
                ", \nfairings=" + fairings +
                ", \ncapsule=" + capsule +
                '}';
    }
}

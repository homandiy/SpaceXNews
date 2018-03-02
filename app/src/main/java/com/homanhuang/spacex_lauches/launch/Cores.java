package com.homanhuang.spacex_lauches.launch;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Homan on 2/28/2018.
 */

public class Cores {

    @SerializedName("core_serial")
    private String core_serial;
    @SerializedName("flight")
    private Integer flight;
    @SerializedName("block")
    private Integer block;
    @SerializedName("reused")
    private Boolean reused;
    @SerializedName("land_success")
    private Boolean land_success;
    @SerializedName("landing_type")
    private String landing_type;
    @SerializedName("landing_vehicle")
    private String landing_vehicle;

    public Cores() {
    }

    public String getCore_serial() {
        return core_serial;
    }

    public void setCore_serial(String core_serial) {
        this.core_serial = core_serial;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public Boolean getLand_success() {
        return land_success;
    }

    public void setLand_success(Boolean land_success) {
        this.land_success = land_success;
    }

    public String getLanding_type() {
        return landing_type;
    }

    public void setLanding_type(String landing_type) {
        this.landing_type = landing_type;
    }

    public String getLanding_vehicle() {
        return landing_vehicle;
    }

    public void setLanding_vehicle(String landing_vehicle) {
        this.landing_vehicle = landing_vehicle;
    }

    @Override
    public String toString() {
        return "Cores {" +
                "\ncore_serial='" + core_serial + '\'' +
                ", \nflight=" + flight +
                ", \nblock=" + block +
                ", \nreused=" + reused +
                ", \nland_success=" + land_success +
                ", \nlanding_type='" + landing_type +  '\'' +
                ", \nlanding_vehicle='" + landing_vehicle + '\'' +
                '}';
    }
}

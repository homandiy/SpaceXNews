package com.homanhuang.spacex_lauches.launch;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Homan on 2/28/2018.
 */

public class LaunchSite {

    @SerializedName("site_id")
    private String site_id;
    @SerializedName("site_name")
    private String site_name;
    @SerializedName("site_name_long")
    private String site_name_long;

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getSite_name_long() {
        return site_name_long;
    }

    public void setSite_name_long(String site_name_long) {
        this.site_name_long = site_name_long;
    }

    @Override
    public String toString() {
        return "LaunchSite{" +
                "\nsite_id='" + site_id + '\'' +
                ", \nsite_name='" + site_name + '\'' +
                ", \nsite_name_long='" + site_name_long + '\'' +
                '}';
    }
}

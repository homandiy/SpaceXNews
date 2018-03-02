package com.homanhuang.spacex_lauches.launch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Homan on 2/28/2018.
 */

public class Launch {

    @SerializedName("flight_number")
    private int flight_number;
    @SerializedName("launch_year")
    private String launch_year;
    @SerializedName("launch_date_unix")
    private Long launch_date_unix;
    @SerializedName("launch_date_utc")
    private String launch_date_utc;
    @SerializedName("launch_date_local")
    private String launch_date_local;
    @SerializedName("rocket")
    Rocket rocket;
    @SerializedName("telemetry")
    Telemetry telemetry;
    @SerializedName("reuse")
    Reuse reuse;
    @SerializedName("launch_site")
    LaunchSite launchSite;
    @SerializedName("launch_success")
    Boolean launch_success;
    @SerializedName("links")
    Links links;

    public Boolean getLaunch_success() {
        return launch_success;
    }

    public void setLaunch_success(Boolean launch_success) {
        this.launch_success = launch_success;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public Reuse getReuse() {
        return reuse;
    }

    public void setReuse(Reuse reuse) {
        this.reuse = reuse;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public String getLaunch_year() {
        return launch_year;
    }

    public void setLaunch_year(String launch_year) {
        this.launch_year = launch_year;
    }

    public Long getLaunch_date_unix() {
        return launch_date_unix;
    }

    public void setLaunch_date_unix(Long launch_date_unix) {
        this.launch_date_unix = launch_date_unix;
    }

    public String getLaunch_date_utc() {
        return launch_date_utc;
    }

    public void setLaunch_date_utc(String launch_date_utc) {
        this.launch_date_utc = launch_date_utc;
    }

    public String getLaunch_date_local() {
        return launch_date_local;
    }

    public void setLaunch_date_local(String launch_date_local) {
        this.launch_date_local = launch_date_local;
    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }


}
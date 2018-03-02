package com.homanhuang.spacex_lauches.launch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Homan on 2/28/2018.
 */

public class Payloads {
    @SerializedName("payload_id")
    private String payload_id;
    @SerializedName("reused")
    private Boolean reused;
    @SerializedName("customers")
    private List<String> customers;
    @SerializedName("payload_type")
    private String payload_type;
    @SerializedName("payload_mass_kg")
    private Integer payload_mass_kg;
    @SerializedName("payload_mass_lbs")
    private Double payload_mass_lbs;
    @SerializedName("orbit")
    String orbit;

    public String getPayload_id() {
        return payload_id;
    }

    public void setPayload_id(String payload_id) {
        this.payload_id = payload_id;
    }

    public boolean isReused() {
        return reused;
    }

    public void setReused(boolean reused) {
        this.reused = reused;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public String getCustomersToString() {
        String x = "";
        int size = customers.size();
        for (int i = 0; i< size; i++) {
            x += customers.get(i);
            if (i++ != size) {
                x += ", ";
            }
        }
        return x;
    }

    public String getPayload_type() {
        return payload_type;
    }

    public void setPayload_type(String payload_type) {
        this.payload_type = payload_type;
    }

    public int getPayload_mass_kg() {
        return payload_mass_kg;
    }

    public void setPayload_mass_kg(int payload_mass_kg) {
        this.payload_mass_kg = payload_mass_kg;
    }

    public double getPayload_mass_lbs() {
        return payload_mass_lbs;
    }

    public void setPayload_mass_lbs(double payload_mass_lbs) {
        this.payload_mass_lbs = payload_mass_lbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    @Override
    public String toString() {
        return "Payloads {" +
                "\npayload_id='" + payload_id + '\'' +
                ", \nreused=" + reused +
                ", \ncustomers=" + customers +
                ", \npayload_type='" + payload_type + '\'' +
                ", \npayload_mass_kg=" + payload_mass_kg +
                ", \npayload_mass_lbs=" + payload_mass_lbs +
                ", \norbit='" + orbit + '\'' +
                '}';
    }
}

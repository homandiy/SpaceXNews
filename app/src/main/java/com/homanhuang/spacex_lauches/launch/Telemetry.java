package com.homanhuang.spacex_lauches.launch;

import java.net.URL;

/**
 * Created by Homan on 2/28/2018.
 */

public class Telemetry {
    private URL flight_club;

    public URL getFlight_club() {
        return flight_club;
    }

    public void setFlight_club(URL flight_club) {
        this.flight_club = flight_club;
    }

    @Override
    public String toString() {
        return "Telemetry {" +
                "\nflight_club = " + flight_club +
                " }";
    }
}

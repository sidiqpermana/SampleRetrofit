package com.sidiq.intel.sampleretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchItems {

    @SerializedName("kick_off")
    @Expose
    public String kickOff;

    @SerializedName("event")
    @Expose
    public String event;

    @SerializedName("team_home")
    @Expose
    public String teamHome;

    @SerializedName("team_away")
    @Expose
    public String teamAway;

    @SerializedName("tv")
    @Expose
    public String tv;

}

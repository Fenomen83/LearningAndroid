package com.definex.learningandroid.models;

import com.google.gson.annotations.SerializedName;

public class Stat {
    @SerializedName("base_stat")
    private Integer baseStat;

    @SerializedName("effort")
    private Integer effort;

    @SerializedName("stat")
    private Species stat;

    public Integer getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(Integer baseStat) {
        this.baseStat = baseStat;
    }

    public Integer getEffort() {
        return effort;
    }

    public void setEffort(Integer effort) {
        this.effort = effort;
    }

    public Species getStat() {
        return stat;
    }

    public void setStat(Species stat) {
        this.stat = stat;
    }
}

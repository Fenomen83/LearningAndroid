package com.definex.learningandroid.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Move {
    @SerializedName("move")
    private Species move;

    @SerializedName("version_group_details")
    private List<VersionGroupDetail> versionGroupDetails;

    public Species getMove() {
        return move;
    }

    public void setMove(Species move) {
        this.move = move;
    }

    public List<VersionGroupDetail> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    public void setVersionGroupDetails(List<VersionGroupDetail> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }
}

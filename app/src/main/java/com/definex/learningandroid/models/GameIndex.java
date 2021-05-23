package com.definex.learningandroid.models;

import com.google.gson.annotations.SerializedName;

public class GameIndex {
    @SerializedName("game_index")
    private Integer gameIndex;

    @SerializedName("version")
    private Species version;

    public Integer getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(Integer gameIndex) {
        this.gameIndex = gameIndex;
    }

    public Species getVersion() {
        return version;
    }

    public void setVersion(Species version) {
        this.version = version;
    }
}

package com.definex.learningandroid.models;

import com.google.gson.annotations.SerializedName;

public class VersionGroupDetail {
    @SerializedName("level_learned_at")
    private Integer levelLearnedAt;

    @SerializedName("move_learn_method")
    private Species moveLearnMethod;

    @SerializedName("version_group")
    private Species versionGroup;

    public Integer getLevelLearnedAt() {
        return levelLearnedAt;
    }

    public void setLevelLearnedAt(Integer levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }

    public Species getMoveLearnMethod() {
        return moveLearnMethod;
    }

    public void setMoveLearnMethod(Species moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }

    public Species getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(Species versionGroup) {
        this.versionGroup = versionGroup;
    }
}

package com.definex.learningandroid.models;

import com.google.gson.annotations.SerializedName;

public class TypeElement {
    @SerializedName("slot")
    private Integer slot;

    @SerializedName("type")
    private Species type;

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Species getType() {
        return type;
    }

    public void setType(Species type) {
        this.type = type;
    }
}

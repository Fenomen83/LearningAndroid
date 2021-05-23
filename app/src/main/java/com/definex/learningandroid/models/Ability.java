package com.definex.learningandroid.models;

import com.google.gson.annotations.SerializedName;

public class Ability {

    @SerializedName("ability")
    private Species ability;

    @SerializedName("is_hidden")
    private Boolean isHidden;

    @SerializedName("slot")
    private Integer slot;

    public Species getAbility() {
        return ability;
    }

    public void setAbility(Species ability) {
        this.ability = ability;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }
}

package com.definex.learningandroid.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonListResponse {

    @SerializedName("count")
    private int count = 0;

    @SerializedName("next")
    private String next = "";

    @SerializedName("results")
    private List<PokemonListItem> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<PokemonListItem> getResults() {
        return results;
    }

    public void setResults(List<PokemonListItem> results) {
        this.results = results;
    }
}

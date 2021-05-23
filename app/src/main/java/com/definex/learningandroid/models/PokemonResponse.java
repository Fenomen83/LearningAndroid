package com.definex.learningandroid.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonResponse {
    @SerializedName("id")
    private Integer id;

    @SerializedName("abilities")
    private List<Ability> abilities;

    @SerializedName("base_experience")
    private Integer baseExperience;

    @SerializedName("forms")
    private List<Species> forms;

    @SerializedName("game_indices")
    private List<GameIndex> gameIndices;

    @SerializedName("height")
    private Integer height;

    @SerializedName("is_default")
    private Boolean isDefault;

    @SerializedName("location_area_encounters")
    private String locationAreaEncounters;

    @SerializedName("moves")
    private List<Move> moves;

    @SerializedName("name")
    private String name;

    @SerializedName("order")
    private Integer order;

    @SerializedName("species")
    private Species species;

    @SerializedName("sprites")
    private Sprites sprites;

    @SerializedName("stats")
    private List<Stat> stats;

    @SerializedName("types")
    private List<TypeElement> types;

    @SerializedName("weight")
    private Integer weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    public List<Species> getForms() {
        return forms;
    }

    public void setForms(List<Species> forms) {
        this.forms = forms;
    }

    public List<GameIndex> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<GameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public List<TypeElement> getTypes() {
        return types;
    }

    public void setTypes(List<TypeElement> types) {
        this.types = types;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}



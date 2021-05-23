package com.definex.learningandroid.services;

import com.definex.learningandroid.models.PokemonListResponse;
import com.definex.learningandroid.models.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface PokemonAPI {

    @GET("pokemon")
    Call<PokemonListResponse> getPokemonList(
    );

    @GET
    Call<PokemonResponse> getPokemonDetail(@Url String url);

}

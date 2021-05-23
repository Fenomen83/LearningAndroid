package com.definex.learningandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.definex.learningandroid.R;
import com.definex.learningandroid.adapters.PokemonRecyclerViewAdaptor;
import com.definex.learningandroid.models.PokemonListItem;
import com.definex.learningandroid.models.PokemonListResponse;
import com.definex.learningandroid.models.PokemonRecyclerViewAdaptorListener;
import com.definex.learningandroid.services.PokemonAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView pokeRecyclerView;

    private Retrofit retrofit;
    private PokemonAPI pokemonAPI;

    private List<PokemonListItem> pokemonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            pokemonList =  (List<PokemonListItem>) savedInstanceState.getSerializable("pokemonList");
        }

        setContentView(R.layout.activity_main);

        pokeRecyclerView = findViewById(R.id.pokeRecyclerView);
        pokeRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));

        Gson gson= new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        pokemonAPI  = retrofit.create(PokemonAPI.class);

        if (pokemonList.size()>0){
            MainActivity.this.setAdapterData();
        } else {
            getPokemonList();
        }
    }

    private void getPokemonList(){
        Call<PokemonListResponse> call = pokemonAPI.getPokemonList();
        call.enqueue(new Callback<PokemonListResponse>() {
            @Override
            public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                PokemonListResponse res = response.body();
                if (res != null){
                    pokemonList = res.getResults();
                    MainActivity.this.setAdapterData();
                }
            }

            @Override
            public void onFailure(Call<PokemonListResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("pokemonList", (Serializable) pokemonList);
        super.onSaveInstanceState(outState);
    }

    private void setAdapterData(){
        PokemonRecyclerViewAdaptor adaptor = new PokemonRecyclerViewAdaptor(pokemonList);
        adaptor.setPokemonRecyclerViewAdaptorListener(new PokemonRecyclerViewAdaptorListener() {
            @Override
            public void onItemClick(PokemonListItem pokemon) {

                MainActivity.this.startActivity(new Intent(MainActivity.this, DetailActivity.class)
                        .putExtra("pokemon", pokemon));
            }
        });
        pokeRecyclerView.setAdapter(adaptor);
    }
}
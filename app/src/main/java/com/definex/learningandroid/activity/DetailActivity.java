package com.definex.learningandroid.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.definex.learningandroid.R;
import com.definex.learningandroid.adapters.PokemonImagesAdapter;
import com.definex.learningandroid.adapters.PokemonRecyclerViewAdaptor;
import com.definex.learningandroid.adapters.PokemonStatsAdaptor;
import com.definex.learningandroid.models.PokemonListItem;
import com.definex.learningandroid.models.PokemonListResponse;
import com.definex.learningandroid.models.PokemonRecyclerViewAdaptorListener;
import com.definex.learningandroid.models.PokemonResponse;
import com.definex.learningandroid.models.Stat;
import com.definex.learningandroid.services.PokemonAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    private GridView pokemonImagesLayout;
    private ListView pokemonStatsLayout;

    private PokemonListItem pokemon;

    private Retrofit retrofit;
    private PokemonAPI pokemonAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        pokemonImagesLayout = findViewById(R.id.pokemonImagesLayout);
        pokemonStatsLayout = findViewById(R.id.pokemonStatsLayout);

        pokemon = (PokemonListItem)getIntent().getSerializableExtra("pokemon");
        setTitle(pokemon.getName());

        Gson gson= new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        pokemonAPI  = retrofit.create(PokemonAPI.class);

        getPokemonDetail();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        NavUtils.navigateUpFromSameTask(this);
    }

    private void getPokemonDetail(){
        Call<PokemonResponse> call = pokemonAPI.getPokemonDetail(pokemon.getUrl());
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                PokemonResponse res = response.body();
                if (res != null){
                    PokemonImagesAdapter pokemonImagesAdapter = new PokemonImagesAdapter(DetailActivity.this, DetailActivity.this.getPokemonImages(res));
                    pokemonImagesLayout.setAdapter(pokemonImagesAdapter);

                    PokemonStatsAdaptor pokemonStatsAdaptor = new PokemonStatsAdaptor(DetailActivity.this, res.getStats());
                    pokemonStatsLayout.setAdapter(pokemonStatsAdaptor);
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Toast.makeText(DetailActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });
    }

    private List<String> getPokemonImages(PokemonResponse pokemon){
        List<String> pokemonImageUrls = new ArrayList<>();

        if (pokemon.getSprites() != null){
            if (pokemon.getSprites().getFrontDefault() != null){
                pokemonImageUrls.add(pokemon.getSprites().getFrontDefault());
            }
            if (pokemon.getSprites().getFrontShiny() != null){
                pokemonImageUrls.add(pokemon.getSprites().getFrontShiny());
            }
            if (pokemon.getSprites().getBackDefault() != null){
                pokemonImageUrls.add(pokemon.getSprites().getBackDefault());
            }
            if (pokemon.getSprites().getBackShiny() != null){
                pokemonImageUrls.add(pokemon.getSprites().getBackShiny());
            }
        }

        return  pokemonImageUrls;
    }


}
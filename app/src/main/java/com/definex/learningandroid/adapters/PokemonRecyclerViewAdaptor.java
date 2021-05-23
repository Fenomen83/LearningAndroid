package com.definex.learningandroid.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.definex.learningandroid.R;
import com.definex.learningandroid.models.PokemonListItem;
import com.definex.learningandroid.models.PokemonRecyclerViewAdaptorListener;

import java.util.List;


public class PokemonRecyclerViewAdaptor extends RecyclerView.Adapter<PokemonRecyclerViewAdaptor.RowHolder> {

    private PokemonRecyclerViewAdaptorListener listener;
    private List<PokemonListItem> pokemonList;

    public PokemonRecyclerViewAdaptor(List<PokemonListItem> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void setPokemonRecyclerViewAdaptorListener(PokemonRecyclerViewAdaptorListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public PokemonRecyclerViewAdaptor.RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout_pokemon, parent, false);
        return new PokemonRecyclerViewAdaptor.RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonRecyclerViewAdaptor.RowHolder holder, int position) {
        holder.bind(pokemonList.get(position));

    }

    @Override
    public int getItemCount() {
        return this.pokemonList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView pokeNameTextView;


        public RowHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void bind(PokemonListItem pokemon){
            cardView = itemView.findViewById(R.id.cardView);
            pokeNameTextView = itemView.findViewById(R.id.textViewPokemonName);

            cardView.setOnClickListener(v -> {
                if (listener!=null){
                    listener.onItemClick(pokemon);
                }
            });
            pokeNameTextView.setText(pokemon.getName());
        }
    }
}

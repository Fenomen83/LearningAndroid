package com.definex.learningandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.definex.learningandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonImagesAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<String> imageUrls;

    public PokemonImagesAdapter(Context context, List<String> imageUrls) {
        this.mContext = context;
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.row_layout_pokemon_images, null);
        }

        final ImageView imageView = convertView.findViewById(R.id.pokemonImageView);
        Glide.with(convertView).load(imageUrls.get(position)).into(imageView);
        //Picasso.get().load(imageUrls.get(position)).into(imageView);
        
        return convertView;
    }

}

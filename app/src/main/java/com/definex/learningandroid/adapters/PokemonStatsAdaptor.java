package com.definex.learningandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.definex.learningandroid.R;
import com.definex.learningandroid.models.Stat;

import java.util.List;

public class PokemonStatsAdaptor extends BaseAdapter {

    private final Context mContext;
    private final List<Stat> stats;

    public PokemonStatsAdaptor(Context context, List<Stat> stats) {
        this.mContext = context;
        this.stats = stats;
    }

    @Override
    public int getCount() {
        return stats.size();
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

        Stat stat = stats.get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.row_layout_pokemon_stats, null);
        }

        final TextView textViewStats = convertView.findViewById(R.id.textViewStats);
        textViewStats.setText(stat.getStat().getName().toUpperCase() + " : "+stat.getBaseStat());

        return convertView;
    }

}

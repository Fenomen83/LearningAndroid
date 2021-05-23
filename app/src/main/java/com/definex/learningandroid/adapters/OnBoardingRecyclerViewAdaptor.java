package com.definex.learningandroid.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.definex.learningandroid.R;
import com.definex.learningandroid.models.SliderModel;

import java.util.List;

public class OnBoardingRecyclerViewAdaptor extends RecyclerView.Adapter<OnBoardingRecyclerViewAdaptor.RowHolder> {

   private List<SliderModel> sliderList;

    public OnBoardingRecyclerViewAdaptor(List<SliderModel> sliderList) {
        this.sliderList = sliderList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout_onboarding, parent, false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(sliderList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.sliderList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        LottieAnimationView lottieAnimationView;
        TextView titleTextView;
        TextView textViewDescription;


        public RowHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void bind(SliderModel sliderModel){
            lottieAnimationView = itemView.findViewById(R.id.onboarding_animation);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);

            lottieAnimationView.setAnimation(sliderModel.getImageName());
            lottieAnimationView.setRepeatCount(LottieDrawable.INFINITE);
            lottieAnimationView.playAnimation();

            titleTextView.setText(sliderModel.getTitle());

            textViewDescription.setText(sliderModel.getDescription());
        }
    }
}

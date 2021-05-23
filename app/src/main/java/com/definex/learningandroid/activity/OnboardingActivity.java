package com.definex.learningandroid.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.definex.learningandroid.R;
import com.definex.learningandroid.adapters.OnBoardingRecyclerViewAdaptor;
import com.definex.learningandroid.models.SliderModel;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity {

    List<SliderModel> sliderList = new ArrayList<>();
    RecyclerView recyclerView;
    LinearLayout mDots;

    int pos = 0;
    private LinearLayoutManager mLayoutManager;
    private ImageView[] ivDots;

    OnBoardingRecyclerViewAdaptor onBoardingRecyclerViewAdaptor;

    Button btnDevamEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        sliderList.add(new SliderModel(0,"OnBoardingView1.SliderTitle", "OnBoardingView1.SliderDescription", "welcome_slider.json"));
        sliderList.add(new SliderModel(1,"OnBoardingView2.SliderTitle", "OnBoardingView2.SliderDescription", "welcome_slider1.json"));
        sliderList.add(new SliderModel(2,"OnBoardingView3.SliderTitle", "OnBoardingView3.SliderDescription", "welcome_slider2.json"));
        sliderList.add(new SliderModel(3,"OnBoardingView4.SliderTitle", "OnBoardingView4.SliderDescription", "welcome_slider3.json"));
        sliderList.add(new SliderModel(4,"OnBoardingView5.SliderTitle", "OnBoardingView5.SliderDescription", "welcome_slider4.json"));

        recyclerView = findViewById(R.id.recLayout);
        mDots = findViewById(R.id.mDots);
        ivDots = new ImageView[sliderList.size()];

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    View centerView = snapHelper.findSnapView(mLayoutManager);
                    pos = mLayoutManager.getPosition(centerView);
                    addDotsIndicator(pos);
                }
            }
        });

        onBoardingRecyclerViewAdaptor= new OnBoardingRecyclerViewAdaptor(sliderList);
        mLayoutManager = new LinearLayoutManager(OnboardingActivity.this, RecyclerView.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(onBoardingRecyclerViewAdaptor);
        addDotsIndicator(0);

        btnDevamEt = findViewById(R.id.btnDevamEt);
        btnDevamEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                devamEtButtonTapped();
            }
        });
    }

    private void addDotsIndicator(int position) {
        mDots.removeAllViews();
        for (int i = 0; i < ivDots.length; i++) {
            ivDots[i] = new ImageView(OnboardingActivity.this);
            ivDots[i].setImageResource(R.drawable.viewpager_indicator);
            ivDots[i].setAlpha(0.2f);
            ivDots[i].setPadding(10, 0, 10, 0);
            mDots.addView(ivDots[i]);
        }
        if (ivDots.length > 0) {
            ivDots[position].setAlpha(1f);
        }
    }

    void devamEtButtonTapped(){
        OnboardingActivity.this.startActivity(new Intent(this, MainActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
        OnboardingActivity.this.finish();
    }
}
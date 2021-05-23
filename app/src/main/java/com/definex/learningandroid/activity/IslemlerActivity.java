package com.definex.learningandroid.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.definex.learningandroid.R;
import com.definex.learningandroid.fragment.FirstFragment;
import com.definex.learningandroid.fragment.SecondFragment;
import com.kaopiz.kprogresshud.KProgressHUD;

public class IslemlerActivity extends AppCompatActivity {

    Button alertDialog, buttonProgressDialog, buttonToast, buttonFirstFragment, buttonSecondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islemler);

        alertDialog = findViewById(R.id.buttonAlertDialog);
        alertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(IslemlerActivity.this);
                builder.setTitle("Definex");
                builder.setMessage("Uygulama bilgilerini görüntülemek ister misiniz?");
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);

                    }
                });
                builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });

        buttonProgressDialog = findViewById(R.id.buttonProgressDialog);
        buttonProgressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KProgressHUD hud = KProgressHUD.create(IslemlerActivity.this)
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setLabel("Please wait")
                        .setDetailsLabel("Downloading data")
                        .setCancellable(true)
                        .setAnimationSpeed(2)
                        .setDimAmount(0.5f)
                        .show();

                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (hud.isShowing()){
                            hud.dismiss();
                        }
                    }
                }, 5000);
            }
        });

        buttonToast = findViewById(R.id.buttonToast);
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(IslemlerActivity.this, "Toast Message", Toast.LENGTH_LONG).show();
            }
        });

        buttonFirstFragment = findViewById(R.id.buttonFirstFragment);
        buttonFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                FirstFragment firstFragment = new FirstFragment();
                //fragmentTransaction.add(R.id.frame_layout,firstFragment).commit();
                fragmentTransaction.replace(R.id.frame_layout,firstFragment).commit();
            }
        });
        buttonSecondFragment = findViewById(R.id.buttonSecondFragment);
        buttonSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                SecondFragment secondFragment = new SecondFragment();
                fragmentTransaction.replace(R.id.frame_layout,secondFragment).commit();
            }
        });

    }
}
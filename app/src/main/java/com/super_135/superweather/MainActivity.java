package com.super_135.superweather;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView iViewSettings;
    private Integer temperature = 15;
    private TextView tViewTemperature;
    private Button btnAdd5Degrees;

    private final String temperatureKey = "temperatureKey";
    private final String plus = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "onCeate", Toast.LENGTH_SHORT).show();
        Log.d("Events", "onCeate");
        setContentView(R.layout.activity_main);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        findView();
        setOniViewCurrent();
        setDefaultValues();
    }

    private void findView() {
        iViewSettings = findViewById(R.id.iViewSettings);
        tViewTemperature = findViewById(R.id.tViewTemperature);
        btnAdd5Degrees = findViewById(R.id.btnAdd5Degrees);
    }

    private void setOniViewCurrent() {
        iViewSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),getString(R.string.activity_Settings),Toast.LENGTH_SHORT).show();
            }
        });
        btnAdd5Degrees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperature = temperature + 5;
                setDefaultValues();
            }
        });
    }

    private void setDefaultValues() {
        tViewTemperature.setText(plus+ temperature.toString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle saveInstanceState) {
        Integer temperatureDate = temperature;
        saveInstanceState.putInt(temperatureKey,temperatureDate);
        super.onSaveInstanceState(saveInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        temperature = savedInstanceState.getInt(temperatureKey);
        setDefaultValues();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        Log.d("Events", "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        Log.d("Events", "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        Log.d("Events", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Log.d("Events", "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d("Events", "onDestroy");
    }

}
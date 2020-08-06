package com.super_135.superweather;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView iViewSettings;
    private Integer temperature = 15;
    private String currentPoint = "Москва";
    private TextView tViewTemperature;
    private Button btnSendWeather;
    private ImageView iViewCity;
    private TextView tViewCiy;

    private final int requestCode = 111;


    final String temperatureKey = "temperatureKey";
    final String plus = "+";
    final static String currentPointKey = "currentPointKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        findView();
        setOniViewCurrent();
        setDefaultValues();
        SetOnSelectCity();
    }

    private void SetOnSelectCity() {
        iViewCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CitySelectionScreen.class);
                intent.putExtra(currentPointKey,tViewCiy.getText().toString());
                startActivityForResult(intent,requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.requestCode && resultCode == RESULT_OK && data != null){
            tViewCiy.setText(data.getStringExtra(CitySelectionScreen.currentPointKey1));
        }
    }

    private void findView() {
        iViewSettings = findViewById(R.id.iViewSettings);
        tViewTemperature = findViewById(R.id.tViewTemperature);
        btnSendWeather = findViewById(R.id.btnSendWeather);
        iViewCity = findViewById(R.id.iViewCity);
        tViewCiy = findViewById(R.id.tViewCiy);
    }

    private void setOniViewCurrent() {
        iViewSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),getString(R.string.activity_Settings),Toast.LENGTH_SHORT).show();
            }
        });
        btnSendWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Передаю свою температуру\n "+tViewCiy.getText().toString()+ "  "+ tViewTemperature.getText().toString());
                startActivity(Intent.createChooser(shareIntent, "Share text"));
            }
        });
    }


    private void setDefaultValues() {
        tViewTemperature.setText(plus+ temperature.toString());
        tViewCiy.setText(currentPoint);
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

}
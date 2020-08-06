package com.super_135.superweather;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CitySelectionScreen extends AppCompatActivity {
    private ImageView iViewCurrent;
    private ImageView iViewFavourites;
    private TextView tViewCurrentCity;
    private TextView tViewtFavouritesCity;
    final static String currentPointKey1 = "currentPointKey1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_selection_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        findView();
        showBackBtn();
        setOniViewCurrent();
        showDataFromFirstActivity();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== android.R.id.home) {
            Intent intentCity = new Intent();
            String strDate = tViewtFavouritesCity.getText().toString();
            if (! strDate.equals("")) {
                intentCity.putExtra(currentPointKey1, strDate);
            } else {
                intentCity.putExtra(currentPointKey1, tViewCurrentCity.getText().toString());
            }
            setResult(RESULT_OK, intentCity);
            finish();
        }
        return true;
    }

    private void setOniViewCurrent() {
        iViewCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),getString(R.string.current_place),Toast.LENGTH_SHORT).show();
            }
        });
        iViewFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),getString(R.string.favourites),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void findView() {
        iViewCurrent = findViewById(R.id.iViewCurrent);
        iViewFavourites = findViewById(R.id.iViewFavourites);
        tViewCurrentCity = findViewById(R.id.tViewCurrentCity);
        tViewtFavouritesCity = findViewById(R.id.tViewtFavouritesCity);
    }

    private void showBackBtn(){
        try {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    private void showDataFromFirstActivity(){
        tViewCurrentCity.setText(getIntent().getStringExtra(MainActivity.currentPointKey));
    }
}
package com.super_135.superweather;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CitySelectionScreen extends AppCompatActivity {
    private ImageView iViewCurrent;
    private ImageView iViewFavourites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_selection_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        findView();
        setOniViewCurrent();
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
    }
}
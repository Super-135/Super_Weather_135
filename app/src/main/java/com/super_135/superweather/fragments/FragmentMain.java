package com.super_135.superweather.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.super_135.superweather.CitySelectionScreen;
import com.super_135.superweather.R;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMain extends Fragment {

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


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);

        findView(view);
        setOniViewCurrent();
        setDefaultValues();
        SetOnSelectCity();

    }

    private void SetOnSelectCity() {
        iViewCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Objects.requireNonNull(getActivity()), CitySelectionScreen.class);
                intent.putExtra(currentPointKey,tViewCiy.getText().toString());
                startActivityForResult(intent,requestCode);
            }
        });
    }

    private void setDefaultValues() {
        tViewTemperature.setText(plus+ temperature.toString());
        tViewCiy.setText(currentPoint);
    }

    private void setOniViewCurrent() {
        btnSendWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, tViewCiy.getText().toString()+ "  "+ tViewTemperature.getText().toString());
                startActivity(Intent.createChooser(shareIntent, "Share text"));
            }
        });
    }

    private void findView(View view) {
        iViewSettings = view.findViewById(R.id.iViewSettings);
        tViewTemperature = view.findViewById(R.id.tViewTemperature);
        btnSendWeather = view.findViewById(R.id.btnSendWeather);
        iViewCity = view.findViewById(R.id.iViewCity);
        tViewCiy = view.findViewById(R.id.tViewCiy);
    }

}

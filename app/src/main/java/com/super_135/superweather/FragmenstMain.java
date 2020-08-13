package com.super_135.superweather;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmenstMain extends Fragment {

    private TextView tViewTemperature;
    private Button btnSendWeather;
    private ImageView iViewCity;
    private TextView tViewCiy;


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
        SetOnSelectCity();
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getBus().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getBus().unregister(this);
        super.onStop();
    }

    private void findView(View view) {
        tViewTemperature = view.findViewById(R.id.tViewTemperature);
        btnSendWeather = view.findViewById(R.id.btnSendWeather);
        iViewCity = view.findViewById(R.id.iViewCity);
        tViewCiy = view.findViewById(R.id.tViewCiy);
    }

    private void setOniViewCurrent() {
        btnSendWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, tViewCiy.getText().toString()+ "  "+ tViewTemperature.getText().toString());
                startActivity(Intent.createChooser(shareIntent, getString(R.string.share_text)));
            }
        });
    }


    private void SetOnSelectCity() {
        iViewCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Objects.requireNonNull(getActivity()), CitySelectionScreen.class);
                startActivity(intent);
            }
        });
    }

    @Subscribe
    @SuppressWarnings("unused")
    public void onSomeEvent(SomeEvent event){
        tViewCiy.setText(event.textCity);
    }

}

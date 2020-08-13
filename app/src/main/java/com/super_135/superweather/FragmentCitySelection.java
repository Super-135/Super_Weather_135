package com.super_135.superweather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentCitySelection extends Fragment {

    private TextView tViewtFavouritesCity;
    private ImageView iViewFavourites;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_city_selection, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        findView(view);
        setOniViewSity();
    }

    private void findView(View view) {
        tViewtFavouritesCity = view.findViewById(R.id.tViewtFavouritesCity);
        iViewFavourites = view.findViewById(R.id.iViewFavourites);
    }

    private void setOniViewSity() {
        iViewFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getBus().post(new SomeEvent(tViewtFavouritesCity.getText().toString()));
            }
        });
    }


}

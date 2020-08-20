package com.super_135.superweather.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.super_135.superweather.IRVOnItemClick;
import com.super_135.superweather.R;
import com.super_135.superweather.RecyclerDateAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentWeatherForWeek extends Fragment implements IRVOnItemClick {

    private RecyclerView recyclerView;
    private RecyclerDateAdapter adapter;
    private ArrayList<String> listData
            = new ArrayList<>(Arrays.asList("17 августа", "18 августа","19 августа","20 августа",
            "21 августа","22 августа","23 августа"));

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather_for_week, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);

        findView(view);
        setupRecyclerView();

    }

    @Override
    public void onItemClicked(String itemText) {
        // Пока заглушка. Потом открываем активити которое частично перекрывает предыдущее активити
        // и показывает подробную информацию по этому дню.
    }

    private void findView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
    }

    private void setupRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new RecyclerDateAdapter(listData,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}

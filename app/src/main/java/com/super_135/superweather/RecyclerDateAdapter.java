package com.super_135.superweather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerDateAdapter extends RecyclerView.Adapter<RecyclerDateAdapter.ViewHolder> {

    private ArrayList<String> data;
    private IRVOnItemClick onItemClick;


    public RecyclerDateAdapter(ArrayList<String> data, IRVOnItemClick onItemClick){
        this.data = data;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String str = data.get(position);
        holder.setTextToTextView(str);
        holder.setOnClickForItem(str);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvDay;
        private TextView tvTemperature;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvDay = itemView.findViewById(R.id.tvDay);
            tvTemperature = itemView.findViewById(R.id.tvTemperature);
        }

        public void setTextToTextView(String text){
            tvDay.setText(text);
            tvTemperature.setText("+22");
        }

        void setOnClickForItem(final String text) {
            tvDay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClick != null) {
                        onItemClick.onItemClicked(text);
                    }
                }
            });
            tvTemperature.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClick != null) {
                        onItemClick.onItemClicked(text);
                    }
                }
            });
        }

    }
}

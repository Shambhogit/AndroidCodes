package com.example.studentapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ContentAdapter extends ArrayAdapter<CardModel> {

    ArrayList<CardModel> cardModels;
    Context context ;
    GridView gridView ;

    public ContentAdapter(@NonNull Context context, ArrayList<CardModel> objects) {
        super(context, 0, objects);

        this.cardModels = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card_menu, parent,false);
        }

        TextView nameTV = listItemView.findViewById(R.id.id_tv_cardName);
        ImageView iconIV = listItemView.findViewById(R.id.id_iv_icon);

        nameTV.setText(cardModels.get(position).name);
        iconIV.setImageResource(cardModels.get(position).image);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0){
                    Intent insert = new Intent(context, Insert.class);
                    context.startActivity(insert);
                }
                if(position == 1){
                    Intent update = new Intent(context, Update.class);
                    context.startActivity(update);
                }
                if(position == 2){
                    Intent delete = new Intent(context,ShowData.class);
                    context.startActivity(delete);
                }
            }
        });

        return  listItemView;
    }
}

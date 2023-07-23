package com.example.studentapp;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;


public class UpdateCardAdapter extends ArrayAdapter<UpdateModal> {
    Context context;
    ArrayList<UpdateModal> updateModals;

    public UpdateCardAdapter(Context context, ArrayList<UpdateModal> objects) {
        super(context, 0, objects);
        this.context = context;
        this.updateModals = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
         itemView =LayoutInflater.from(getContext()).inflate(R.layout.update_card, parent, false);
        }

        ImageView img = itemView.findViewById(R.id.id_iv_updateIcon);
        TextView txt = itemView.findViewById(R.id.id_tv_updateName);

        img.setImageResource(updateModals.get(position).image);
        txt.setText(updateModals.get(position).text);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0) {
                    Intent i = new Intent(getContext(), UpdateName.class);
                    context.startActivity(i);
                }
                if(position == 1){
                    Intent i = new Intent(getContext(),UpdateRoll.class);
                    context.startActivity(i);

                }
                if(position == 2){
                    Intent i = new Intent(getContext(),UpdateCollege.class);
                    context.startActivity(i);
                }
                if(position == 3){
                    Intent i = new Intent(getContext(),UpdateMarks.class);
                    context.startActivity(i);
                }
                if(position == 4){
                    Intent i = new Intent(getContext(),UpdateTread.class);
                    context.startActivity(i);
                }
                if(position == 5){
                    Intent i = new Intent(getContext(),UpdateClass.class);
                    context.startActivity(i);
                }
            }
        });

         return itemView;
    }
}

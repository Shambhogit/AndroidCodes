package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModule> arrContact;
    public RecyclerContactAdapter(Context context , ArrayList<ContactModule> arrContact){
        this.context = context;
        this.arrContact = arrContact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imgContact.setImageResource(arrContact.get(position).image);
        holder.txtName.setText(arrContact.get(position).name);
        holder.txtNumber.setText(arrContact.get(position).number);
        setAnimation(holder.itemView,position);
    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName, txtNumber;
        ImageView imgContact;
        public ViewHolder(View view){
            super(view);
            imgContact = view.findViewById(R.id.imgContact);
            txtName = view.findViewById(R.id.txtName);
            txtNumber = view.findViewById(R.id.txtNumber);
        }
    }

    private void setAnimation(View viewToAnimation, int position){
        Animation slideIn = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        viewToAnimation.startAnimation(slideIn);
    }
}

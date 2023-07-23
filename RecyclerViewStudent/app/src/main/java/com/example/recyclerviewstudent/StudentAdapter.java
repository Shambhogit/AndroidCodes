package com.example.recyclerviewstudent;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    Context context;
    ArrayList<StudentStructure> students;

    public StudentAdapter(Context context, ArrayList<StudentStructure> students){
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_layout,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        view.setAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getApplicationContext(), ""+viewHolder.name.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(students.get(position).icon);
        holder.name.setText(students.get(position).name);
        holder.tread.setText(students.get(position).tread);
        holder.college.setText(students.get(position).college);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView icon;
        TextView name,tread,college;
        public ViewHolder(View view){
            super(view);
            icon = view.findViewById(R.id.id_iv_icon);
            name = view.findViewById(R.id.id_tv_name);
            tread = view.findViewById(R.id.id_tv_tread);
            college = view.findViewById(R.id.id_tv_college);
        }
    }

}

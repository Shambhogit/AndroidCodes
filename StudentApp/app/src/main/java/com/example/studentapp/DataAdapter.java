package com.example.studentapp;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    Context context;
    ArrayList<DataModal> dataModals;
    public DataAdapter(Context context, ArrayList<DataModal> dataModals){

        this.context = context;
        this.dataModals = dataModals;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_data_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.unique.setText(String.valueOf(dataModals.get(position).unique));
        holder.name.setText(dataModals.get(position).name);
        holder.roll.setText(String.valueOf(dataModals.get(position).roll));
        holder.className.setText(dataModals.get(position).className);
        holder.tread.setText(dataModals.get(position).tread);
        holder.college.setText(dataModals.get(position).college);
        holder.marks.setText(String.valueOf(dataModals.get(position).marks));


        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder deleteDilog = new AlertDialog.Builder(context);
                deleteDilog.setTitle("Delete ?");
                deleteDilog.setMessage("Delete this Student Record "+holder.name.getText());
                deleteDilog.setIcon(R.drawable.warning);
                deleteDilog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StudentDatabase db = new StudentDatabase(context);
                        db.deleteData(Integer.parseInt(holder.unique.getText().toString()));
                        Toast.makeText(context,"Data Deleted Successfully",Toast.LENGTH_SHORT).show();
                    }
                });
                deleteDilog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context,"Delete Operation Canceled",Toast.LENGTH_SHORT).show();

                    }
                });
                deleteDilog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView unique,roll,name,className,tread,college,marks;
        LinearLayout card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            unique = itemView.findViewById(R.id.tv_uniqenum);
            roll = itemView.findViewById(R.id.tv_roll);
            name = itemView.findViewById(R.id.tv_name);
            className = itemView.findViewById(R.id.tv_class);
            tread = itemView.findViewById(R.id.tv_tread);
            college = itemView.findViewById(R.id.tv_college);
            marks = itemView.findViewById(R.id.tv_marks);
            card = itemView.findViewById(R.id.card);
        }
    }
}

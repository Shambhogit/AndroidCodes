package com.example.monthlyexpence;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    Context context;
    ArrayList<UserDataModel> userDataModels;
    public DataAdapter(Context context, ArrayList<UserDataModel> dataModales){
        this.context = context;
        this.userDataModels = dataModales;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.show_data,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        String reason = userDataModels.get(position).reason;
        holder.reason.setText(reason.toUpperCase());
        holder.cost.setText(userDataModels.get(position).cost);
        holder.date.setText(userDataModels.get(position).date);
        holder.discprition.setText(userDataModels.get(position).discription);
        if(userDataModels.get(position).type.equals("Good Expense")){
            holder.type.setImageResource(R.drawable.good);
        }
        else{
            holder.type.setImageResource(R.drawable.bad);
        }
    }

    @Override
    public int getItemCount() {
        return userDataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView reason,cost,date,discprition;
        ImageView type;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            reason = itemView.findViewById(R.id.tvReason);
            cost = itemView.findViewById(R.id.tvCost);
            date = itemView.findViewById(R.id.tvDate);
            discprition = itemView.findViewById(R.id.tvDescription);
            type = itemView.findViewById(R.id.ivIcon);
        }
    }
}

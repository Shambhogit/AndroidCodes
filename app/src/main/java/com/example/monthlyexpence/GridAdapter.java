package com.example.monthlyexpence;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class GridAdapter extends ArrayAdapter<UserDataModel> {

    Context context;
    ArrayList<UserDataModel> userDataModel;

    public GridAdapter(Context context , ArrayList<UserDataModel> userDataModels){
        super(context,0,userDataModels);

        this.context = context;
        this.userDataModel = userDataModels;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card_delete_grid,parent,false);
        }

        TextView reason , cost, date;
        reason = listItemView.findViewById(R.id.tvReason);
        cost = listItemView.findViewById(R.id.tvCost);
        date = listItemView.findViewById(R.id.tvDate);
        String r = userDataModel.get(position).reason;
        reason.setText(r.toUpperCase());
        cost.setText(userDataModel.get(position).cost);
        date.setText(userDataModel.get(position).date);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder confrom = new AlertDialog.Builder(context);
                confrom.setIcon(R.drawable.deletepng);
                confrom.setTitle("Delete !!");
                confrom.setMessage("Do you Really Want to Delete Record ?");
                confrom.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        UserDatabase db = new UserDatabase(context);
                        int rowsDeleted = db.deleleExpense(userDataModel.get(position));
                        db.close();
                        if(rowsDeleted > 0){
                            Toast.makeText(context, "data is deleted successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                confrom.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "Data is Not deleted", Toast.LENGTH_SHORT).show();
                    }
                });

                confrom.create();
                confrom.show();
            }
        });

        return listItemView;
    }
}

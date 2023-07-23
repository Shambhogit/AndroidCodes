package com.example.broadcastreciverex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent){

        String action = intent.getAction();
        Toast.makeText(context,""+action, Toast.LENGTH_SHORT).show();
    }
}

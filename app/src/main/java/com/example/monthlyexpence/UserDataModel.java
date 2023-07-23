package com.example.monthlyexpence;

public class UserDataModel {
    String userID,reason,cost,date,type,discription;

    public UserDataModel(String userID, String reason, String cost, String date, String type, String discription) {
        this.userID = userID;
        this.reason = reason;
        this.cost = cost;
        this.date = date;
        this.type = type;
        this.discription = discription;
    }
}

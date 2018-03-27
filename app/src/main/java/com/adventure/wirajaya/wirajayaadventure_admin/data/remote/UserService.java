package com.adventure.wirajaya.wirajayaadventure_admin.data.remote;

import android.app.Application;

import com.adventure.wirajaya.wirajayaadventure_admin.data.remote.model.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserService {

    private Application application;
    private DatabaseReference databaseRef;

    public UserService(Application application) {
        this.application = application;
        this.databaseRef = FirebaseDatabase.getInstance().getReference();
    }



    public void createUser(User user) {
        if(user.getPhoto_url() == null) {
            user.setPhoto_url("NOT");
        }
        databaseRef.child("users").child(user.getUid()).setValue(user);

    }


    public DatabaseReference getUser(String userUid) {
        return databaseRef.child("users").child(userUid);
    }


    public Task<Void> updateUser(User user) {
//        databaseRef.child("user-status").child(user.getUid()).child("active").setValue("false");
        return databaseRef.child("users").child(user.getUid()).setValue(user);
    }
}

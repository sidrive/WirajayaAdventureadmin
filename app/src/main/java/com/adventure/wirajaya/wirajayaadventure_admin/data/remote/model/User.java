package com.adventure.wirajaya.wirajayaadventure_admin.data.remote.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

/**
 * Created by androidev on 26/03/18.
 */

public class User {

    @NonNull
    public String uid;
    @Nullable
    public String phone;
    @Nullable
    public String email;
    @Nullable
    public String provider;
    @Nullable
    public String photo_url;
    @Nullable
    public String full_name;

    public static User newInstance(FirebaseUser firebaseUser, UserInfo provider) {
        User user = new User(firebaseUser.getUid());
        user.setProvider(provider.getProviderId());
        // TODO : refactoring
        if (provider.getProviderId().equals("password")) {
            user.setEmail(firebaseUser.getEmail());

        } else {

        }

        return user;
    }

    public User() {
    }

    public User(String uid) {
        this.uid = uid;
    }

    public User(@NonNull String uid, String phone, String email, String provider, String photo_url, String full_name) {
        this.uid = uid;
        this.phone = phone;
        this.email = email;
        this.provider = provider;
        this.photo_url = photo_url;
        this.full_name = full_name;
    }

    @NonNull
    public String getUid() {
        return uid;
    }

    public void setUid(@NonNull String uid) {
        this.uid = uid;
    }

    @Nullable
    public String getPhone() {
        return phone;
    }

    public void setPhone(@Nullable String phone) {
        this.phone = phone;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getProvider() {
        return provider;
    }

    public void setProvider(@Nullable String provider) {
        this.provider = provider;
    }

    @Nullable
    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(@Nullable String photo_url) {
        this.photo_url = photo_url;
    }

    @Nullable
    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(@Nullable String full_name) {
        this.full_name = full_name;
    }
}

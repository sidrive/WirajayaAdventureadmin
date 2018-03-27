package com.adventure.wirajaya.wirajayaadventure_admin.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.adventure.wirajaya.wirajayaadventure_admin.base.BasePresenter;
import com.adventure.wirajaya.wirajayaadventure_admin.data.FirebaseUserService;
import com.adventure.wirajaya.wirajayaadventure_admin.data.remote.UserService;
import com.adventure.wirajaya.wirajayaadventure_admin.data.remote.model.User;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by androidev on 26/03/18.
 */

public class LoginPresenter implements BasePresenter {

    LoginActivity activity;
    UserService userService;
    FirebaseUserService firebaseUserService;

    public LoginPresenter(LoginActivity activity, UserService userService, FirebaseUserService firebaseUserService){
        this.activity = activity;
        this.userService = userService;
        this.firebaseUserService = firebaseUserService;
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {

    }

    protected Intent loginWithGoogle() {
        return firebaseUserService.getUserWithGoogle(activity);
    }

    protected void getAuthWithGoogle(GoogleSignInResult result) {
        if(result.isSuccess()) {
            final GoogleSignInAccount acct = result.getSignInAccount();
            firebaseUserService.getAuthWithGoogle(activity, acct)
                    .addOnCompleteListener(activity, task -> {
                        if (task.isSuccessful()) {
//                            activity.showLoading(false);
                            for(UserInfo profile : task.getResult().getUser().getProviderData()) {
                                String providerId = profile.getProviderId();
                                String uid = profile.getUid();
                                String name = profile.getDisplayName();
                                String email = profile.getEmail();
                                Uri photoUri = profile.getPhotoUrl();
                                Log.d("users  = ", providerId + " " + uid + " " + name + " " + email + " " + photoUri);
                            }
                            Log.e("getAuthWithGoogle", "LoginPresenter" + task.getResult().getUser().getProviderData().toString());
                            processLogin(task.getResult().getUser(), task.getResult().getUser().getProviderData().get(1));
                        } else {
//                            activity.showLoading(false);
                            activity.showLoginFail("Gagal Masuk");
                        }
                    }).addOnFailureListener(e -> {activity.showLoginFail(e.getMessage());});
        } else {
            activity.showLoginFail("Gagal Masuk");
        }
    }

    private void processLogin(final FirebaseUser firebaseUser, UserInfo userInfo) {
        final User user = User.newInstance(firebaseUser, userInfo);
        userService.getUser(user.getUid()).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User remoteUser = dataSnapshot.getValue(User.class);
                        if(remoteUser == null || remoteUser.getFull_name() == null || remoteUser.getEmail() == null) {
                            if (remoteUser != null){
                                if (remoteUser.getFull_name() != null) user.setFull_name(remoteUser.getFull_name());
                                if (remoteUser.getEmail() != null) user.setEmail(remoteUser.getEmail());
                                if (remoteUser.getPhone() != null) user.setPhone(remoteUser.getPhone());
                            }
                            activity.showRegisterUser(user);

                        } else {
                            if (remoteUser.isAcceptTOS()) activity.showLoginSuccess(remoteUser);
                            /*else if (remoteUser.isAcceptTOS()) activity.showVerified(remoteUser);
                            else activity.showIntroActivity(remoteUser);*/
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        activity.showLoginFail("Gagal Masuk");
                    }
                }
        );
    }

    public void revoke(){
        firebaseUserService.revokeTokenGoogle(activity);
    }
}

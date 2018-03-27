package com.adventure.wirajaya.wirajayaadventure_admin.ui.login;

import com.adventure.wirajaya.wirajayaadventure_admin.base.annotation.ActivityScope;
import com.adventure.wirajaya.wirajayaadventure_admin.data.FirebaseUserService;
import com.adventure.wirajaya.wirajayaadventure_admin.data.remote.UserService;

import dagger.Provides;

/**
 * Created by androidev on 26/03/18.
 */

public class LoginActivityModule {
    LoginActivity activity;

    public LoginActivityModule(LoginActivity activity){
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    LoginActivity provideLoginActivity(){return activity;}

    @ActivityScope
    @Provides
    LoginPresenter provideLoginPresenter(UserService userService, FirebaseUserService firebaseUserService){
        return new LoginPresenter(activity, userService,firebaseUserService);
    }
}

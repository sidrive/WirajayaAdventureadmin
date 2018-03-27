package com.adventure.wirajaya.wirajayaadventure_admin.base;

import com.adventure.wirajaya.wirajayaadventure_admin.data.remote.firebase.FirebaseModule;
import com.adventure.wirajaya.wirajayaadventure_admin.data.remote.network.NetworkModule;
import com.adventure.wirajaya.wirajayaadventure_admin.ui.login.LoginActivityComponent;
import com.adventure.wirajaya.wirajayaadventure_admin.ui.login.LoginActivityModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by androidev on 26/03/18.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                FirebaseModule.class,
                NetworkModule.class
        }
)

public interface AppComponent {

    LoginActivityComponent plus(LoginActivityModule activityModule);

    Retrofit retrofit();
}

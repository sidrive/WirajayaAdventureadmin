package com.adventure.wirajaya.wirajayaadventure_admin.data.remote.firebase;

import android.app.Application;

import com.adventure.wirajaya.wirajayaadventure_admin.data.FirebaseUserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by androidev on 26/03/18.
 */

@Module
public class FirebaseModule {
    @Provides
    @Singleton
    public FirebaseUserService provideFirebaseUserService(Application application) {
        return new FirebaseUserService(application);
    }

//    @Provides
//    @Singleton
//    public UserService provideUserService(Application application) {
//        return new UserService(application);
//    }
//
//    @Provides
//    @Singleton
//    public FirebaseImageService provideFirebaseImageService(Application application) {
//        return new FirebaseImageService(application);
//    }
}

package com.adventure.wirajaya.wirajayaadventure_admin.data.main;

import com.adventure.wirajaya.wirajayaadventure_admin.base.annotation.MainScope;
import com.adventure.wirajaya.wirajayaadventure_admin.ui.main.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by androidev on 26/03/18.
 */
@Module
public class MainModule {
    MainActivity activity;

    public MainModule(MainActivity activity){
        this.activity = activity;
    }

    @Provides
    @MainScope
    MainActivity provideMainActivity(){
        return activity;
    }
}

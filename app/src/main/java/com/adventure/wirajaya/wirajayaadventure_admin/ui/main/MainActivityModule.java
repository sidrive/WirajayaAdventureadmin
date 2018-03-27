package com.adventure.wirajaya.wirajayaadventure_admin.ui.main;

import com.adventure.wirajaya.wirajayaadventure_admin.base.annotation.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by androidev on 26/03/18.
 */

@Module
public class MainActivityModule {
    MainActivity activity;

    public MainActivityModule(MainActivity activity){this.activity = activity;}

    @ActivityScope
    @Provides
    MainActivity provideMainActivity(){return activity;}

    @ActivityScope
    @Provides
    MainPresenter provideMainPresenter(/*UserService userService, User user, CategoryService categoryService*/){
        return new MainPresenter(activity/*, userService, user, categoryService*/);
    }
}

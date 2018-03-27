package com.adventure.wirajaya.wirajayaadventure_admin.ui.main;

import com.adventure.wirajaya.wirajayaadventure_admin.base.annotation.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by androidev on 26/03/18.
 */
@ActivityScope
@Subcomponent(
        modules = {
                MainActivityModule.class
        }
)
public interface MainActivityComponent {
    MainActivity inject(MainActivity activity);
}

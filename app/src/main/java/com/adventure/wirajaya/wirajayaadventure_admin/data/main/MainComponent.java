package com.adventure.wirajaya.wirajayaadventure_admin.data.main;

import com.adventure.wirajaya.wirajayaadventure_admin.base.annotation.MainScope;

import dagger.Subcomponent;

/**
 * Created by androidev on 26/03/18.
 */
@MainScope
@Subcomponent(
        modules = {
                MainModule.class
        }
)

public interface MainComponent {
}

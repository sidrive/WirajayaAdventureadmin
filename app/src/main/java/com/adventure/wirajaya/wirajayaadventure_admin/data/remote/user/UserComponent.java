package com.adventure.wirajaya.wirajayaadventure_admin.data.remote.user;

import com.adventure.wirajaya.wirajayaadventure_admin.base.annotation.UserScope;
import com.adventure.wirajaya.wirajayaadventure_admin.data.main.MainComponent;
import com.adventure.wirajaya.wirajayaadventure_admin.data.main.MainModule;
import com.adventure.wirajaya.wirajayaadventure_admin.ui.main.MainActivityComponent;
import com.adventure.wirajaya.wirajayaadventure_admin.ui.main.MainActivityModule;

import dagger.Subcomponent;

/**
 * Created by androidev on 26/03/18.
 */
@UserScope
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {

    MainActivityComponent plus(MainActivityModule activityModule);

    MainComponent plus(MainModule mainModule);

}


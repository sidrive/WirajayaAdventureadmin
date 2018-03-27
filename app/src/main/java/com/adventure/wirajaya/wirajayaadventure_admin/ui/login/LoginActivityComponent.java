package com.adventure.wirajaya.wirajayaadventure_admin.ui.login;

import com.adventure.wirajaya.wirajayaadventure_admin.base.annotation.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by androidev on 26/03/18.
 */
@ActivityScope
@Subcomponent(
        modules = {
                LoginActivityModule.class
        }
)
public interface LoginActivityComponent {
    LoginActivity inject(LoginActivity activity);
}

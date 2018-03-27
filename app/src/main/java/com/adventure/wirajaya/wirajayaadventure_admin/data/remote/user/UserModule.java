package com.adventure.wirajaya.wirajayaadventure_admin.data.remote.user;

import com.adventure.wirajaya.wirajayaadventure_admin.base.annotation.UserScope;
import com.adventure.wirajaya.wirajayaadventure_admin.data.remote.model.User;

import dagger.Module;
import dagger.Provides;

/**
 * Created by androidev on 26/03/18.
 */

@Module
public class UserModule {

    User user;

    public UserModule(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    User provideUser() {
        return user;
    }
}

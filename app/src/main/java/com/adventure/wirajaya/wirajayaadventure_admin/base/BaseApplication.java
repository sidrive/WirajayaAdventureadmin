package com.adventure.wirajaya.wirajayaadventure_admin.base;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.adventure.wirajaya.wirajayaadventure_admin.base.config.DefaultConfig;
import com.adventure.wirajaya.wirajayaadventure_admin.data.main.MainComponent;
import com.adventure.wirajaya.wirajayaadventure_admin.data.main.MainModule;
import com.adventure.wirajaya.wirajayaadventure_admin.data.remote.firebase.FirebaseModule;
import com.adventure.wirajaya.wirajayaadventure_admin.data.remote.network.NetworkModule;
import com.adventure.wirajaya.wirajayaadventure_admin.data.remote.user.UserComponent;
import com.adventure.wirajaya.wirajayaadventure_admin.ui.main.MainActivity;
import com.google.firebase.FirebaseApp;

/**
 * Created by androidev on 26/03/18.
 */

public class BaseApplication extends MultiDexApplication {

    public static AppComponent appComponent;
    public static DefaultConfig defaultConfig;
    public static UserComponent userComponent;
    public static MainComponent mainComponent;

    private Context context;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //FirebaseApp.initializeApp(base);
//        defaultConfig = new DefaultConfig(base);
        context =base;
        MultiDex.install(getBaseContext());
        //FirebaseApp.initializeApp(getBaseContext());
    }

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .firebaseModule(new FirebaseModule())
                .networkModule(new NetworkModule(defaultConfig.getApiUrl()))
                .build();
        FirebaseApp.initializeApp(getBaseContext());
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }

    public MainComponent createMainComponent(MainActivity activity) {
        mainComponent = userComponent.plus(new MainModule(activity));
        return mainComponent;
    }
}

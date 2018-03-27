package com.adventure.wirajaya.wirajayaadventure_admin.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.adventure.wirajaya.wirajayaadventure_admin.R;
import com.adventure.wirajaya.wirajayaadventure_admin.base.BaseActivity;
import com.adventure.wirajaya.wirajayaadventure_admin.base.BaseApplication;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setupActivityComponent() {
        BaseApplication.get(this).getUserComponent()
                .plus(new MainActivityModule(this))
                .inject(this);
        BaseApplication.get(this).createMainComponent(this);
    }
}

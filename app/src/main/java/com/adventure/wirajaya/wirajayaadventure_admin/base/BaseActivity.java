package com.adventure.wirajaya.wirajayaadventure_admin.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by androidev on 26/03/18.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
    }

    protected abstract void setupActivityComponent();
}

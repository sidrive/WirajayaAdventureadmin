package com.adventure.wirajaya.wirajayaadventure_admin.ui.main;

import com.adventure.wirajaya.wirajayaadventure_admin.base.BasePresenter;

/**
 * Created by androidev on 26/03/18.
 */

public class MainPresenter implements BasePresenter {
    MainActivity activity;

    public MainPresenter(MainActivity activity/*, UserService userService, User user, CategoryService categoryService*/){
        this.activity = activity;
//        this.userService = userService;
//        this.user = user;
//        this.categoryService = categoryService;
    }
    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}

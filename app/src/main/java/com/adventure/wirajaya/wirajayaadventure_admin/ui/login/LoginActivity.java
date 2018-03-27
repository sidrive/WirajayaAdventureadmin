package com.adventure.wirajaya.wirajayaadventure_admin.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.adventure.wirajaya.wirajayaadventure_admin.R;
import com.adventure.wirajaya.wirajayaadventure_admin.base.BaseActivity;
import com.adventure.wirajaya.wirajayaadventure_admin.base.BaseApplication;
import com.adventure.wirajaya.wirajayaadventure_admin.data.remote.model.User;
import com.adventure.wirajaya.wirajayaadventure_admin.ui.main.MainActivity;
import com.facebook.CallbackManager;
import com.facebook.internal.CallbackManagerImpl;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by androidev on 26/03/18.
 */

public class LoginActivity extends BaseActivity {

    public static final int REQUEST_SIGN_GOOGLE = 9001;

    @Nullable
    @Bind(R.id.view_progress)
    LinearLayout viewProgress;

    @Inject
    LoginPresenter presenter;

    private CallbackManager callbackManager;

    boolean isLoginMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @Override
    protected void setupActivityComponent() {
        BaseApplication.get(this).getAppComponent()
                .plus(new LoginActivityModule(this))
                .inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unsubscribe();
    }

    @OnClick(R.id.btn_login_with_google)
    public void loginwithgoogle(){
        Intent intent = presenter.loginWithGoogle();
        startActivityForResult(intent, REQUEST_SIGN_GOOGLE);
    }

    public void showLoginFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void showLoginSuccess(User user) {
//        MainActivity.startWithUser(this, user);
        finish();
    }

    public void showRegisterUser(User user){
//        MainActivity.startWithUser(this, user);
        /*EditProfileActivity.startWithUser(this, user, true);*/
        Toast.makeText(this, "Berhasil Masuk", Toast.LENGTH_LONG).show();
        finish();
    }

    public void showLoading(boolean show){
        if (show){
            viewProgress.setVisibility(View.VISIBLE);
        }else{
            viewProgress.setVisibility(View.GONE);
        }
    }

    public void showLoginMode(){
        isLoginMode = true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            // google
            if(requestCode == REQUEST_SIGN_GOOGLE) {
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                //presenter.cekEmail(result);
//                showLoading(true);
                presenter.getAuthWithGoogle(result);
            }
            // facebook
            else if(requestCode == CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode()) {
                callbackManager.onActivityResult(requestCode, resultCode, data);
            }
        }if (resultCode == RESULT_CANCELED){
            presenter.revoke();
        }

    }
}

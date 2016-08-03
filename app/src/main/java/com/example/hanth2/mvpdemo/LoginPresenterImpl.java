package com.example.hanth2.mvpdemo;

import android.text.TextUtils;
import android.view.View;

/**
 * Created by HanTH2 on 8/3/2016.
 */
public class LoginPresenterImpl implements LoginPresenter{
    private LoginView mLoginView;

    public LoginPresenterImpl(LoginView loginView){
        this.mLoginView = loginView;
    }

    @Override
    public void login(String userName, String password) {
            if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){
                mLoginView.loginValidationError();
            }else if (userName.equals("admin") && password.equals("admin")){
                mLoginView.loginSuccess();
            }else {
                mLoginView.loginError();
            }
    }
}

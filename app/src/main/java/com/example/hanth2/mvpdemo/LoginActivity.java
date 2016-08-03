package com.example.hanth2.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter mLoginPresenter;
    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        onClick();
    }

    private void initView(){
        mEdtUsername = (EditText)findViewById(R.id.edt_username);
        mEdtPassword = (EditText)findViewById(R.id.edt_password);
        mBtnLogin = (Button)findViewById(R.id.btn_login);
    }

    private void onClick(){
        mLoginPresenter = new LoginPresenterImpl(this);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.login(mEdtUsername.getText().toString(), mEdtPassword.getText().toString());
            }
        });
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(), "Login Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginValidationError() {
        Toast.makeText(getApplicationContext(), "Login Validation Error", Toast.LENGTH_LONG).show();
    }
}

package com.boiled.five.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.boiled.five.R;
import com.boiled.five.data.DataManager;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @Bind(R.id.input_email) EditText email;
    @Bind(R.id.input_password) EditText password;
    @Bind(R.id.btn_login) Button login;
    @Bind(R.id.link_signup) TextView signup;

    @Inject DataManager mDataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.btn_login)
    void LoginButton(View view) {
        if (view.getId() == R.id.btn_login) {

            String username = email.getText().toString();
            String pass = password.getText().toString();


            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();
        }
    }


}

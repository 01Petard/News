package com.example.wwwapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_login, btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.login);
        btn_login.setOnClickListener(this);
        btn_register=findViewById(R.id.register);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.login:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                break;
            case R.id.register:
                intent = new Intent(MainActivity.this, RegisterActivity.class);
                break;
        }
        startActivity(intent);
    }
}
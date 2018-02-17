package com.example.apamay.week6_hwpart1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    private registerActivity may;

    EditText edtname,edtPwd;
    Button btnLogin,btnRegistZone;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);





        edtname = (EditText)findViewById(R.id.edtUname);
        edtPwd = (EditText)findViewById(R.id.edtPwd);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnRegistZone = (Button)findViewById(R.id.btnRegistZone);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = edtname.getText().toString();
                String pwd = edtPwd.getText().toString();

                may = new registerActivity();


                boolean isSuccess = may.CheckLogin(uname, pwd);
                if (isSuccess) {
                    Intent intent = new Intent(getApplicationContext(), mainActivity.class);
                    startActivity(intent);
                } else {
                    Context alert = getApplicationContext();
                    Toast.makeText(alert, "Please Register Account", Toast.LENGTH_SHORT).show();
                }
            }
             });

        btnRegistZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),registerActivity.class);
                startActivity(intent);
            }
        });

        }





    }



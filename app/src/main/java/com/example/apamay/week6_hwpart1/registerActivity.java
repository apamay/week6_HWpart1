package com.example.apamay.week6_hwpart1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {
    EditText regUname,regPwd,regCPwd;
    Button btnRegist;



    public Context context;
    public SharedPreferences share;
    public SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);




        regUname = (EditText)findViewById(R.id.edtRegUName);
        regPwd = (EditText)findViewById(R.id.edtRegPwd);
        regCPwd = (EditText)findViewById(R.id.edtRegCFirmPwd);

        btnRegist = (Button)findViewById(R.id.btnRegist);

        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = getApplicationContext();
                share = context.getSharedPreferences("",context.MODE_PRIVATE);
                editor = share.edit();

                String edtUname = regUname.getText().toString();
                String edtPwd = regPwd.getText().toString();
                String edtCpwd = regCPwd.getText().toString();

                if(edtPwd.equals(edtCpwd)){
                    //Write
                    String newUname = share.getString("uName","");
                    editor.putString("uName",edtUname);

                    String newPwd = share.getString("Pwd","");
                    editor.putString("Pwd",edtPwd);

                    editor.commit();
                    Context alert = getApplicationContext();
                    Toast.makeText(alert,"Completely",Toast.LENGTH_SHORT).show();
                    
                }
                else{
                    regCPwd.setError("Wrong Password");

                }

                CheckLogin(edtUname,edtPwd);
                Intent intent = new Intent(getApplicationContext(),loginActivity.class);
                startActivity(intent);
            }
        });



    }




    public boolean CheckLogin(String name,String pwd){


//        String unamecheck = "a";
//        String pwdcheck = "a";

        String unamecheck = share.getString("uName","");
        String pwdcheck = share.getString("Pwd","");



//        if(share.contains("uName")){
        if(name.equals(unamecheck)&&pwd.equals(pwdcheck)){
            return true;


        }
        return false;


    }
}

package com.example.sqlite_with_login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText editEmail,editPassword,editCpassword;
    Button signupBtn;
    TextView txtLogin;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();
        databaseHelper=new DatabaseHelper(this);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=editEmail.getText().toString().trim();
                String password=editPassword.getText().toString().trim();
                String Cpassword=editCpassword.getText().toString().trim();
                boolean b=databaseHelper.insertUsers(email,password);
                if (b){
                    Toast.makeText(Signup.this, "Data inserted ", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Signup.this,MainActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(Signup.this, "Data Not Inserted ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login_i=new Intent(Signup.this, Login.class);
                startActivity(login_i);

            }
        });
    }
    public void init(){
        editEmail=findViewById(R.id.signup_email);
        editPassword=findViewById(R.id.signup_password);
        editCpassword=findViewById(R.id.signup_confirm);
        signupBtn=findViewById(R.id.signup_button);
        txtLogin=findViewById(R.id.loginRedirectText);
    }

}
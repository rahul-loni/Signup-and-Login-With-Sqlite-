package com.example.sqlite_with_login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText editEmail,editPassword;
    Button loginBtn;
    TextView txt_forgot,txt_signup;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        databaseHelper=new DatabaseHelper(this);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=editEmail.getText().toString().trim();
                String password=editPassword.getText().toString().trim();

                if (email.equals("")|| password.equals("")){
                    Toast.makeText(Login.this, "All filed are mandatory ", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkCredential=databaseHelper.checkEmailPassword(email,password);
                    if (checkCredential==true){
                        Toast.makeText(Login.this, "Login Comp", Toast.LENGTH_SHORT).show();
                        Intent loginIntent=new Intent(getApplicationContext(),Home.class);
                        startActivity(loginIntent);
                    }
                }
            }
        });
    }
    public void init(){
        editEmail=findViewById(R.id.login_email);
        editPassword=findViewById(R.id.login_password);
        loginBtn=findViewById(R.id.login_button);
        txt_forgot=findViewById(R.id.forgot);
        txt_signup=findViewById(R.id.logins_signup);
    }
}
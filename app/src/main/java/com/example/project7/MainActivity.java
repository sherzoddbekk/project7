package com.example.project7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEmail = findViewById(R.id.tetx_input_email);
        textInputUsername = findViewById(R.id.tetx_input_username);
        textInputPassword = findViewById(R.id.tetx_input_password);
    }

    private boolean validateEmail(){
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()){
            textInputEmail.setError("Field can't be empty");
            return false;
        }else {
            textInputEmail.setError(null);
            textInputEmail.setErrorEnabled(false);
            return true;
        }
    }
    private  boolean validateUsername(){
        String usernameInput = textInputUsername.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()){

            textInputUsername.setError("Field can't be empty");
            return false;
        }else { if (usernameInput.length() > 15){
            textInputUsername.setError("Username too long");
            return false;
        }else {
            textInputUsername.setError(null);
            return true;
           }
        }
    }

    private boolean validatePassword(){
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()){
            textInputPassword.setError("Field can't be empty");
            return false;
        }else {
            textInputPassword.setError(null);
            textInputPassword.setErrorEnabled(false);
            return true;
        }
    }

    public  void confirmInput(View v){

        if (!validateEmail() | !validateUsername() | !validatePassword()){
            return;
        }
        String input  = "Email: " + textInputEmail.getEditText().getText().toString();
        input += "\n";
        input += "Username: " + textInputUsername.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + textInputPassword.getEditText().getText().toString();

        Toast.makeText(this,input,Toast.LENGTH_LONG).show();
    }
}
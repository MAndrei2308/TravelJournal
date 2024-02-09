package com.example.traveljournal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameEditText = findViewById(R.id.username_edit_text);
        mPasswordEditText = findViewById(R.id.password_edit_text);
        mLoginButton = findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginButton) {
            String username = mUsernameEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();

            // Setăm textul de eroare la null înainte de a verifica autentificarea
            mUsernameEditText.setError(null);
            mPasswordEditText.setError(null);

            if (username.equals("") && password.equals("")) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                // Setăm textul de eroare pentru câmpurile de editare relevante
                if (username.isEmpty()) {
                    mUsernameEditText.setError(getString(R.string.login_error_username));
                }
                if (password.isEmpty()) {
                    mPasswordEditText.setError(getString(R.string.login_error_password));
                }
                if (!username.equals("utilizator") || !password.equals("parola")) {
                    Toast.makeText(this, R.string.login_error_message, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
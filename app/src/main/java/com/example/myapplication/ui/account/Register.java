package com.example.myapplication.ui.account;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class Register extends AppCompatActivity {

    private EditText emailInput, nameInput, dobInput, passwordInput, confirmPasswordInput;
    private Button registerButton;
    private TextView loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views
        emailInput = findViewById(R.id.emailInput);
        nameInput = findViewById(R.id.nameInput);
        dobInput = findViewById(R.id.dobInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.login_prompt);

        // Set click listener for Register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        // Set click listener for Login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to LoginActivity
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }

    // Method to handle user registration logic
    private void registerUser() {
        String email = emailInput.getText().toString().trim();
        String name = nameInput.getText().toString().trim();
        String dob = dobInput.getText().toString().trim();
        String password = passwordInput.getText().toString();
        String confirmPassword = confirmPasswordInput.getText().toString();

        // Validate inputs
        if (TextUtils.isEmpty(email)) {
            emailInput.setError("Email is required");
            return;
        }
        if (TextUtils.isEmpty(name)) {
            nameInput.setError("Name is required");
            return;
        }
        if (TextUtils.isEmpty(dob)) {
            dobInput.setError("Date of Birth is required");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            passwordInput.setError("Password is required");
            return;
        }
        if (TextUtils.isEmpty(confirmPassword)) {
            confirmPasswordInput.setError("Confirm your password");
            return;
        }
        if (!password.equals(confirmPassword)) {
            confirmPasswordInput.setError("Passwords do not match");
            return;
        }

        new AlertDialog.Builder(Register.this)
                .setTitle("Login Failed")
                .setMessage("Register Successful. Logging in to app...")
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("isLoggedIn", true);
                        editor.apply();

                        // Redirect to MainActivity
                        Intent intent = new Intent(Register.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .show();

        // Clear inputs after registration
        emailInput.setText("");
        nameInput.setText("");
        dobInput.setText("");
        passwordInput.setText("");
        confirmPasswordInput.setText("");
    }
}
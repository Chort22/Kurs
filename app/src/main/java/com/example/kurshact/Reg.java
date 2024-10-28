package com.example.kurshact;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Reg extends AppCompatActivity {
    private DbHelper dbHelper;
    private EditText usernameEditText2, passwordEditText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);

        usernameEditText2 = findViewById(R.id.usernameEditText2);
        passwordEditText2 = findViewById(R.id.passwordEditText2);
        Button registerButton = findViewById(R.id.registerButton2);

        dbHelper = new DbHelper(this);
        registerButton.setOnClickListener(v -> {
            String username = usernameEditText2.getText().toString();
            String password = passwordEditText2.getText().toString();
            if (dbHelper.insertUser(username, password)) {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Reg.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

}

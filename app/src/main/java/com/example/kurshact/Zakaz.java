package com.example.kurshact;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Zakaz extends AppCompatActivity {

    EditText name;
    EditText Surname;
    EditText Address;
    EditText Number;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakaz);

        name = findViewById(R.id.editTextFam);
        Surname = findViewById(R.id.editTextText3);

        Number = findViewById(R.id.editTextText5);
        button = findViewById(R.id.buttonzakaz);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInput();
            }
        });
    }

    private void checkInput() {
        String input1 = name.getText().toString().trim();
        String input2 = Surname.getText().toString().trim();
        String input4 = Number.getText().toString().trim();
        if (TextUtils.isEmpty(input1) || TextUtils.isEmpty(input2) || TextUtils.isEmpty(input4)) {
            Toast.makeText(this, "All fields must be filled in", Toast.LENGTH_SHORT).show();

        } else {
            // ��� ���� ���������, ��������� ������ ��������
            Toast.makeText(this, "The order has been accepted for processing", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Zakaz.this, TovarActivity.class);
            startActivity(intent);
        }
    }
}



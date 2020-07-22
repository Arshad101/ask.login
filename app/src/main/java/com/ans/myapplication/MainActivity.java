package com.ans.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Passworrd;
    private TextView Info;
    private Button Login;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText)findViewById(R.id.etName);
        Passworrd = (EditText)findViewById(R.id.etPass);
        Info = (TextView)findViewById(R.id.etat);
        Login=(Button)findViewById(R.id.btnLogin);

        Info.setText("No. of attempts remaining: 3");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Passworrd.getText().toString());
            }
        });



    }
    private void validate(String userName, String userPassword) {
        if ((userName.equals("Admin")) && (userPassword == "1234")) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else {
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));
            if (counter == 0) {
                Login.setEnabled(false);
            }


        }
    }

    }
package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText editText;
Button button;
//TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextTextPersonName);
        button=findViewById(R.id.buton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username=editText.getText().toString();
//                explicit Intent
                Intent i=new Intent(getApplicationContext(),LuckynumberActivity.class);
//                passing the name to the second activity
                i.putExtra("name",Username);
                startActivity(i);
            }
        });
    }
}
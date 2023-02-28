package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckynumberActivity extends AppCompatActivity {
TextView textView;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luckynumber);
        textView=findViewById(R.id.textView2);
        button=findViewById(R.id.button);
        Intent i=getIntent();
        String userName=i.getStringExtra("name");
        Toast.makeText(this, "username is:"+userName, Toast.LENGTH_LONG).show();
//        random number generator
        int randomnum=generateRandomNumber();
        textView.setText(" "+randomnum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName,randomnum);
            }
        });
    }

    public int generateRandomNumber(){
        Random random=new Random();
        int upperLimit=1000;
        int randomnumberGenerated=random.nextInt(upperLimit);
        return randomnumberGenerated;
    }
    public void shareData(String userNAme,int randomNum){
//        Implicit Intents
        Intent i =new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
//        convert int to string
        String number=String.valueOf(randomNum);

        i.putExtra(Intent.EXTRA_SUBJECT,userNAme+" got lucky today !!!!! ");
        i.putExtra(Intent.EXTRA_TEXT,"Lucky number is  "+ number);

        startActivity(Intent.createChooser(i,"Choose a platform"));

    }
}
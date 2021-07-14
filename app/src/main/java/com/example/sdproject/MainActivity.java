package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                Intent intent = new Intent(this , MapsActivity.class);
                startActivity(intent);
                break;

            case R.id.button2:
                Intent intent2 = new Intent(this , ExpActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
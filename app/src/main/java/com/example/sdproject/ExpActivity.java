package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExpActivity extends AppCompatActivity {

    public static int budgetVal;
    public static int tot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.budget:
                Intent intent = new Intent(this , BudgetActivity.class);
                startActivity(intent);
                break;

            case R.id.add:
                Intent intent2 = new Intent(this , AddActivity.class);
                startActivity(intent2);
                break;

            case R.id.analysis:
                Intent intent3 = new Intent(this , MainActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
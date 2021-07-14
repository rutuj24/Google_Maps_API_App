package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BudgetActivity extends AppCompatActivity {

    private EditText enter;
    private Button set;
    private Button reset;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        enter = (EditText)findViewById(R.id.enterBudget);
        textView = (TextView)findViewById(R.id.textView);

        ExpActivity.budgetVal= PrefConfig.loadTotalFromPref(this);

        if (ExpActivity.budgetVal == 0){
            String budg = "NA";
            textView.setText("Budget = "+budg);
        }

        if (ExpActivity.budgetVal != 0){
            textView.setText("Budget = "+ExpActivity.budgetVal);
        }
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.set:
                String budg = enter.getText().toString();
                ExpActivity.budgetVal = Integer.parseInt(budg);
                ExpActivity.tot = Integer.parseInt(budg);
                PrefConfig.saveTotalInPref(getApplicationContext(), ExpActivity.budgetVal);
                PreConfigB.saveTotalInPrefB(getApplicationContext(), ExpActivity.tot);
                textView.setText("Budget = "+ExpActivity.budgetVal);
                enter.setText("");
                break;

            case R.id.reset:
                budg = "NA";
                ExpActivity.budgetVal = 0;
                ExpActivity.tot = 0;
                PrefConfig.saveTotalInPref(getApplicationContext(), ExpActivity.budgetVal);
                PreConfigB.saveTotalInPrefB(getApplicationContext(), ExpActivity.tot);
                textView.setText("Budget = "+budg);
                enter.setText("");
                break;
        }
    }
}
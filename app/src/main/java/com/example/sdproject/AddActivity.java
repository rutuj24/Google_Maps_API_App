package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AddActivity extends AppCompatActivity {

    Spinner spinner;
    EditText ed1;
    Button bAdd ;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ed1 = (EditText) findViewById(R.id.expenseAmount);
        bAdd = (Button)findViewById(R.id.addButton);
        text = (TextView)findViewById(R.id.textView5);

        spinner =(Spinner) findViewById(R.id.spinner);
        String[] mes = {"Food","Transport","Accommodation","Miscellaneous"};
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,mes);
        spinner.setAdapter(ad);

        ExpActivity.tot= PreConfigB.loadTotalFromPrefB(this);
        if (ExpActivity.tot <= 0){
            text.setText("Remaining Budget = NA" );
        }
        else {
            text.setText("Remaining Budget = " + ExpActivity.tot);
        }

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cost = Integer.parseInt(ed1.getText().toString());
                ExpActivity.tot = ExpActivity.tot - cost;
                PreConfigB.saveTotalInPrefB(getApplicationContext(), ExpActivity.tot);
                if (ExpActivity.tot <= 0){
                    text.setText("Remaining Budget = NA" );
                }
                else {
                    text.setText("Remaining Budget = " + ExpActivity.tot);
                }
                ed1.setText("");
                toastMaker(ExpActivity.budgetVal , ExpActivity.tot);
            }
        });

    }

    public void toastMaker(int budget, int total) {
        if (total <= 0){
            Toast.makeText(AddActivity.this , "You have exhausted your budget" , Toast.LENGTH_SHORT).show();
        }
        else if ((budget/10) >= total){
            Toast.makeText(AddActivity.this , "You have used 90% of your budget" , Toast.LENGTH_SHORT).show();
        }
        else if ((budget/2) >= total){
            Toast.makeText(AddActivity.this , "You have used 50% of your budget" , Toast.LENGTH_SHORT).show();
        }
    }
}
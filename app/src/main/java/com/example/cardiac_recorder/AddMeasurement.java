package com.example.cardiac_recorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMeasurement extends AppCompatActivity {
    EditText edit_date,edit_time,edit_sys_pr,edit_dais_pr,edit_heat_rate,edit_comment;
    Button button_save;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_measurement);
        edit_date=findViewById(R.id.edit_date);
        edit_time=findViewById(R.id.edit_time);
        edit_sys_pr=findViewById(R.id.edit_sys_pr);
        edit_dais_pr=findViewById(R.id.edit_dais_pr);
        edit_heat_rate=findViewById(R.id.edit_heat_rate);
        edit_comment=findViewById(R.id.edit_comment);
        button_save=findViewById(R.id.button_save);
        reference= FirebaseDatabase.getInstance().getReference().child("Measurement");
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertMeasurement();
                Intent intent=new Intent(AddMeasurement.this,MainActivity.class);
                startActivity(intent);
            }


        });
    }
    private void insertMeasurement()
    {
        String date,time,comt;
        Integer syspr,diaspr,hrt;
        date=edit_date.getText().toString();
        time=edit_time.getText().toString();
        syspr=Integer.valueOf(edit_sys_pr.getText().toString());
        diaspr=Integer.valueOf(edit_dais_pr.getText().toString());
        hrt=Integer.valueOf(edit_heat_rate.getText().toString());
        comt=edit_comment.getText().toString();

        Measurement measurement=new Measurement(date,time,syspr,diaspr,hrt,comt);
        reference.push().setValue(measurement);
    }
}
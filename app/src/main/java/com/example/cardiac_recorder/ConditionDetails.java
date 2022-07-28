package com.example.cardiac_recorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConditionDetails extends AppCompatActivity {
    Button button_delete,button_edit;
    private DatabaseReference reference;
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition_details);

        Intent intent = getIntent();
        Measurement m = (Measurement) intent.getSerializableExtra("data");


        EditText date, time, sys_pr, dias_pr, hrt_rate, comment;

        date = findViewById(R.id.edit_date);
        time = findViewById(R.id.edit_time);
        sys_pr = findViewById(R.id.edit_sys_pr);
        dias_pr = findViewById(R.id.edit_dias_pr);
        hrt_rate = findViewById(R.id.edit_heart_rate);
        comment = findViewById(R.id.edit_comment);
        button_delete=findViewById(R.id.button_delete);
        button_edit=findViewById(R.id.button_edit);

        date.setText(m.getDate());
        time.setText(m.getTime());
        sys_pr.setText(String.valueOf(m.getSystolicPressure()));
        dias_pr.setText(String.valueOf(m.getDiastolicPressure()));
        hrt_rate.setText(String.valueOf(m.getHeartRate()));
        comment.setText(m.getComment());
        reference= FirebaseDatabase.getInstance().getReference("Measurement");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Measurement mthis = postSnapshot.getValue(Measurement.class);
                    if(m.equals(mthis))
                    {
                        key=postSnapshot.getKey();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.child(key).removeValue();
                Intent newintent=new Intent(ConditionDetails.this,MainActivity.class);
                startActivity(newintent);
            }
        });
        button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reference.child(key).removeValue();
                String cdate,ctime,ccomt;
                Integer csyspr,cdiaspr,chrt;
                cdate=date.getText().toString();
                ctime=time.getText().toString();
                csyspr=Integer.valueOf(sys_pr.getText().toString());
                cdiaspr=Integer.valueOf(dias_pr.getText().toString());
                chrt=Integer.valueOf(hrt_rate.getText().toString());
                ccomt=comment.getText().toString();

                Measurement measurement=new Measurement(cdate,ctime,csyspr,cdiaspr,chrt,ccomt);
                reference.child(key).setValue(measurement);
                Intent newintent=new Intent(ConditionDetails.this,MainActivity.class);
                startActivity(newintent);
            }
        });
    }
}
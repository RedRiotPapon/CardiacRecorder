package com.example.cardiac_recorder;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.audiofx.Visualizer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView measurementlist;
    private Button add_measurement;
    private DatabaseReference reference;
    ArrayList<Measurement> MeasurementList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        measurementlist=findViewById(R.id.measurement);
        reference= FirebaseDatabase.getInstance().getReference("Measurement");
        add_measurement = (Button) findViewById(R.id.add_msr);
        showList adapter=new showList(this);
        adapter.setMeasurementList(MeasurementList);
        measurementlist.setAdapter(adapter);
        measurementlist.setLayoutManager(new LinearLayoutManager(this));
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Measurement m=postSnapshot.getValue(Measurement.class);
                    MeasurementList.add(m);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        add_measurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddMeasurement.class);
                startActivity(intent);
            }
        });


    }

}
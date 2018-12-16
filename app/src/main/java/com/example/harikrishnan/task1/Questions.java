package com.example.harikrishnan.task1;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Questions extends AppCompatActivity {


    TextView trivias,score;
    Button choice_1, choice_2, choice_3, choice_4;
    ProgressBar progressBar;
    FirebaseDatabase database;
    DatabaseReference reference;
    int i=1,scoreValue=0;
    String answer,showName,qNumber;
    QBank data;
    Map<String, String> map;
    int catPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        trivias = findViewById(R.id.question);
        score = findViewById(R.id.score);
        choice_4 = findViewById(R.id.choice4);
        choice_3 = findViewById(R.id.choice3);
        choice_2 = findViewById(R.id.choice2);
        choice_1 = findViewById(R.id.choice1);
        progressBar = findViewById(R.id.progressbar);
        database = FirebaseDatabase.getInstance();
        data = new QBank();

        Bundle bundle = getIntent().getExtras();
        catPosition = bundle.getInt("catNumber");

        getData();


    }

    private void getData() {





        if (catPosition == 0){
            showName = "Breakingbad";
        }
        else if (catPosition == 1) {
            showName = "Friends";
        }
        else if (catPosition == 2){
            showName = "Gameofthrones";
        }
        else if (catPosition == 3){
            showName = "Himym";
        }

        if (i == 1){
            qNumber = "one";

        }
        else if (i == 2){
            qNumber = "two";
        }
        else if (i == 3){
            qNumber = "three";

        }
        else if (i == 4){

            qNumber = "four";
        }
        else if (i == 5){

            qNumber = "five";
        }
        else if (i==6){
            Intent intent = new Intent(Questions.this,Result.class);
            intent.putExtra("score",scoreValue);
            startActivity(intent);

        }

        reference = database.getReference().child(showName).child(qNumber);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                progressBar.setVisibility(View.INVISIBLE);
                map = (Map)dataSnapshot.getValue();
                String c4 = map.get("c4");
                String c3 = map.get("c3");
                String c2 = map.get("c2");
                String c1 = map.get("c1");
                String ans = map.get("ans");
                String name = map.get("Name");

                data = new QBank(name,c1,c2,c3,c4,ans);

                printDataAndClickEvent();



            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


                printDataAndClickEvent();

            }
        });




    }

    private void printDataAndClickEvent() {
        trivias.setText(data.getName());
        choice_1.setText(data.getC1());
        choice_2.setText(data.getC2());
        choice_3.setText(data.getC3());
        choice_4.setText(data.getC4());
        score.setText(String.valueOf(scoreValue));
        answer = data.getCorrect();

        choice_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c1 = choice_1.getText().toString().trim();
                if (c1.equals(answer)){
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    i++;
                    scoreValue = scoreValue + 10;
                    getData();
                }
                else{
                    Toast.makeText(getApplicationContext(),"wrong",Toast.LENGTH_SHORT).show();
                    i++;
                    getData();

                }

            }
        });
        choice_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c2 = choice_2.getText().toString().trim();
                if (c2.equals(answer)){
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    i++;
                    scoreValue = scoreValue + 10;

                    getData();
                }
                else{
                    Toast.makeText(getApplicationContext(),"wrong",Toast.LENGTH_SHORT).show();
                    i++;
                    getData();

                }

            }
        }); choice_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c3 = choice_3.getText().toString().trim();
                if (c3.equals(answer)){
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    i++;
                    scoreValue = scoreValue + 10;

                    getData();
                }
                else{
                    Toast.makeText(getApplicationContext(),"wrong",Toast.LENGTH_SHORT).show();
                    i++;
                    getData();

                }

            }
        }); choice_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c4 = choice_4.getText().toString().trim();
                if (c4.equals(answer)){
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    i++;
                    scoreValue = scoreValue + 10;

                    getData();
                }
                else{
                    Toast.makeText(getApplicationContext(),"wrong",Toast.LENGTH_SHORT).show();
                    i++;
                    getData();

                }

            }
        });


    }


}








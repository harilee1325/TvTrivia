package com.example.harikrishnan.task1;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Questions extends AppCompatActivity {



     TextView qN,highScore,singleScore;
     Button choice_1,choice_2,choice_3,choice_4;

     PojoQuestion pojoQuestion;
     FirebaseDatabase database = FirebaseDatabase.getInstance("https://tvtrivia-9d35d.firebaseio.com/");
    DatabaseReference reference = database.getReference("01");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        qN = findViewById(R.id.question);
        highScore = findViewById(R.id.highscore);
        singleScore = findViewById(R.id.score);
        choice_1 = findViewById(R.id.choice1);
        choice_2 = findViewById(R.id.choice2);
        choice_3 = findViewById(R.id.choice3);
        choice_4 = findViewById(R.id.choice4);


        settingQuestion();

    }

    private void settingQuestion() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot children : dataSnapshot.getChildren()) {



                    String question = children.child("Q").getValue().toString();
                    String c1 = children.child("Choice1").getValue().toString();
                    String c2 = children.child("Choice2").getValue().toString();
                    String c3 = children.child("Choice3").getValue().toString();
                    String c4 = children.child("Choice4").getValue().toString();
                    String ans = children.child("Answer").getValue().toString();




                  pojoQuestion = new PojoQuestion(question,c1,c2,c3,c4,ans);

                }

                qN.setText(pojoQuestion.getQname());
                choice_1.setText(pojoQuestion.getChoice_1());
                choice_2.setText(pojoQuestion.getChoice_2());
                choice_3.setText(pojoQuestion.getChoice_3());
                choice_4.setText(pojoQuestion.getChoice_4());



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}

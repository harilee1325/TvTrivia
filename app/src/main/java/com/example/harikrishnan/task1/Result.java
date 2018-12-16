package com.example.harikrishnan.task1;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;

import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Result extends AppCompatActivity {

    CardView cardView;
    GifImageView resultImageHolder;
    TextView resultDisplay;

    int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        cardView = findViewById(R.id.cardview);
        resultImageHolder = findViewById(R.id.resultimage);
        resultDisplay = findViewById(R.id.finalscore);


        Bundle bundle = getIntent().getExtras();
        finalScore = bundle.getInt("score");

        if (finalScore == 50){
            resultImageHolder.setImageResource(R.drawable.good);
            resultDisplay.setText(String.valueOf(finalScore));
        }
        else if (finalScore < 50 && finalScore >= 30){

            resultImageHolder.setImageResource(R.drawable.average);
            resultDisplay.setText(String.valueOf(finalScore));
        }
        else if (finalScore <30){

            resultImageHolder.setImageResource(R.drawable.notbad);
            resultDisplay.setText(String.valueOf(finalScore));
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Result.this,MainActivity.class);
        startActivity(intent);
    }
}

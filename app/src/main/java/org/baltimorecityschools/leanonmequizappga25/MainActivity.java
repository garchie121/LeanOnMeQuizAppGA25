package org.baltimorecityschools.leanonmequizappga25;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
// 1.  all variables, including UI variables

    TextView q1TV;
    String msg;
    Button trueBTN, falseBTN, nextBTN;
    String qMsg;
    int score;
            int duration = Toast.LENGTH_SHORT;
    Toast myToast;
    Context myToastContext = MainActivity.this;
    Question q1;
    Question q2;
    Question q3;
    Question q4;
    Question q5;
    int currentIndex;

    Question currentQ;
    Question[] questions;
    boolean userResponse;
    ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // 2. inflate your UI elements and initialize all vars
        q1TV = (TextView) findViewById(R.id.q1TV);
        trueBTN = (Button) findViewById(R.id.trueBTN);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        qMsg = " ";
        score = 0;
        myImageView = (ImageView) findViewById(R.id.myImageView);

        q1 = new Question("Lean on Me was filed in New York in 1993?", false, R.drawable.leanonmecover);
        q2 = new Question(" Morgan Freeman was the main Character of the movie?", true,R.drawable.morganfreeman);
        q3 = new Question("Ms Barrett wanted the Mayor to fire Mr. Clark in the Movie?", true,R.drawable.meanlady);
        q4 = new Question("The high School name was Patterson High School?", false, R.drawable.studentquit);
        q5 = new Question("The state wanted to take control of the school, if test scores did not improve?", true,R.drawable.statetakeover);
        questions = new Question[]{q1, q2, q3, q4, q5};
        currentIndex = 0;
        currentQ = questions[currentIndex];




        nextBTN = (Button) findViewById(R.id.NextBTN);
        msg =" ";
        // 3. do what your app needs to do!

        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userResponse = true;
                if (currentQ.isThisCorrect(userResponse)) {
                    qMsg = "correct";
                    score++;
                } else {
                    qMsg = "incorrect";
                }
                myToast = Toast.makeText(myToastContext, qMsg, duration);
                myToast.show();

            }
        });
        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userResponse = false;
                if (currentQ.isThisCorrect(userResponse)) {
                    qMsg = "correct";
                    score++;
                } else {
                    qMsg = "incorrect";
                }
                myToast = Toast.makeText(myToastContext, qMsg, duration);
                myToast.show();


            }
        });

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex < questions.length - 1) {
                    currentIndex++;
                    currentQ = questions[currentIndex];
                    myImageView.setImageResource(currentQ.getImageid());
                    q1TV.setText(currentQ.getqPrompt());
                } else {
                    Intent myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    myIntent.putExtra("score", score);
                    startActivity(myIntent);
                }


            }


        });



    }
}

package org.baltimorecityschools.leanonmequizappga25;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {


    // 1. declare  vars
    int score;
    TextView scoreTV;
    Intent incomingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // 2. inflate UI elems and initialize vars
        scoreTV = (TextView) findViewById(R.id.scoreTV);
        score = 0;
        // getting value from intent and showing on screen
        incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("score", 0);
        scoreTV.setText(score+ "");

    }

    public void composeEmail(String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TEXT, body);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
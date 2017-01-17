package com.albertlardizabal.androidjokelibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView textView = (TextView)findViewById(R.id.jokeTextView);

        String joke = getIntent().getStringExtra("joke");
        textView.setText(joke);
    }
}

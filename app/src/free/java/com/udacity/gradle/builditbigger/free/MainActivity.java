package com.udacity.gradle.builditbigger.free;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.albertlardizabal.JokeCenter;
import com.albertlardizabal.androidjokelibrary.JokeActivity;
import com.albertlardizabal.androidjokelibrary.JokeComposer;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.JokeResponse;
import com.udacity.gradle.builditbigger.R;

public class MainActivity extends AppCompatActivity implements JokeResponse {

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showJokeToast(View view) {
        JokeCenter jokeCenter = new JokeCenter();
        String joke = jokeCenter.getJoke();

        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
    }

    public void showLocalJokeActivity(View view) {
        JokeComposer jokeComposer = new JokeComposer();
        String joke = jokeComposer.grabJoke();

        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra("joke", joke);
        startActivity(intent);
    }

    public void showRemoteJokeActivity(View view) {
        EndpointsAsyncTask endPointsAsyncTask = new EndpointsAsyncTask();
        endPointsAsyncTask.delegate = this;
        endPointsAsyncTask.execute(new Pair<Context, String>(this, "joke"));
    }

    @Override
    public void retrievedJoke(String output) {

    }
}

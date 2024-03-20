package com.chhabinath.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Intent intentTicTacToe = new Intent(WelcomeScreenActivity.this,MainActivity.class);
        new Handler().postDelayed(() -> {
            startActivity(intentTicTacToe);
            finish();
        },2200);
    }
}
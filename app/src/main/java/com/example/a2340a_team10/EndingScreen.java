package com.example.a2340a_team10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class EndingScreen extends AppCompatActivity {

    private Button mBtnRestart;
    private Button mBtnExit;
    private ListView lvLeaderboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_screen);
        mBtnRestart = (Button) findViewById(R.id.restartButton);
        mBtnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Restart the game
            }
        });

        mBtnExit = (Button) findViewById(R.id.exitButton);
        mBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Terminate the program
            }
        });

        lvLeaderboard = (ListView) findViewById(R.id.leaderboard);
    }
}
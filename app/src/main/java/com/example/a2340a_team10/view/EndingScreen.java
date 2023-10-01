package com.example.a2340a_team10.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2340a_team10.R;
import com.example.a2340a_team10.model.LeaderboardModel;
import com.example.a2340a_team10.viewmodel.LB_RecyclerViewAdapter;
import com.example.a2340a_team10.viewmodel.LeaderboardViewModel;

public class EndingScreen extends AppCompatActivity {

    private Button mBtnRestart;
    private Button mBtnExit;
    private RecyclerView leaderboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_screen);
        mBtnRestart = (Button) findViewById(R.id.restartButton);
        mBtnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restart = new Intent(EndingScreen.this, WelcomeScreen.class);
                startActivity(restart);
                finish();
            }
        });

        mBtnExit = (Button) findViewById(R.id.exitButton);
        mBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        leaderboard = (RecyclerView) findViewById(R.id.leaderboard);
        LeaderboardViewModel.addScore();
        LB_RecyclerViewAdapter adapter = new LB_RecyclerViewAdapter(this, LeaderboardModel.getInstance().getPlayRecords());
        leaderboard.setAdapter(adapter);
        leaderboard.setLayoutManager(new LinearLayoutManager(this));


    }
}

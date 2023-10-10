package com.example.a2340a_team10.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2340a_team10.R;
import com.example.a2340a_team10.model.Attempt;
import com.example.a2340a_team10.model.LeaderboardModel;
import com.example.a2340a_team10.model.Player;
import com.example.a2340a_team10.viewmodel.mRecyclerViewAdapter;
import com.example.a2340a_team10.viewmodel.LeaderboardViewModel;

import java.util.ArrayList;

public class EndingScreen extends AppCompatActivity {

    private Button mBtnRestart;
    private Button mBtnExit;
    private RecyclerView leaderboard;
    private RecyclerView latestAttempt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_screen);
        mBtnRestart = findViewById(R.id.restartButton);
        mBtnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restart = new Intent(EndingScreen.this, WelcomeScreen.class);
                startActivity(restart);
                Player.clear();
                finish();
            }
        });

        mBtnExit = findViewById(R.id.exitButton);
        mBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        latestAttempt = findViewById(R.id.boardLatestAttempt);
        leaderboard = findViewById(R.id.leaderboard);

        //generate the leaderboard by adding the current attempt to
        //attemptHistory; also, saving the current attempt for an
        //individual display.
        Attempt newAttempt = LeaderboardViewModel.addAttempt();
        ArrayList<Attempt> newAttempts = new ArrayList<>();
        newAttempts.add(newAttempt);

        mRecyclerViewAdapter adapterLast = new mRecyclerViewAdapter(this, newAttempts, 1, false);
        latestAttempt.setAdapter(adapterLast);
        latestAttempt.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerViewAdapter adapterBoard = new mRecyclerViewAdapter(this, LeaderboardModel.getInstance().getAttemptHistory());
        leaderboard.setAdapter(adapterBoard);
        leaderboard.setLayoutManager(new LinearLayoutManager(this));



    }
}

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
import com.example.a2340a_team10.viewmodel.AttemptListContainer;
import com.example.a2340a_team10.viewmodel.LeaderboardViewModel;

import java.util.ArrayList;

public class EndingScreen extends AppCompatActivity {

    private Button mBtnRestart;
    private Button mBtnExit;
    private RecyclerView leaderboard;
    private RecyclerView boardLatestAttempt;

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


        boardLatestAttempt = findViewById(R.id.boardLatestAttempt);
        leaderboard = findViewById(R.id.leaderboard);

        // generate leaderboard by adding the current attempt to attemptHistory;
        // save the current attempt for individual display.
        LeaderboardViewModel.addAttempt();
        ArrayList<Attempt> newAttempts = new ArrayList<>();
        newAttempts.add(LeaderboardModel.getInstance().getLastestAttempt());

        AttemptListContainer latestAttempt = new AttemptListContainer(this, newAttempts, 1, false);
        this.boardLatestAttempt.setAdapter(latestAttempt);
        this.boardLatestAttempt.setLayoutManager(new LinearLayoutManager(this));

        AttemptListContainer LeaderBoard = new AttemptListContainer(this,
                LeaderboardModel.getInstance().getAttemptHistory());
        leaderboard.setAdapter(LeaderBoard);
        leaderboard.setLayoutManager(new LinearLayoutManager(this));
    }
}

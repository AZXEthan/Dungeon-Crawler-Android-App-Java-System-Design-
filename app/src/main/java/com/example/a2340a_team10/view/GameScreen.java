package com.example.a2340a_team10.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.a2340a_team10.R;
import com.example.a2340a_team10.model.*;
import com.example.a2340a_team10.viewmodel.PlayerView;

public class GameScreen extends AppCompatActivity {
    private Player hero;
    private PlayerView gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        hero = Player.getPlayer();
        gameViewModel = new ViewModelProvider(this).get(PlayerView.class);
        TextView scoreTextView = findViewById(R.id.scoreTextView);

        // Observe the scoreLiveData to update the score in real-time
        gameViewModel.getScoreLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer score) {
                // Update the score TextView
                scoreTextView.setText("Score: " + score);
            }
        });

        // Display player name
        TextView playerNameTextView = findViewById(R.id.playerNameTextView);
        playerNameTextView.setText(String.format("Name: %s", hero.getName()));

        // Display difficulty
        TextView chosenDifficulty = findViewById(R.id.difficultyTextView);
        chosenDifficulty.setText(String.format("Difficulty: %s", hero.getDifficulty()));

        // Get or display Player
        ImageView avatar = (ImageView) findViewById(R.id.avatarImage);
        avatar.setBackgroundResource(hero.getCharacterChoice());
        AnimationDrawable idleAvatar = (AnimationDrawable) avatar.getBackground();
        idleAvatar.start();


        // Display starting health
        LinearLayout health = findViewById(R.id.healthShow);
        health.setVisibility(View.VISIBLE);

        for (int i = 0; i < hero.getHealth(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.ui_heart_full);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            health.addView(imageView);
        }

        // Handle navigation to the ending screen (temporary button)
        Button nextScreenButton = findViewById(R.id.endGameButton);
        nextScreenButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Navigate to the ending screen (replace with actual navigation code)
                Intent intent = new Intent(GameScreen.this, EndingScreen.class);
                startActivity(intent);
                // finish();  // Optional: Close this activity if needed
            }
        });
        Button goToSecondRoomButton = findViewById(R.id.goToSecondRoomButton);

        goToSecondRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the 'SecondRoom' screen
                Intent intent = new Intent(GameScreen.this, SecondRoom.class);
                startActivity(intent);
            }
        });
        Button goToThirdRoomButton = findViewById(R.id.goToThirdRoomButton);

        goToThirdRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the 'SecondRoom' screen
                Intent intent = new Intent(GameScreen.this, ThirdRoom.class);
                startActivity(intent);
            }
        });
    }
}
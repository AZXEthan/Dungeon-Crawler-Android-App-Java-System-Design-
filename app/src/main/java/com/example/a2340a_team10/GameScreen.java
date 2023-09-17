package com.example.a2340a_team10;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GameScreen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        // we need to pass it from InitialConfiguration
        String playerName = getIntent().getStringExtra("playerName");
        String difficulty = getIntent().getStringExtra("difficulty");
        int startingHealth = getIntent().getIntExtra("startingHealth", 0);
        int choice = getIntent().getIntExtra("characterChoice", 1);

        // Display player name
        TextView playerNameTextView = findViewById(R.id.playerNameTextView);
        playerNameTextView.setText(String.format("Name: %s", playerName));

        // Display difficulty
        TextView chosenDifficulty = findViewById(R.id.difficultyTextView);
        chosenDifficulty.setText(String.format("Difficulty: %s", difficulty));

        // Display character
        ImageView avatar = (ImageView) findViewById(R.id.avatarImage);
        avatar.setBackgroundResource(choice);
        AnimationDrawable idleAvatar = (AnimationDrawable) avatar.getBackground();
        idleAvatar.start();

        // Display starting health
        LinearLayout health = findViewById(R.id.healthshow);
        health.removeAllViews();
        health.setVisibility(View.VISIBLE);

        for (int i = 0; i < startingHealth; i++) {
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
                // Intent endingScreenIntent = new Intent(GameActivity.this, EndingScreen.class);
                // startActivity(endingScreenIntent);
                // finish();  // Optional: Close this activity if needed
            }
        });
    }
}
package com.example.a2340a_team10.view;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;

import com.example.a2340a_team10.R;
import com.example.a2340a_team10.model.Player;
import com.example.a2340a_team10.viewmodel.PlayerView;

public class SecondRoom extends AppCompatActivity {

    private PlayerView gameViewModel; // Declare an instance of GameViewModel
    private Player hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_room);

        // Initialize the GameViewModel
        gameViewModel = new ViewModelProvider(this).get(PlayerView.class);

        hero = Player.getPlayer();

        ImageView avatar = (ImageView) findViewById(R.id.avatarImage);
        avatar.setBackgroundResource(hero.getCharacterChoice());
        AnimationDrawable idleAvatar = (AnimationDrawable) avatar.getBackground();
        idleAvatar.start();

        Button goToFirstRoomButton = findViewById(R.id.goToFirstRoomButton);
        // Add a TextView for displaying the score
        TextView scoreTextView = findViewById(R.id.scoreTextView);

        // Observe the scoreLiveData to update the score in real-time
        gameViewModel.getScoreLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer score) {
                // Update the score TextView
                scoreTextView.setText("Score: " + score);
            }
        });

        goToFirstRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the 'GameScreen' screen
                Intent intent = new Intent(SecondRoom.this, GameScreen.class);
                startActivity(intent);
            }
        });

        Button goToThirdRoomButton = findViewById(R.id.goToThirdRoomButton);

        goToThirdRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the 'ThirdRoom' screen
                Intent intent = new Intent(SecondRoom.this, ThirdRoom.class);
                startActivity(intent);
            }
        });
    }
}

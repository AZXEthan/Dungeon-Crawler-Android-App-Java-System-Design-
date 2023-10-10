package com.example.a2340a_team10.view;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.a2340a_team10.R;
import com.example.a2340a_team10.model.Player;
import com.example.a2340a_team10.viewmodel.PlayerView;

public class ThirdRoom extends AppCompatActivity {
    private Player hero;
    private PlayerView gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_room);

        hero = Player.getPlayer();

        ImageView avatar = (ImageView) findViewById(R.id.avatarImage);
        avatar.setBackgroundResource(hero.getCharacterChoice());
        AnimationDrawable idleAvatar = (AnimationDrawable) avatar.getBackground();
        idleAvatar.start();
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

        Button goToFirstRoomButton = findViewById(R.id.goToFirstRoomButton);

        goToFirstRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the 'SecondRoom' screen
                Intent intent = new Intent(ThirdRoom.this, GameScreen.class);
                startActivity(intent);
            }
        });
        Button goToSecondRoomButton = findViewById(R.id.goToSecondRoomButton);

        goToSecondRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the 'SecondRoom' screen
                Intent intent = new Intent(ThirdRoom.this, SecondRoom.class);
                startActivity(intent);
            }
        });

        // If you need to reference the ImageView programmatically
        //ImageView backgroundImage = findViewById(R.id.backgroundImage);
        // You can perform actions on the backgroundImage here.
    }
}

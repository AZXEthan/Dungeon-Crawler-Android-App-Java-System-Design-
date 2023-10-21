package com.example.a2340a_team10.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;

import com.example.a2340a_team10.R;
import com.example.a2340a_team10.model.KeyAction;
import com.example.a2340a_team10.model.MoveDownAction;
import com.example.a2340a_team10.model.MoveLeftAction;
import com.example.a2340a_team10.model.MoveRightAction;
import com.example.a2340a_team10.model.MoveUpAction;
import com.example.a2340a_team10.model.Player;
import com.example.a2340a_team10.viewmodel.PlayerView;
import com.example.a2340a_team10.model.Obstacle;
import java.util.Arrays;
import java.util.List;

public class SecondRoom extends AppCompatActivity {

    private PlayerView gameViewModel; // Declare an instance of GameViewModel
    private Player hero;
    private int playerX;
    private int playerY;
    private ImageView door;
    private int screenWidth;
    private int screenHeight;
    private ImageView avatar;

    private TextView playerNameTextView;
    private TextView chosenDifficulty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_room);

        ImageView backgroundImage = findViewById(R.id.backgroundImage);
        RelativeLayout gridView = findViewById(R.id.gridLayout);
        door = findViewById(R.id.door);

        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;

        // Calculate the number of grid lines you want horizontally and vertically
        int numHorizontalLines = 5; // Change this to the desired number
        int numVerticalLines = 5;   // Change this to the desired number

        // Calculate the width and height of each grid cell
        int cellWidth = backgroundImage.getWidth() / numHorizontalLines;
        int cellHeight = backgroundImage.getHeight() / numVerticalLines;

        // Draw horizontal grid lines
        for (int i = 1; i < numHorizontalLines; i++) {
            View line = new View(this);
            line.setBackgroundColor(Color.BLACK); // Change the color as needed
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = 0;
            params.topMargin = i * cellHeight;
            line.setLayoutParams(params);
            gridView.addView(line);
        }

        // Draw vertical grid lines
        for (int i = 1; i < numVerticalLines; i++) {
            View line = new View(this);
            line.setBackgroundColor(Color.BLACK); // Change the color as needed
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    1, RelativeLayout.LayoutParams.MATCH_PARENT);
            params.leftMargin = i * cellWidth;
            params.topMargin = 0;
            line.setLayoutParams(params);
            gridView.addView(line);
        }

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
        playerNameTextView = findViewById(R.id.playerNameTextView);
        playerNameTextView.setText(String.format("Name: %s", hero.getName()));

        // Display difficulty
        chosenDifficulty = findViewById(R.id.difficultyTextView);
        chosenDifficulty.setText(String.format("Difficulty: %s", hero.getDifficulty()));
        //chosenDifficulty.setText(String.format("Difficulty: %s", screenHeight));

        // Get or display Player
        avatar = findViewById(R.id.avatarImage);
        avatar.setBackgroundResource(hero.getCharacterChoice());
        AnimationDrawable idleAvatar = (AnimationDrawable) avatar.getBackground();
        idleAvatar.start();

        // Get the x and y coordinates of the ImageView
        int[] location = new int[2];
        avatar.getLocationOnScreen(location);

        playerX = location[0]; // x coordinate
        playerY = location[1]; // y coordinate



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
                Intent intent = new Intent(SecondRoom.this, EndingScreen.class);
                startActivity(intent);
                finish();
            }
        });


    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        KeyAction keyAction = null;
        int[] positions = new int[2];
        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_LEFT:
            keyAction = new MoveLeftAction();
            break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
            keyAction = new MoveRightAction();
            break;
        case KeyEvent.KEYCODE_DPAD_UP:
            keyAction = new MoveUpAction();
            break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
            keyAction = new MoveDownAction();
            break;
        default:
            break;
        }

        if (keyAction != null) {
            positions = keyAction.performAction(playerX, playerY);
        }
        Boolean inBoundary = gameViewModel.inBoundary(screenWidth, screenHeight, positions);
        if (inBoundary) {
            playerX = positions[0];
            playerY = positions[1];
        }
        avatar.setX(playerX);
        avatar.setY(playerY);
        if (gameViewModel.jump(playerX, playerY, 1)) {
            Intent intent = new Intent(SecondRoom.this, ThirdRoom.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

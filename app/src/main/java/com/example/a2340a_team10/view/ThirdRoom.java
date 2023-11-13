package com.example.a2340a_team10.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.a2340a_team10.R;
import com.example.a2340a_team10.model.*;
import com.example.a2340a_team10.viewmodel.EnemyMove;
import com.example.a2340a_team10.viewmodel.PlayerView;
import java.util.Arrays;

public class ThirdRoom extends AppCompatActivity {
    private Player hero;
    private PlayerView playerView;
    private ImageView door;
    private ImageView avatar;
    private TextView playerNameTextView;
    private TextView chosenDifficulty;
    private MoveKeyActionFactory moveKeyActionFactory = new MoveKeyActionFactory();
    private Obstacle obstacle1 = new Obstacle(520, 780, 450, 380);
    private Obstacle obstacle2 = new Obstacle(2020, 780, 450, 380);
    private ScreenSetup screenSetup = new ScreenSetup(Arrays.asList(obstacle1, obstacle2));
    private ImageView ogre;
    private ImageView necromancer;
    private Enemy ogreEnemy;
    private Enemy necromancerEnemy;
    private EnemyMove necromancerMove;
    private int necromancerIP = 1;
    private int ogreIP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Player.getPlayer().removeAllObservers();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_room);

        ImageView backgroundImage = findViewById(R.id.backgroundImage);
        RelativeLayout gridView = findViewById(R.id.gridLayout);

        door = findViewById(R.id.door);
        screenSetup.setScreenWidth(getResources().getDisplayMetrics().widthPixels);
        screenSetup.setScreenHeight(getResources().getDisplayMetrics().heightPixels);

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
        playerView = new ViewModelProvider(this).get(PlayerView.class);
        TextView scoreTextView = findViewById(R.id.scoreTextView);

        // Observe the scoreLiveData to update the score in real-time
        playerView.getScoreLiveData().observe(this, new Observer<Integer>() {
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

        // Get or display Player
        avatar = findViewById(R.id.avatarImage);
        avatar.setBackgroundResource(hero.getCharacterChoice());
        AnimationDrawable idleAvatar = (AnimationDrawable) avatar.getBackground();
        idleAvatar.start();

        ogre = findViewById(R.id.ogre);
        AnimationDrawable idleImp = (AnimationDrawable) ogre.getBackground();
        idleImp.start();

        necromancer = findViewById(R.id.necromancer);
        AnimationDrawable idleMuddy = (AnimationDrawable) necromancer.getBackground();
        idleMuddy.start();

        EnemyFactory ogreFactory = new OrcFactory();
        EnemyFactory necromancerFactory = new NecromancerFactory();
        ogreEnemy = ogreFactory.spawnEnemy();
        necromancerEnemy = necromancerFactory.spawnEnemy();
        Player.getPlayer().addObserver(ogreEnemy);
        Player.getPlayer().addObserver(necromancerEnemy);

        int[] necromancerP = new int[2];
        necromancer.getLocationOnScreen(necromancerP);
        necromancerMove = new EnemyMove(necromancerP);

        int[] location = new int[2];
        avatar.getLocationOnScreen(location);

        playerView.setPos(location); // x, y coordinates

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

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        KeyAction keyAction = moveKeyActionFactory.createKeyAction(keyCode);
        playerView.movePlayer(screenSetup, keyAction);
        avatar.setX(playerView.getPos()[0]);
        avatar.setY(playerView.getPos()[1]);

        if (playerView.jump(playerView.getPos()[0], playerView.getPos()[1], 1)) {
            Intent intent = new Intent(ThirdRoom.this, EndingScreen.class);
            startActivity(intent);
            finish();
        }
        if (necromancerIP == 1) {
            necromancer.setY(600);
            necromancer.setX(1000);
            int[] necromancerP = new int[2];
            necromancer.getLocationOnScreen(necromancerP);
            necromancerMove = new EnemyMove(necromancerP);
            necromancerIP = 0;
        }
        int[] necromancerP = necromancerMove.move();
        necromancer.setX(necromancerP[0]);
        necromancer.setY(necromancerP[1]);

        if (ogreIP == 1) {
            int[] ogreP = new int[2];
            ogre.getLocationOnScreen(ogreP);
            ogreEnemy.updatePosition(ogreP[0], ogreP[1] - 100);
            ogreIP = 0;
        }

        necromancerEnemy.updatePosition(necromancerP[0], necromancerP[1]);
        Player.getPlayer().updatePosition(playerView.getPos()[0], playerView.getPos()[1], true);

        // Display updated health
        LinearLayout health = findViewById(R.id.healthShow);
        health.setVisibility(View.VISIBLE);
        health.removeAllViews();
        for (int i = 0; i < hero.getHealth(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.ui_heart_full);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            health.addView(imageView);
        }

        if (hero.getHealth() == 0) {
            Intent intent = new Intent(ThirdRoom.this, EndingScreen.class);
            startActivity(intent);
        }

        return super.onKeyDown(keyCode, event);
    }
}

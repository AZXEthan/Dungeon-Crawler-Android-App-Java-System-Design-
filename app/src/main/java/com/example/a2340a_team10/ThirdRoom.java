package com.example.a2340a_team10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_room);


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

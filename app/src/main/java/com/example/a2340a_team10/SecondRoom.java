package com.example.a2340a_team10;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class SecondRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_room);


        Button goToSecondRoomButton = findViewById(R.id.goToFirstRoomButton);

        goToSecondRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the 'SecondRoom' screen
                Intent intent = new Intent(SecondRoom.this, GameScreen.class);
                startActivity(intent);
            }
        });
        Button goToThirdRoomButton = findViewById(R.id.goToThirdRoomButton);

        goToThirdRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the 'SecondRoom' screen
                Intent intent = new Intent(SecondRoom.this, ThirdRoom.class);
                startActivity(intent);
            }
        });
        // If you need to reference the ImageView programmatically
        //ImageView backgroundImage = findViewById(R.id.backgroundImage);
        // You can perform actions on the backgroundImage here.
    }
}

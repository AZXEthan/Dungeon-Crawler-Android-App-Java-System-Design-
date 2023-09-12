package com.example.a2340a_team10;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.LinearLayout;
public class IniConActivity extends AppCompatActivity {

    private TextView selectedChoiceTextView;
    private RadioButton radioEasy, radioNormal, radioHard;
    //below for the name input
    private EditText editTextName;
    private Button buttonSubmit;
    private TextView textViewResult;

    private LinearLayout imageContainer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicon_activity);

        Button startBtn = findViewById(R.id.startButton);

        RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
        radioEasy = findViewById(R.id.radioEasy);
        radioNormal = findViewById(R.id.radioMedium);
        radioHard = findViewById(R.id.radioHard);
        selectedChoiceTextView = findViewById(R.id.selectDifficulty);

        buttonSubmit = findViewById(R.id.buttonSubmit);
        editTextName = findViewById(R.id.editTextName);
        textViewResult = findViewById(R.id.textViewResult);

        imageContainer = findViewById(R.id.imageContainer);

        int checkedRadioButtonId = difficultyRadioGroup.getCheckedRadioButtonId();
        difficultyRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String selectedChoice = "";
                if (checkedId == R.id.radioEasy) {
                    imageContainer.removeAllViews();
                    selectedChoice = "Easy";
                    showImages(5);
                } else if (checkedId == R.id.radioMedium) {
                    imageContainer.removeAllViews();
                    selectedChoice = "Medium";
                    showImages(4);
                } else if (checkedId == R.id.radioHard) {
                    imageContainer.removeAllViews();
                    selectedChoice = "Hard";
                    showImages(3);
                }

                selectedChoiceTextView.setText("Difficulty: " + selectedChoice);
            }
        });



        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = editTextName.getText().toString().trim();

                if (!inputName.isEmpty()) {
                    // Name is not empty, display it
                    textViewResult.setText("Hello, " + inputName + "!");
                } else {
                    // Name is empty or contains only whitespace
                    textViewResult.setText("Invalid name.");
                }
            }
        });


        // Set difficulty based on difficulty checked
        startBtn.setOnClickListener(v -> {
            //RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
            //double difficulty = 1;
            //selectedChoiceTextView = findViewById(R.id.selectDifficulty);
            //String selectedChoice = "";
            //int checkedRadioButtonId = difficultyRadioGroup.getCheckedRadioButtonId();

            //selectedChoiceTextView.setText("Selected choice: " + selectedChoice);
            finish();
        });
    }
    private void showImages(int count) {
        imageContainer.setVisibility(View.VISIBLE);

        for (int i = 0; i < count; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.ui_heart_full); // Replace with your image resource
            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            imageContainer.addView(imageView);
        }
    }
}

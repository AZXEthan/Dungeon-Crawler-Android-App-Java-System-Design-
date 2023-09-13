package com.example.a2340a_team10;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.LinearLayout;
public class InitialConfiguration extends AppCompatActivity {

    private TextView selectedChoiceTextView;
    private EditText inputName;

    private RadioGroup difficultySelect, avatarSelect;
    private Button buttonSubmit;
    private TextView textViewResult;
    private LinearLayout diff_healthbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_configuration);

        Button startBtn = findViewById(R.id.startButton);

        difficultySelect= findViewById(R.id.difficultyRadioGroup);

        selectedChoiceTextView = findViewById(R.id.selectDifficulty);

        avatarSelect = findViewById(R.id.avatar_select);

        buttonSubmit = findViewById(R.id.buttonSubmit);
        inputName = findViewById(R.id.inputName);
        textViewResult = findViewById(R.id.greeting);

        diff_healthbar = findViewById(R.id.diff_healthbar);

        difficultySelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String selectedChoice = "";
                if (checkedId == R.id.radioEasy) {
                    diff_healthbar.removeAllViews();
                    selectedChoice = "Easy";
                    displayHealth(5);
                } else if (checkedId == R.id.radioMedium) {
                    diff_healthbar.removeAllViews();
                    selectedChoice = "Medium";
                    displayHealth(4);
                } else if (checkedId == R.id.radioHard) {
                    diff_healthbar.removeAllViews();
                    selectedChoice = "Hard";
                    displayHealth(3);
                }
                selectedChoiceTextView.setText(String.format("Difficulty: %s", selectedChoice));
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myName = inputName.getText().toString().trim();

                if (!myName.isEmpty()) {
                    // Name is not empty, display it
                    textViewResult.setText(String.format("Welcome, %s!", myName));
                } else {
                    // Name is empty or contains only whitespace
                    textViewResult.setText("Invalid name.");
                }
            }
        });

        avatarSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                int choice;
//                switch (checkedId) {
//                    case R.id.char_f_elf:
//                        choice = R.drawable.female_elf;
//                        break;
//                    case R.id.char_m_elf:
//                        choice = R.drawable.male_elf;
//                        break;
//                    case R.id.char_witch:
//                        choice = R.drawable.witch;
//                        break;
//                    case R.id.char_wizard:
//                        choice = R.drawable.wizard;
//                        break;
//                    default:
//                        choice = R.drawable.female_elf;
//                        break;
//                }
                if (checkedId == R.id.char_f_elf) {
                    choice = R.drawable.female_elf;
                } else if (checkedId == R.id.char_m_elf) {
                    choice = R.drawable.male_elf;
                } else if (checkedId == R.id.char_witch) {
                    choice = R.drawable.witch;
                } else if (checkedId == R.id.char_wizard) {
                    choice = R.drawable.wizard;
                } else {
                    choice = R.drawable.female_elf;
                }
                displayAvatar(choice);
            }
        });

//        startBtn.setOnClickListener(v -> {
//            Intent game = new Intent(InitialConfiguration.this, GameActivity.class);
//            game.putExtra("difficulty", difficulty);
//            startActivity(game);
//            finish();
//        });
    }
    private void displayHealth(int count) {
        diff_healthbar.setVisibility(View.VISIBLE);

        for (int i = 0; i < count; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.ui_heart_full);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            diff_healthbar.addView(imageView);
        }
    }

    private void displayAvatar(int i) {
        ImageView imageView = (ImageView) findViewById(R.id.avatar_display);
        imageView.setBackgroundResource(i);
        AnimationDrawable idleAvatar = (AnimationDrawable) imageView.getBackground();
        idleAvatar.start();
    }
}

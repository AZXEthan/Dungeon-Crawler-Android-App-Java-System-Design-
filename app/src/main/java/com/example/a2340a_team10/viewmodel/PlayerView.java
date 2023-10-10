package com.example.a2340a_team10.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a2340a_team10.model.*;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerView extends ViewModel {
    private MutableLiveData<Integer> scoreLiveData = new MutableLiveData<>();
    private Timer scoreTimer = new Timer();
    private int scoreDecreaseAmount = 10; // Set the amount to decrease score per second
    private Player hero = Player.getPlayer();

    public PlayerView() {
        // Initialize the score LiveData with the starting score
        scoreLiveData.setValue(hero.getScore());

        // Schedule a task to decrease the score every second
        scoreTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                decreaseScore();
            }
        }, 1000, 1000); // Decrease score every 1000 milliseconds (1 second)
    }

    // Function to decrease the score
    private void decreaseScore() {
        Integer currentScore = scoreLiveData.getValue();
        if (currentScore != null && currentScore > 0) {
            int updatedScore = currentScore - scoreDecreaseAmount;
            scoreLiveData.postValue(updatedScore); // Update the LiveData
            hero.setScore(updatedScore);
        }
    }

    // Expose the LiveData for observation
    public LiveData<Integer> getScoreLiveData() {
        return scoreLiveData;
    }

    // Optional: You can also provide a method to reset the score
    // public void resetScore(int newScore) {
    //      scoreLiveData.setValue(newScore);
    //  }

    // Cleanup the timer when the ViewModel is no longer needed
    // @Override
    // protected void onCleared() {
    //     super.onCleared();
    //     scoreTimer.cancel();
    // }
}

package com.example.a2340a_team10.model;

import java.util.ArrayList;

// This class stores a list of Records that will be present on the leaderboard
public class LeaderboardModel {
    private static LeaderboardModel leaderboard;
    private static ArrayList<Attempt> attemptHistory;

    private LeaderboardModel() {
        attemptHistory = new ArrayList<Attempt>();
    }

    public static LeaderboardModel getInstance() {
        if (leaderboard == null) {
            leaderboard = new LeaderboardModel();
        }
        return leaderboard;
    }

    public void setAttemptHistory(ArrayList<Attempt> attempts) {
        this.attemptHistory = attempts;
    }

    public ArrayList<Attempt> getAttemptHistory() {
        return attemptHistory;
    }
}

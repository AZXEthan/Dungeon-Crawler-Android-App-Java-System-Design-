package com.example.a2340a_team10.model;
import java.util.ArrayList;

public class LeaderboardModel {
    private static LeaderboardModel leaderboard;
    private ArrayList<LeaderboardRowModel> scoreHistory;

    private LeaderboardModel() {
        scoreHistory.add(new LeaderboardRowModel());
    }

    public static LeaderboardModel getInstance() {
        if (leaderboard == null) {
            leaderboard = new LeaderboardModel();
        }
        return leaderboard;
    }

    public void setScoreHistory(ArrayList<LeaderboardRowModel> scoreHistory) {
        this.scoreHistory = scoreHistory;
    }

    public ArrayList<LeaderboardRowModel> getScoreHistory() {
        return scoreHistory;
    }


    public class LeaderboardRowModel implements Comparable<LeaderboardRowModel>{
        int time;
        float score;
        String name;
        int avatar;

        public LeaderboardRowModel() {
            this.name = Player.getPlayer().getName();
            this.score = Player.getPlayer().getScore();

        }


        public float getScore() {
            return score;
        }

        public int getTime() {
            return time;
        }

        public String getName() {
            return name;
        }

        public int getAvatar() {
            return avatar;
        }

        @Override
        public int compareTo(LeaderboardRowModel leaderboardRowModel) {
            return (int) (score - leaderboardRowModel.getScore());
        }
    }

}

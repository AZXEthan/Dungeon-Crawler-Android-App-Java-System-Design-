package com.example.a2340a_team10.model;
import com.example.a2340a_team10.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//This class stores a list of Records that will be present
//on the leaderboard
public class LeaderboardModel {
    private static LeaderboardModel leaderboard;
    private ArrayList<GameRecord> gameRecords;

    private LeaderboardModel() {
        gameRecords.add(new GameRecord());
        //when the Leaderboard is created for the first time,
        //only need to add the current record
    }

    public static LeaderboardModel getInstance() {
        if (leaderboard == null) {
            leaderboard = new LeaderboardModel();
        }
        return leaderboard;
    }

    public void setPlayRecords(ArrayList<GameRecord> gameRecords) {
        this.gameRecords = gameRecords;
    }

    public ArrayList<GameRecord> getPlayRecords() {
        return gameRecords;
    }

//This class is a helper class used to store individual record
//of each attempts
    public class GameRecord implements Comparable<GameRecord>{
        private int score;
        private int avatar;
        private String name;
        private String time;

        public GameRecord() {
            //obtained the attributes of the current player
            int choice = Player.getPlayer().getCharacterChoice();
            this.name = Player.getPlayer().getName();
            this.score = Player.getPlayer().getScore();
            SimpleDateFormat formatter =new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            this.time = formatter.format(date);

            if (choice == R.drawable.female_elf) {
                this.avatar = R.drawable.elf_f_idle_anim_f0;
            } else if (choice == R.drawable.male_elf) {
                this.avatar = R.drawable.elf_m_idle_anim_f0;
            } else if (choice == R.drawable.witch) {
                this.avatar = R.drawable.wizzard_f_idle_anim_f0;
            } else if (choice == R.drawable.wizard) {
                this.avatar = R.drawable.wizzard_m_idle_anim_f0;
            }
        }

        public float getScore() {
            return score;
        }

        public String getTime() {
            return time;
        }

        public String getName() {
            return name;
        }

        public int getAvatar() {
            return avatar;
        }

        @Override
        public int compareTo(GameRecord gameRecord) {
            return (int) (score - gameRecord.getScore());
        }
    }

}

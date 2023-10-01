package com.example.a2340a_team10.viewmodel;

import com.example.a2340a_team10.model.LeaderboardModel;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderboardViewModel {

    public static void addScore() {
        ArrayList<LeaderboardModel.GameRecord> newList = LeaderboardModel.getInstance().getPlayRecords();
        newList.add(LeaderboardModel.getInstance().new GameRecord());
        Collections.sort(newList);
        LeaderboardModel.getInstance().setPlayRecords(newList);
    }
}

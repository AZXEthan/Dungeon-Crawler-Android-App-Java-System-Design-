package com.example.a2340a_team10.viewmodel;

import com.example.a2340a_team10.model.LeaderboardModel;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderboardViewModel {

    public static void addScore() {
        ArrayList<LeaderboardModel.LeaderboardRowModel> newList = LeaderboardModel.getInstance().getScoreHistory();
        newList.add(LeaderboardModel.getInstance().new LeaderboardRowModel());
        Collections.sort(newList);
        LeaderboardModel.getInstance().setScoreHistory(newList);
    }
}

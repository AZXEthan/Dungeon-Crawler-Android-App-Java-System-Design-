package com.example.a2340a_team10.viewmodel;

import com.example.a2340a_team10.model.LeaderboardModel;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderboardViewModel {

    public static LeaderboardModel.Attempt addAttempt() {
        ArrayList<LeaderboardModel.Attempt> newList = LeaderboardModel.getInstance().getAttemptHistory();
        LeaderboardModel.Attempt newAttempt = LeaderboardModel.getInstance().new Attempt();
        newList.add(newAttempt);
        Collections.sort(newList);
        LeaderboardModel.getInstance().setAttemptHistory(newList);
        return newAttempt;
    }
}

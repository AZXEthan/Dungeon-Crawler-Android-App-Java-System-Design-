package com.example.a2340a_team10.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2340a_team10.R;
import com.example.a2340a_team10.model.LeaderboardModel;

import java.util.ArrayList;

public class LB_RecyclerViewAdpter extends RecyclerView.Adapter<LB_RecyclerViewAdpter.MyViewHolder> {
    Context context;
    ArrayList<LeaderboardModel.LeaderboardRowModel> scoreHistory;

    public LB_RecyclerViewAdpter(Context context, ArrayList<LeaderboardModel.LeaderboardRowModel> scoreHistory) {
        this.context = context;
        this.scoreHistory = scoreHistory;
    }
    @NonNull
    @Override
    public LB_RecyclerViewAdpter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_veiw_row, parent, false);
        return new LB_RecyclerViewAdpter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LB_RecyclerViewAdpter.MyViewHolder holder, int position) {
        holder.name.setText(scoreHistory.get(position).getName());
        holder.score.setText(String.valueOf(scoreHistory.get(position).getScore()));
        holder.time.setText(String.valueOf(scoreHistory.get(position).getTime()));
        holder.avatar.setImageResource(scoreHistory.get(position).getAvatar());
        holder.rank.setText(position + 1);
    }

    @Override
    public int getItemCount() {
        return scoreHistory.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView avatar;
        TextView name, score, time, rank;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.Charaname);
            score = itemView.findViewById(R.id.score);
            time = itemView.findViewById(R.id.attamptTime);
        }
    }
}

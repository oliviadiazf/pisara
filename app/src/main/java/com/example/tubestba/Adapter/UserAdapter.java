package com.example.tubestba.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubestba.Model.User;
import com.example.tubestba.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class UserAdapter extends FirebaseRecyclerAdapter<User, UserAdapter.usersViewholder> {

    private List<User> list;

    public UserAdapter(@NonNull FirebaseRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull usersViewholder holder, int position, @NonNull User model) {
        holder.username.setText(model.getUserName());
        holder.skorRanking.setText(Integer.toString(model.getSkor()));
    }

    @NonNull
    @Override
    public usersViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_cardview, parent, false);
        return new UserAdapter.usersViewholder(view);
    }

    class usersViewholder extends RecyclerView.ViewHolder {
        TextView username;
        TextView skorRanking;
        public usersViewholder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.tv_usernameRanking);
            skorRanking = itemView.findViewById(R.id.tv_scoreRanking);
        }
    }
}

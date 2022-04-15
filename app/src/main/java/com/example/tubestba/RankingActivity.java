package com.example.tubestba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tubestba.Adapter.UserAdapter;
import com.example.tubestba.Model.User;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RankingActivity extends AppCompatActivity {

    ImageButton btn_logout;

    private static String MY_PREFS = "switch_prefs";
    private static String USERNAME_STATUS = "username";
    private static String SWITCH_STATUS = "switch_status";
    private RecyclerView recyclerView;
    Boolean switch_status;
    UserAdapter adapter;
    DatabaseReference mbase;
    MediaPlayer sound;

    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        myEditor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();

        btn_logout = (ImageButton) findViewById(R.id.button_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status = myPreferences.getBoolean(SWITCH_STATUS, true)) {
                    sound = MediaPlayer.create(RankingActivity.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
                    myEditor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
                    myEditor.putString(USERNAME_STATUS, null);
                    myEditor.putString(Constant.KEY_LEVEL_1, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_2, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_3, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_4, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_5, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_6, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_7, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_8, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_9, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_10, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_11, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_12, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_13, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_14, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_15, "Lock");
                    myEditor.apply();
                    finish();
                } else {
                    myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
                    myEditor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
                    myEditor.putString(USERNAME_STATUS, null);
                    myEditor.putString(Constant.KEY_LEVEL_1, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_2, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_3, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_4, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_5, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_6, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_7, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_8, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_9, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_10, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_11, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_12, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_13, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_14, "Lock");
                    myEditor.putString(Constant.KEY_LEVEL_15, "Lock");
                    myEditor.apply();
                    finish();
                }
            }
        });


        mbase = FirebaseDatabase.getInstance().getReference().child("Users");
        Query query = mbase.orderByChild("skor");
        recyclerView = findViewById(R.id.rv_ranking);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);
        FirebaseRecyclerOptions<User> options = new FirebaseRecyclerOptions.Builder<User>()
                .setQuery(query, User.class)
                .build();
        adapter = new UserAdapter(options);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
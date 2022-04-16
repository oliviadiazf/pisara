package com.example.tubestba;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tubestba.Model.User;
import com.example.tubestba.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class PopLogin extends Activity {
    EditText editText_user;
    Button btn_ok;
    FirebaseDatabase database;
    DatabaseReference users;
    MediaPlayer sound;

    private static String MY_PREFS = "switch_prefs";
    private static String USERNAME_STATUS = "username";
    private static String SWITCH_STATUS = "switch_status";
    private static String SKOR ="skor";

    boolean switch_status;
    int skor;
    String status_username;
    String username;

    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_login);

        myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        myEditor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
        status_username = myPreferences.getString(USERNAME_STATUS, null);

        //Firebase
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        editText_user = (EditText) findViewById(R.id.editText_username);
        btn_ok = (Button) findViewById(R.id.button_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status = myPreferences.getBoolean(SWITCH_STATUS, true)) {
                    sound = MediaPlayer.create(PopLogin.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    User user = new User(editText_user.getText().toString());
                    username = editText_user.getText().toString();
                    FirebaseDatabase databasee = FirebaseDatabase.getInstance();
                    DatabaseReference userss = databasee.getReference().child("Users").child(username);
                    skor = 0;
                    if (username.isEmpty()) {
                        Toast.makeText(PopLogin.this, "Silahkan masukkan nama kamu terlebih dahulu", Toast.LENGTH_SHORT).show();
                    } else {
                        ValueEventListener eventListener = new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (!snapshot.exists()) {
                                    users.child(user.getUserName()).setValue(user);
                                    myEditor.putString(USERNAME_STATUS, username);
                                    myEditor.apply();
                                    users.child(myPreferences.getString(USERNAME_STATUS, "")).child("skor").setValue(skor);
                                    myEditor.putInt(SKOR, skor);
                                    myEditor.apply();
                                    Toast.makeText(PopLogin.this, "Silahkan klik tombol Mulai", Toast.LENGTH_SHORT).show();
                                } else {
                                    myEditor.putString(USERNAME_STATUS, username);
                                    myEditor.apply();
                                    Object ob_skor = snapshot.child("skor").getValue();

                                    int skorr = ((Long) ob_skor).intValue();
                                    myEditor.putInt(SKOR, skorr);
                                    myEditor.apply();
                                    Toast.makeText(PopLogin.this, "Silahkan klik tombol Mulai", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        };
                        userss.addListenerForSingleValueEvent(eventListener);
                    }
                } else {
                    User user = new User(editText_user.getText().toString());
                    username = editText_user.getText().toString();
                    FirebaseDatabase databasee = FirebaseDatabase.getInstance();
                    DatabaseReference userss = databasee.getReference().child("Users").child(username);
                    skor = 0;
                    if (username.isEmpty()) {
                        Toast.makeText(PopLogin.this, "Silahkan masukkan nama kamu terlebih dahulu", Toast.LENGTH_SHORT).show();
                    } else {
                        ValueEventListener eventListener = new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (!snapshot.exists()) {
                                    users.child(user.getUserName()).setValue(user);
                                    myEditor.putString(USERNAME_STATUS, username);
                                    myEditor.apply();
                                    users.child(myPreferences.getString(USERNAME_STATUS, "")).child("skor").setValue(skor);
                                    myEditor.putInt(SKOR, skor);
                                    myEditor.apply();
                                    Toast.makeText(PopLogin.this, "Silahkan klik tombol Mulai", Toast.LENGTH_SHORT).show();
                                } else {
                                    myEditor.putString(USERNAME_STATUS, username);
                                    myEditor.apply();
                                    Object ob_skor = snapshot.child("skor").getValue();

                                    int skorr = ((Long) ob_skor).intValue();
                                    myEditor.putInt(SKOR, skorr);
                                    myEditor.apply();
                                    Toast.makeText(PopLogin.this, "Silahkan klik tombol Mulai", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        };
                        userss.addListenerForSingleValueEvent(eventListener);
                    }
                }
                finish();
            }
        });

        WindowManager.LayoutParams windowManager = getWindow().getAttributes();
        windowManager.dimAmount = 0.50f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(windowManager);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.7), (int)(height*.5));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
package com.example.tubestba;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.tubestba.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class GameActivity extends AppCompatActivity {

    private EditText jawaban;
    private ImageView mQuizImage;
    ImageButton hint;
    Button submit;
    private TextView mQuizLevel;
    private TextView tv_timer;
    private Questions mQuestions = new Questions();
    private static final long COUNTDOWN_IN_MILLIS = 45000;
    private CountDownTimer countDownTimer;
    private long timeleftinMillis;

    MediaPlayer sound;

    private static String MY_PREFS = "switch_prefs";
    private static String SWITCH_STATUS = "switch_status";
    private static String SKOR ="skor";
    private static String USERNAME_STATUS = "username";

    int skor;
    int skor_now;
    int skor_before;
    int UNLOCK_JL2 = 0, UNLOCK_JL3 = 0, UNLOCK_JL4 = 0, UNLOCK_JL5 = 0, UNLOCK_JL6 = 0, UNLOCK_JL7 = 0;
    int UNLOCK_JL8 = 0, UNLOCK_JL9 = 0, UNLOCk_JL10 = 0, UNLOCK_JL11 = 0, UNLOCK_JL12 = 0, UNLOCK_JL13 = 0;
    int UNLOCK_JL14 = 0, UNLOCK_JL15 = 0;
    Boolean switch_status;
    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;
    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        myEditor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
        skor = myPreferences.getInt(SKOR, 0);

        //Firebase
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        skor_before = myPreferences.getInt(SKOR, 0);

        Bundle intent = getIntent().getExtras();
        int QuestionNum = intent.getInt("Level");

        jawaban = (EditText) findViewById(R.id.editText_submit);
        jawaban.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        timeleftinMillis = COUNTDOWN_IN_MILLIS;
        startCountDown();

        mQuizLevel = findViewById(R.id.tv_level);
        mQuizLevel.setText(mQuestions.getLevel(QuestionNum));

        mQuizImage = findViewById(R.id.imageView_game);
        String img = mQuestions.getImages(QuestionNum);
        mQuizImage.setImageResource(getResources().getIdentifier(img, "drawable", getPackageName()));

        hint = (ImageButton) findViewById(R.id.button_hint);
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status = myPreferences.getBoolean(SWITCH_STATUS, true)) {
                    sound = MediaPlayer.create(GameActivity.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    Intent i = new Intent(getApplicationContext(), HintActivity.class);
                    i.putExtra("Level", QuestionNum);
                    startActivity(i);
                } else {
                    Intent i = new Intent(getApplicationContext(), HintActivity.class);
                    i.putExtra("Level", QuestionNum);
                    startActivity(i);
                }
            }
        });

        submit = (Button) findViewById(R.id.button_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status = myPreferences.getBoolean(SWITCH_STATUS, true)) {
                    sound = MediaPlayer.create(GameActivity.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    String jawabanUser = jawaban.getText().toString();
                    if (mQuestions.getAnswer(QuestionNum).equals(jawabanUser)) {
                        skor = mQuestions.getSkor(QuestionNum);
                        if (skor_before < skor || skor_before == skor) {
                            myEditor.putInt(SKOR, skor);
                            myEditor.apply();
                        } else {
                            myEditor.putInt(SKOR, skor_before);
                            myEditor.apply();
                        }
                        users.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (skor_before < skor || skor_before == skor) {
                                    users.child(myPreferences.getString(USERNAME_STATUS, "")).child("skor").setValue(skor);
                                } else {
                                    users.child(myPreferences.getString(USERNAME_STATUS, "")).child("skor").setValue(skor_before);
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                        unLockLevels();
                        Intent i = new Intent(GameActivity.this, BenarActivity.class);
                        i.putExtra("Benar", QuestionNum);
                        startActivity(i);
                        finish();
                    } else {
                        Intent i = new Intent(getApplicationContext(), SalahActivity.class);
                        startActivity(i);
                    }
                } else {
                    String jawabanUser = jawaban.getText().toString();
                    if (mQuestions.getAnswer(QuestionNum).equals(jawabanUser)) {
                        skor = mQuestions.getSkor(QuestionNum);
                        if (skor_before < skor || skor_before == skor) {
                            myEditor.putInt(SKOR, skor);
                            myEditor.apply();
                        } else {
                            myEditor.putInt(SKOR, skor_before);
                            myEditor.apply();
                        }
                        users.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (skor_before < skor || skor_before == skor) {
                                    users.child(myPreferences.getString(USERNAME_STATUS, "")).child("skor").setValue(skor);
                                } else {
                                    users.child(myPreferences.getString(USERNAME_STATUS, "")).child("skor").setValue(skor_before);
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                        unLockLevels();
                        Intent i = new Intent(GameActivity.this, BenarActivity.class);
                        i.putExtra("Benar", QuestionNum);
                        startActivity(i);
                        finish();
                    } else {
                        Intent i = new Intent(getApplicationContext(), SalahActivity.class);
                        startActivity(i);
                    }
                }
            }
        });
    }

    private void unLockLevels() {
        Bundle intent = getIntent().getExtras();
        int QuestionNum = intent.getInt("Level");
        if (QuestionNum == 0) {
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 1) {
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 2) {
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 3) {
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 4) {
            myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 5) {
            myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 6) {
            myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 7) {
            myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 8) {
            myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 9) {
            myEditor.putString(Constant.KEY_LEVEL_11, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 10) {
            myEditor.putString(Constant.KEY_LEVEL_12, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 11) {
            myEditor.putString(Constant.KEY_LEVEL_13, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 12) {
            myEditor.putString(Constant.KEY_LEVEL_14, "Unlock");
            myEditor.apply();
        } else if (QuestionNum == 13) {
            myEditor.putString(Constant.KEY_LEVEL_15, "Unlock");
            myEditor.apply();
        }
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeleftinMillis, 1000) {
            @Override
            public void onTick(long l) {
                timeleftinMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeleftinMillis = 0;
                updateCountDownText();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeleftinMillis/1000) / 60;
        int seconds = (int) (timeleftinMillis/1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        tv_timer = findViewById(R.id.tv_timer);
        tv_timer.setText(timeFormatted);

        if (timeleftinMillis == 0) {
            Toast.makeText(this, "Waktu Habis!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), LevelActivity.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), LevelActivity.class);
        startActivity(i);
        finish();
    }
}
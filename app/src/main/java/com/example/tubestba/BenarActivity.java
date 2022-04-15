package com.example.tubestba;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BenarActivity extends Activity {

    private TextView penjelasan;
    private TextView kata;
    private TextView skor;
    private Questions mQuestions = new Questions();
    Button btn_lanjut;
    ImageButton btn_kataSound;

    MediaPlayer sound;
    MediaPlayer textSound;

    private static String MY_PREFS = "switch_prefs";
    private static String SWITCH_STATUS = "switch_status";
    private static String MUSIC_STATUS = "music_on";
    private static String SKOR ="skor";

    Boolean switch_status;
    Boolean music_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benar);

        SharedPreferences myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);

        Bundle intent = getIntent().getExtras();
        int QuestionNum = intent.getInt("Benar");

        skor = (TextView) findViewById(R.id.text_skor);
//        skor.setText(String.valueOf(mQuestions.getSkor(QuestionNum)));
        skor.setText(String.valueOf(myPreferences.getInt(SKOR,0)));

        kata = (TextView) findViewById(R.id.tv_kata);
        kata.setText(mQuestions.getAnswer(QuestionNum));

        btn_kataSound = (ImageButton) findViewById(R.id.button_textSound);
        btn_kataSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (music_status = myPreferences.getBoolean(MUSIC_STATUS, true)) {
                    textSound = MediaPlayer.create(BenarActivity.this, mQuestions.getSound(QuestionNum));
                    textSound.setLooping(false);
                    textSound.start();
                }
            }
        });

        penjelasan = (TextView) findViewById(R.id.tv_penjelasan);
        penjelasan.setText(mQuestions.getPenjelasan(QuestionNum));

        btn_lanjut = (Button) findViewById(R.id.button_benar);
        btn_lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status = myPreferences.getBoolean(SWITCH_STATUS, true)) {
                    sound = MediaPlayer.create(BenarActivity.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    Intent i = new Intent(getApplicationContext(), LevelActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(getApplicationContext(), LevelActivity.class);
                    startActivity(i);
                    finish();
                }
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

        getWindow().setLayout((int)(width*.9), (int)(height*.9));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
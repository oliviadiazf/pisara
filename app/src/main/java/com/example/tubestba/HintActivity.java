package com.example.tubestba;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.TextView;

public class HintActivity extends Activity {

    TextView hint;
    Button btn_ok;
    MediaPlayer sound;

    private Questions mQuestions = new Questions();
    private static String MY_PREFS = "switch_prefs";
    private static String SWITCH_STATUS = "switch_status";

    Boolean switch_status;
    SharedPreferences myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        Bundle intent = getIntent().getExtras();
        int QuestionNum = intent.getInt("Level");

        myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);

        hint = (TextView) findViewById(R.id.text_kataBantuan);
        hint.setText(mQuestions.getHint(QuestionNum));

        btn_ok = (Button) findViewById(R.id.button_okHint);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status = myPreferences.getBoolean(SWITCH_STATUS, true)) {
                    sound = MediaPlayer.create(HintActivity.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    finish();
                } else {
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

        getWindow().setLayout((int)(width*.7), (int)(height*.5));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
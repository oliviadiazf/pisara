package com.example.tubestba;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
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
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.widget.SwitchCompat;

import java.util.Calendar;

public class PopSetting extends Activity {

    Button btn_kembali;
    SwitchCompat switchCompatMusic;
    SwitchCompat switchCompatButton;
    SwitchCompat switchCompatNotification;
    MediaPlayer sound;

    private static String MY_PREFS = "switch_prefs";
    private static String SOUND_STATUS = "sound_on";
    private static String SWITCH_STATUS = "switch_status";
    private static String MUSIC_STATUS = "music_on";
    private static String NOTIF_STATUS = "notif_on";

    boolean switch_status;
    boolean sound_status;
    boolean music_status;
    boolean notif_status;

    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_setting);

        myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        myEditor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();

        switch_status = myPreferences.getBoolean(SWITCH_STATUS,true);
        sound_status = myPreferences.getBoolean(SOUND_STATUS, true);
        music_status = myPreferences.getBoolean(MUSIC_STATUS, true);
        notif_status = myPreferences.getBoolean(NOTIF_STATUS, true);

        switchCompatMusic = (SwitchCompat) findViewById(R.id.switch_musik);
        switchCompatMusic.setChecked(music_status);

        switchCompatButton = (SwitchCompat) findViewById(R.id.switch_suara);
        switchCompatButton.setChecked(switch_status);

        switchCompatNotification = (SwitchCompat) findViewById(R.id.switch_notif);
        switchCompatNotification.setChecked(notif_status);

        if(sound_status) {
            sound = MediaPlayer.create(PopSetting.this, R.raw.beep);
            sound.setLooping(false);
            sound.start();
        } else {

        }

        switchCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status == true) {
                    sound = MediaPlayer.create(PopSetting.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    boolean on = switchCompatButton.isChecked();
                    if(on) {
                        myEditor.putBoolean(SWITCH_STATUS, true);
                        myEditor.putBoolean(SOUND_STATUS, true);
                        myEditor.apply();
                        switchCompatButton.setChecked(true);
                    } else {
                        myEditor.putBoolean(SWITCH_STATUS, false);
                        myEditor.putBoolean(SOUND_STATUS, false);
                        myEditor.apply();
                        switchCompatButton.setChecked(false);
                    }
                } else {
                    boolean on = switchCompatButton.isChecked();
                    if(on) {
                        myEditor.putBoolean(SWITCH_STATUS, true);
                        myEditor.putBoolean(SOUND_STATUS, true);
                        myEditor.apply();
                        switchCompatButton.setChecked(true);
                    } else {
                        myEditor.putBoolean(SWITCH_STATUS, false);
                        myEditor.putBoolean(SOUND_STATUS, false);
                        myEditor.apply();
                        switchCompatButton.setChecked(false);
                    }
                }
            }
        });

        switchCompatMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status == true) {
                    sound = MediaPlayer.create(PopSetting.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    boolean on = switchCompatMusic.isChecked();
                    if(on) {
                        myEditor.putBoolean(MUSIC_STATUS, true);
                        myEditor.apply();
                        switchCompatMusic.setChecked(true);
                        if (!CommonMethod.player.isPlaying()) {
                            CommonMethod.MusicPlayer(PopSetting.this, R.raw.music);
                        }
                    } else {
                        myEditor.putBoolean(MUSIC_STATUS, false);
                        myEditor.apply();
                        switchCompatMusic.setChecked(false);
                        if (CommonMethod.player.isPlaying()) {
                            CommonMethod.player.stop();
                        }
                    }
                } else {
                    boolean on = switchCompatMusic.isChecked();
                    if(on) {
                        myEditor.putBoolean(MUSIC_STATUS, true);
                        myEditor.apply();
                        switchCompatMusic.setChecked(true);
                        if (!CommonMethod.player.isPlaying()) {
                            CommonMethod.MusicPlayer(PopSetting.this, R.raw.music);
                        }
                    } else {
                        myEditor.putBoolean(MUSIC_STATUS, false);
                        myEditor.apply();
                        switchCompatMusic.setChecked(false);
                        if (CommonMethod.player.isPlaying()) {
                            CommonMethod.player.stop();
                        }
                    }
                }
            }
        });

        switchCompatNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status == true) {
                    sound = MediaPlayer.create(PopSetting.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    boolean on = switchCompatNotification.isChecked();
                    if(on) {
                        myEditor.putBoolean(NOTIF_STATUS, true);
                        myEditor.apply();
                        switchCompatNotification.setChecked(true);
                        Calendar calendar = Calendar.getInstance();

                        calendar.set(Calendar.HOUR_OF_DAY,16);
                        calendar.set(Calendar.MINUTE,30);
                        calendar.set(Calendar.SECOND,23);

                        Toast.makeText(PopSetting.this, "Kamu akan menerima notifikasi dari PISARA", Toast.LENGTH_SHORT).show();
                        
                        Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                    } else {
                        myEditor.putBoolean(NOTIF_STATUS, false);
                        myEditor.apply();
                        switchCompatNotification.setChecked(false);
                    }
                } else {
                    boolean on = switchCompatNotification.isChecked();
                    if(on) {
                        myEditor.putBoolean(NOTIF_STATUS, true);
                        myEditor.apply();
                        switchCompatNotification.setChecked(true);
                        Calendar calendar = Calendar.getInstance();

                        calendar.set(Calendar.HOUR_OF_DAY,21);
                        calendar.set(Calendar.MINUTE,27);
                        calendar.set(Calendar.SECOND,30);

                        Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                    } else {
                        myEditor.putBoolean(NOTIF_STATUS, false);
                        myEditor.apply();
                        switchCompatNotification.setChecked(false);
                    }
                }
            }
        });

        btn_kembali = (Button) findViewById(R.id.button_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status == true) {
                    sound = MediaPlayer.create(PopSetting.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    finish();
                } else {
                    finish();
                }
            }
        });

        WindowManager.LayoutParams windowManager = getWindow(

        ).getAttributes();
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
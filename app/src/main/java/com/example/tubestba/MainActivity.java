package com.example.tubestba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_mulai;
    Button btn_caraBermain;
    Button btn_username;
    ImageButton btn_refresh;
    ImageButton btn_setting;
    MediaPlayer sound;

    private static String MY_PREFS = "switch_prefs";
    private static String SWITCH_STATUS = "switch_status";
    private static String MUSIC_STATUS = "music_on";
    private static String NOTIF_STATUS = "notif_on";
    private static String USERNAME_STATUS = "username";
    private static String EMPTY = "empty";

    Boolean switch_status;
    Boolean music_status;
    Boolean notif_status;
    String status_username;

    SharedPreferences myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);

        if (music_status = myPreferences.getBoolean(MUSIC_STATUS, true)) {
            CommonMethod.MusicPlayer(this, R.raw.music);
        } else {
           CommonMethod.player.stop();
        }

        if (notif_status = myPreferences.getBoolean(NOTIF_STATUS, true)) {
            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.HOUR_OF_DAY,16);
            calendar.set(Calendar.MINUTE,30);
            calendar.set(Calendar.SECOND,23);

            Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
        }

        btn_mulai = (Button) findViewById(R.id.button_mulai);
        btn_caraBermain = (Button) findViewById(R.id.button_caraMain);
        btn_username = (Button) findViewById(R.id.button_username);
        btn_setting = (ImageButton) findViewById(R.id.button_setting);
        btn_refresh = (ImageButton) findViewById(R.id.button_refresh);

        if (status_username == myPreferences.getString(USERNAME_STATUS, null)) {
            btn_username.setText("Username");
        } else {
            btn_username.setText(myPreferences.getString(USERNAME_STATUS, ""));
        }

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status = myPreferences.getBoolean(SWITCH_STATUS, true)) {
                    sound = MediaPlayer.create(MainActivity.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    if (status_username == myPreferences.getString(USERNAME_STATUS, null)) {
                        btn_username.setText("Username");
                    } else {
                        btn_username.setText(myPreferences.getString(USERNAME_STATUS, ""));
                    }
                } else {
                    if (status_username == myPreferences.getString(USERNAME_STATUS, null)) {
                        btn_username.setText("Username");
                    } else {
                        btn_username.setText(myPreferences.getString(USERNAME_STATUS, ""));
                    }
                }
            }
        });

        btn_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status = myPreferences.getBoolean(SWITCH_STATUS, true)) {
                    sound = MediaPlayer.create(MainActivity.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    if (status_username == myPreferences.getString(USERNAME_STATUS, null)) {
                        btn_username.setText("Username");
                    } else {
                        btn_username.setText(myPreferences.getString(USERNAME_STATUS, ""));
                    }
                    Intent i = new Intent(getApplicationContext(), RankingActivity.class);
                    startActivity(i);
                } else {
                    if (status_username == myPreferences.getString(USERNAME_STATUS, null)) {
                        btn_username.setText("Username");
                    } else {
                        btn_username.setText(myPreferences.getString(USERNAME_STATUS, ""));
                    }
                    Intent i = new Intent(getApplicationContext(), RankingActivity.class);
                    startActivity(i);
                }
            }
        });

        btn_mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status = myPreferences.getBoolean(SWITCH_STATUS, true)) {
                    sound = MediaPlayer.create(MainActivity.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    if (status_username == myPreferences.getString(USERNAME_STATUS, null)) {
                        btn_username.setText("Username");
                    } else {
                        btn_username.setText(myPreferences.getString(USERNAME_STATUS, ""));
                    }
                    if (status_username == myPreferences.getString(USERNAME_STATUS, null)) {
                        Intent i = new Intent(getApplicationContext(), PopLogin.class);
                        startActivity(i);
                    } else {
                        Intent i = new Intent(getApplicationContext(), LevelActivity.class);
                        startActivity(i);
                    }
                } else {
                    if (status_username == myPreferences.getString(USERNAME_STATUS, null)) {
                        btn_username.setText("Username");
                    } else {
                        btn_username.setText(myPreferences.getString(USERNAME_STATUS, ""));
                    }
                    if (status_username == myPreferences.getString(USERNAME_STATUS, null)) {
                        Intent i = new Intent(getApplicationContext(), PopLogin.class);
                        startActivity(i);
                    } else {
                        Intent i = new Intent(getApplicationContext(), LevelActivity.class);
                        startActivity(i);
                    }
                }
            }
        });

        btn_caraBermain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_status = myPreferences.getBoolean(SWITCH_STATUS, true)) {
                    sound = MediaPlayer.create(MainActivity.this, R.raw.beep);
                    sound.setLooping(false);
                    sound.start();
                    if (status_username == myPreferences.getString(USERNAME_STATUS, null)) {
                        btn_username.setText("Username");
                    } else {
                        btn_username.setText(myPreferences.getString(USERNAME_STATUS, ""));
                    }
                    Intent i = new Intent(getApplicationContext(), PopCaraBermain.class);
                    startActivity(i);
                } else {
                    if (status_username == myPreferences.getString(USERNAME_STATUS, null)) {
                        btn_username.setText("Username");
                    } else {
                        btn_username.setText(myPreferences.getString(USERNAME_STATUS, ""));
                    }
                    Intent i = new Intent(getApplicationContext(), PopCaraBermain.class);
                    startActivity(i);
                }
            }
        });

        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (status_username == myPreferences.getString(USERNAME_STATUS, null)) {
                    btn_username.setText("Username");
                } else {
                    btn_username.setText(myPreferences.getString(USERNAME_STATUS, ""));
                }
                Intent i = new Intent(getApplicationContext(), PopSetting.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onPause() {
        if (this.isFinishing()){
            CommonMethod.player.stop();
        }
        Context context = getApplicationContext();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
        if (!taskInfo.isEmpty()) {
            ComponentName topActivity = taskInfo.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                CommonMethod.player.stop();
            }
        }
        super.onPause();
    }
}
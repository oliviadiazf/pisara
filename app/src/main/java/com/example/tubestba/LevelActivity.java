package com.example.tubestba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LevelActivity extends Activity implements View.OnClickListener {

    Button btn_level_1;
    Button btn_level_2;
    Button btn_level_3;
    Button btn_level_4;
    Button btn_level_5;
    Button btn_level_6;
    Button btn_level_7;
    Button btn_level_8;
    Button btn_level_9;
    Button btn_level_10;
    Button btn_level_11;
    Button btn_level_12;
    Button btn_level_13;
    Button btn_level_14;
    Button btn_level_15;

    MediaPlayer sound;

    private static String MY_PREFS = "switch_prefs";
    private static String SWITCH_STATUS = "switch_status";
    private static String SKOR ="skor";

    Boolean switch_status;
    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;

    String JL1, JL2, JL3, JL4, JL5, JL6, JL7, JL8, JL9, JL10, JL11, JL12, JL13, JL14, JL15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        createLevel();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        btn_level_1 = (Button) findViewById(R.id.level_1);
        btn_level_2 = (Button) findViewById(R.id.level_2);
        btn_level_3 = (Button) findViewById(R.id.level_3);
        btn_level_4 = (Button) findViewById(R.id.level_4);
        btn_level_5 = (Button) findViewById(R.id.level_5);
        btn_level_6 = (Button) findViewById(R.id.level_6);
        btn_level_7 = (Button) findViewById(R.id.level_7);
        btn_level_8 = (Button) findViewById(R.id.level_8);
        btn_level_9 = (Button) findViewById(R.id.level_9);
        btn_level_10 = (Button) findViewById(R.id.level_10);
        btn_level_11 = (Button) findViewById(R.id.level_11);
        btn_level_12 = (Button) findViewById(R.id.level_12);
        btn_level_13 = (Button) findViewById(R.id.level_13);
        btn_level_14 = (Button) findViewById(R.id.level_14);
        btn_level_15 = (Button) findViewById(R.id.level_15);

        lockAndLockLevels();

        btn_level_1.setOnClickListener(this);
        btn_level_2.setOnClickListener(this);
        btn_level_3.setOnClickListener(this);
        btn_level_4.setOnClickListener(this);
        btn_level_5.setOnClickListener(this);
        btn_level_6.setOnClickListener(this);
        btn_level_7.setOnClickListener(this);
        btn_level_8.setOnClickListener(this);
        btn_level_9.setOnClickListener(this);
        btn_level_10.setOnClickListener(this);
        btn_level_11.setOnClickListener(this);
        btn_level_12.setOnClickListener(this);
        btn_level_13.setOnClickListener(this);
        btn_level_14.setOnClickListener(this);
        btn_level_15.setOnClickListener(this);
    }

    private void lockAndLockLevels() {
        myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        myEditor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();

        JL1 = myPreferences.getString(Constant.KEY_LEVEL_1, "Lock");
        JL2 = myPreferences.getString(Constant.KEY_LEVEL_2, "Lock");
        JL3 = myPreferences.getString(Constant.KEY_LEVEL_3, "Lock");
        JL4 = myPreferences.getString(Constant.KEY_LEVEL_4, "Lock");
        JL5 = myPreferences.getString(Constant.KEY_LEVEL_5, "Lock");
        JL6 = myPreferences.getString(Constant.KEY_LEVEL_6, "Lock");
        JL7 = myPreferences.getString(Constant.KEY_LEVEL_7, "Lock");
        JL8 = myPreferences.getString(Constant.KEY_LEVEL_8, "Lock");
        JL9 = myPreferences.getString(Constant.KEY_LEVEL_9, "Lock");
        JL10 = myPreferences.getString(Constant.KEY_LEVEL_10, "Lock");
        JL11 = myPreferences.getString(Constant.KEY_LEVEL_11, "Lock");
        JL12 = myPreferences.getString(Constant.KEY_LEVEL_12, "Lock");
        JL13 = myPreferences.getString(Constant.KEY_LEVEL_13, "Lock");
        JL14 = myPreferences.getString(Constant.KEY_LEVEL_14, "Lock");
        JL15 = myPreferences.getString(Constant.KEY_LEVEL_15, "Lock");

        if (JL1.equals("Unlock")) {
            btn_level_1.setClickable(true);
            btn_level_1.setOnClickListener(this);
            btn_level_1.setBackgroundResource(R.drawable.bg_levels);
            btn_level_1.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_1.setClickable(false);
        }

        if (JL2.equals("Unlock")) {
            btn_level_2.setClickable(true);
            btn_level_2.setOnClickListener(this);
            btn_level_2.setBackgroundResource(R.drawable.bg_levels);
            btn_level_2.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_2.setClickable(false);
        }

        if (JL3.equals("Unlock")) {
            btn_level_3.setClickable(true);
            btn_level_3.setOnClickListener(this);
            btn_level_3.setBackgroundResource(R.drawable.bg_levels);
            btn_level_3.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_3.setClickable(false);
        }

        if (JL4.equals("Unlock")) {
            btn_level_4.setClickable(true);
            btn_level_4.setOnClickListener(this);
            btn_level_4.setBackgroundResource(R.drawable.bg_levels);
            btn_level_4.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_4.setClickable(false);
        }

        if (JL5.equals("Unlock")) {
            btn_level_5.setClickable(true);
            btn_level_5.setOnClickListener(this);
            btn_level_5.setBackgroundResource(R.drawable.bg_levels);
            btn_level_5.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_5.setClickable(false);
        }

        if (JL6.equals("Unlock")) {
            btn_level_6.setClickable(true);
            btn_level_6.setOnClickListener(this);
            btn_level_6.setBackgroundResource(R.drawable.bg_levels);
            btn_level_6.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_6.setClickable(false);
        }

        if (JL7.equals("Unlock")) {
            btn_level_7.setClickable(true);
            btn_level_7.setOnClickListener(this);
            btn_level_7.setBackgroundResource(R.drawable.bg_levels);
            btn_level_7.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_7.setClickable(false);
        }

        if (JL8.equals("Unlock")) {
            btn_level_8.setClickable(true);
            btn_level_8.setOnClickListener(this);
            btn_level_8.setBackgroundResource(R.drawable.bg_levels);
            btn_level_8.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_8.setClickable(false);
        }

        if (JL9.equals("Unlock")) {
            btn_level_9.setClickable(true);
            btn_level_9.setOnClickListener(this);
            btn_level_9.setBackgroundResource(R.drawable.bg_levels);
            btn_level_9.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_9.setClickable(false);
        }

        if (JL10.equals("Unlock")) {
            btn_level_10.setClickable(true);
            btn_level_10.setOnClickListener(this);
            btn_level_10.setBackgroundResource(R.drawable.bg_levels);
            btn_level_10.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_10.setClickable(false);
        }

        if (JL11.equals("Unlock")) {
            btn_level_11.setClickable(true);
            btn_level_11.setOnClickListener(this);
            btn_level_11.setBackgroundResource(R.drawable.bg_levels);
            btn_level_11.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_11.setClickable(false);
        }

        if (JL12.equals("Unlock")) {
            btn_level_12.setClickable(true);
            btn_level_12.setOnClickListener(this);
            btn_level_12.setBackgroundResource(R.drawable.bg_levels);
            btn_level_12.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_12.setClickable(false);
        }

        if (JL13.equals("Unlock")) {
            btn_level_13.setClickable(true);
            btn_level_13.setOnClickListener(this);
            btn_level_13.setBackgroundResource(R.drawable.bg_levels);
            btn_level_13.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_13.setClickable(false);
        }

        if (JL14.equals("Unlock")) {
            btn_level_14.setClickable(true);
            btn_level_14.setOnClickListener(this);
            btn_level_14.setBackgroundResource(R.drawable.bg_levels);
            btn_level_14.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_14.setClickable(false);
        }

        if (JL15.equals("Unlock")) {
            btn_level_15.setClickable(true);
            btn_level_15.setOnClickListener(this);
            btn_level_15.setBackgroundResource(R.drawable.bg_levels);
            btn_level_15.setTextColor(getResources().getColor(R.color.black));
        } else {
            btn_level_15.setClickable(false);
        }
    }

    @Override
    public void onClick(View view) {
        SharedPreferences myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        if (switch_status = myPreferences.getBoolean(SWITCH_STATUS, true)) {
            sound = MediaPlayer.create(this, R.raw.beep);
            sound.setLooping(false);
            sound.start();

            switch (view.getId()) {
                case R.id.level_1:
                    if (JL1.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel1 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel1.putExtra("Level", 0);
                        startActivity(intentLevel1);
                        finish();
                    }
                    break;

                case R.id.level_2:
                    if (JL2.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel2 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel2.putExtra("Level", 1);
                        startActivity(intentLevel2);
                        finish();
                    }
                    break;

                case R.id.level_3:
                    if (JL3.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel3 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel3.putExtra("Level", 2);
                        startActivity(intentLevel3);
                        finish();
                    }
                    break;

                case R.id.level_4:
                    if (JL4.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel4 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel4.putExtra("Level", 3);
                        startActivity(intentLevel4);
                        finish();
                    }
                    break;

                case R.id.level_5:
                    if (JL5.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel5 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel5.putExtra("Level", 4);
                        startActivity(intentLevel5);
                        finish();
                    }
                    break;

                case R.id.level_6:
                    if (JL6.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel6 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel6.putExtra("Level", 5);
                        startActivity(intentLevel6);
                        finish();
                    }
                    break;

                case R.id.level_7:
                    if (JL7.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel7 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel7.putExtra("Level", 6);
                        startActivity(intentLevel7);
                        finish();
                    }
                    break;

                case R.id.level_8:
                    if (JL8.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel8 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel8.putExtra("Level", 7);
                        startActivity(intentLevel8);
                        finish();
                    }
                    break;

                case R.id.level_9:
                    if (JL9.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel9 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel9.putExtra("Level", 8);
                        startActivity(intentLevel9);
                        finish();
                    }
                    break;

                case R.id.level_10:
                    if (JL10.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel10 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel10.putExtra("Level", 9);
                        startActivity(intentLevel10);
                        finish();
                    }
                    break;

                case R.id.level_11:
                    if (JL11.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel11 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel11.putExtra("Level", 10);
                        startActivity(intentLevel11);
                        finish();
                    }
                    break;

                case R.id.level_12:
                    if (JL12.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel12 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel12.putExtra("Level", 11);
                        startActivity(intentLevel12);
                        finish();
                    }
                    break;

                case R.id.level_13:
                    if (JL13.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel13 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel13.putExtra("Level", 12);
                        startActivity(intentLevel13);
                        finish();
                    }
                    break;

                case R.id.level_14:
                    if (JL14.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel14 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel14.putExtra("Level", 13);
                        startActivity(intentLevel14);
                        finish();
                    }
                    break;

                case R.id.level_15:
                    if (JL15.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel15 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel15.putExtra("Level", 14);
                        startActivity(intentLevel15);
                        finish();
                    }
                    break;
            }
        } else {
            switch (view.getId()) {
                case R.id.level_1:
                    if (JL1.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel1 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel1.putExtra("Level", 0);
                        startActivity(intentLevel1);
                        finish();
                    }
                    break;

                case R.id.level_2:
                    if (JL2.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel2 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel2.putExtra("Level", 1);
                        startActivity(intentLevel2);
                        finish();
                    }
                    break;

                case R.id.level_3:
                    if (JL3.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel3 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel3.putExtra("Level", 2);
                        startActivity(intentLevel3);
                        finish();
                    }
                    break;

                case R.id.level_4:
                    if (JL4.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel4 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel4.putExtra("Level", 3);
                        startActivity(intentLevel4);
                        finish();
                    }
                    break;

                case R.id.level_5:
                    if (JL5.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel5 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel5.putExtra("Level", 4);
                        startActivity(intentLevel5);
                        finish();
                    }
                    break;

                case R.id.level_6:
                    if (JL6.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel6 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel6.putExtra("Level", 5);
                        startActivity(intentLevel6);
                        finish();
                    }
                    break;

                case R.id.level_7:
                    if (JL7.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel7 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel7.putExtra("Level", 6);
                        startActivity(intentLevel7);
                        finish();
                    }
                    break;

                case R.id.level_8:
                    if (JL8.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel8 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel8.putExtra("Level", 7);
                        startActivity(intentLevel8);
                        finish();
                    }
                    break;

                case R.id.level_9:
                    if (JL9.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel9 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel9.putExtra("Level", 8);
                        startActivity(intentLevel9);
                        finish();
                    }
                    break;

                case R.id.level_10:
                    if (JL10.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel10 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel10.putExtra("Level", 9);
                        startActivity(intentLevel10);
                        finish();
                    }
                    break;

                case R.id.level_11:
                    if (JL11.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel11 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel11.putExtra("Level", 10);
                        startActivity(intentLevel11);
                        finish();
                    }
                    break;

                case R.id.level_12:
                    if (JL12.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel12 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel12.putExtra("Level", 11);
                        startActivity(intentLevel12);
                        finish();
                    }
                    break;

                case R.id.level_13:
                    if (JL13.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel13 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel13.putExtra("Level", 12);
                        startActivity(intentLevel13);
                        finish();
                    }
                    break;

                case R.id.level_14:
                    if (JL14.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel14 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel14.putExtra("Level", 13);
                        startActivity(intentLevel14);
                        finish();
                    }
                    break;

                case R.id.level_15:
                    if (JL15.equals("Lock")) {
                        Toast.makeText(LevelActivity.this, "Level Masih Terkunci", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentLevel15 = new Intent(LevelActivity.this, GameActivity.class);
                        intentLevel15.putExtra("Level", 14);
                        startActivity(intentLevel15);
                        finish();
                    }
                    break;
            }
        }
    }

    private void createLevel() {
        myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        myEditor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
        if (myPreferences.getInt(SKOR, 0) == 0) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.apply();
        } else {
            int currentLevel = myPreferences.getInt(SKOR, 0) / 100;
            if (currentLevel == 1) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 2) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 3) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 4) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 5) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 6) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 7) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 8) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 9) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 10) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_11, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 11) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_11, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_12, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 12) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_11, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_12, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_13, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 13) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_11, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_12, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_13, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_14, "Unlock");
                myEditor.apply();
            } else if (currentLevel == 14) {
                myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_11, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_12, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_13, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_14, "Unlock");
                myEditor.putString(Constant.KEY_LEVEL_15, "Unlock");
                myEditor.apply();
            }
        }

        if (myPreferences.getString(Constant.KEY_LEVEL_1, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
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
        } else if (myPreferences.getString(Constant.KEY_LEVEL_2, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
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
        } else if (myPreferences.getString(Constant.KEY_LEVEL_3, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
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
        } else if (myPreferences.getString(Constant.KEY_LEVEL_4, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
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
        } else if (myPreferences.getString(Constant.KEY_LEVEL_5, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
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
        } else if (myPreferences.getString(Constant.KEY_LEVEL_6, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_7, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_8, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_9, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_10, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_11, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_12, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_13, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_14, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_15, "Lock");
        } else if (myPreferences.getString(Constant.KEY_LEVEL_6, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_7, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_8, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_9, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_10, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_11, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_12, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_13, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_14, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_15, "Lock");
        } else if (myPreferences.getString(Constant.KEY_LEVEL_7, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_8, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_9, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_10, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_11, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_12, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_13, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_14, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_15, "Lock");
        } else if (myPreferences.getString(Constant.KEY_LEVEL_8, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_9, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_10, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_11, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_12, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_13, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_14, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_15, "Lock");
        } else if (myPreferences.getString(Constant.KEY_LEVEL_9, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_10, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_11, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_12, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_13, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_14, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_15, "Lock");
        } else if (myPreferences.getString(Constant.KEY_LEVEL_10, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_11, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_12, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_13, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_14, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_15, "Lock");
        } else if (myPreferences.getString(Constant.KEY_LEVEL_11, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_11, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_12, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_13, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_14, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_15, "Lock");
        } else if (myPreferences.getString(Constant.KEY_LEVEL_12, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_11, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_12, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_13, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_14, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_15, "Lock");
        } else if (myPreferences.getString(Constant.KEY_LEVEL_13, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_11, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_12, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_13, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_14, "Lock");
            myEditor.putString(Constant.KEY_LEVEL_15, "Lock");
        } else if (myPreferences.getString(Constant.KEY_LEVEL_14, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_11, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_12, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_13, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_14, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_15, "Lock");
        } else if (myPreferences.getString(Constant.KEY_LEVEL_15, "N/A").equals("Unlock")) {
            myEditor.putString(Constant.KEY_LEVEL_1, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_2, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_3, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_4, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_5, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_6, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_7, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_8, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_9, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_10, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_11, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_12, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_13, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_14, "Unlock");
            myEditor.putString(Constant.KEY_LEVEL_15, "Unlock");
        }
    }
}
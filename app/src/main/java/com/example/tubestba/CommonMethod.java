package com.example.tubestba;

import android.content.Context;
import android.media.MediaPlayer;

public class CommonMethod {
    public static MediaPlayer player;
    public static void MusicPlayer(Context context, int raw_id) {
        player = MediaPlayer.create(context, raw_id);
        player.setLooping(true);
        player.start();
    }
}

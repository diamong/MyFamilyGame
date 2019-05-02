package com.diamong.myfamilygame;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class PullGameActivity extends AppCompatActivity {
    private ImageView[] imageViews;
    private Button buttonBottomAttack, buttonTopAttack;
    private int Level;
    private SoundPool soundPool, soundPool2;
    private int soundLoad, soundLoad2;
    private MediaPlayer mediaPlayer;

    private void Init() {
        imageViews = new ImageView[15];
        imageViews[0] = findViewById(R.id.image00);
        imageViews[1] = findViewById(R.id.image01);
        imageViews[2] = findViewById(R.id.image02);
        imageViews[3] = findViewById(R.id.image03);
        imageViews[4] = findViewById(R.id.image04);
        imageViews[5] = findViewById(R.id.image05);
        imageViews[6] = findViewById(R.id.image06);
        imageViews[7] = findViewById(R.id.image07);
        imageViews[8] = findViewById(R.id.image08);
        imageViews[9] = findViewById(R.id.image09);
        imageViews[10] = findViewById(R.id.image10);
        imageViews[11] = findViewById(R.id.image11);
        imageViews[12] = findViewById(R.id.image12);
        imageViews[13] = findViewById(R.id.image13);
        imageViews[14] = findViewById(R.id.image14);
        Level = 7;

        buttonBottomAttack = findViewById(R.id.button_bottom_attack);
        buttonTopAttack = findViewById(R.id.button_top_attack);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundLoad = soundPool.load(getApplicationContext(), R.raw.ball, 1);

        soundPool2 = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundLoad2 = soundPool2.load(getApplicationContext(), R.raw.clicking, 1);

        mediaPlayer=new MediaPlayer();
        mediaPlayer=MediaPlayer.create(this,R.raw.jazz);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_game);

        Init();
        imageViews[Level].setBackgroundColor(Color.argb(100, 0, 0, 0));

    }


    public void Attack(View view) {
        switch (view.getId()) {
            case R.id.button_bottom_attack:
                if (Level == 0) {
                    Toast.makeText(this, "이겼어요", Toast.LENGTH_SHORT).show();
                    buttonTopAttack.setVisibility(View.INVISIBLE);
                    mediaPlayer.start();
                    break;
                } else {
                    soundPool.play(soundLoad, 1, 1, 1, 0, 3);
                    Level = Level - 1;
                    imageViews[Level].setBackgroundColor(Color.argb(100, 0, 0, 0));
                    imageViews[Level + 1].setBackgroundColor(Color.argb(100, 255, 255, 255));
                }

                break;

            case R.id.button_top_attack:
                if (Level == 14) {
                    Toast.makeText(this, "이겼어요", Toast.LENGTH_SHORT).show();
                    buttonBottomAttack.setVisibility(View.INVISIBLE);
                    mediaPlayer.start();
                    break;
                } else {
                    soundPool.play(soundLoad, 1, 1, 1, 0, 3);
                    Level = Level + 1;
                    imageViews[Level].setBackgroundColor(Color.argb(100, 0, 0, 0));
                    imageViews[Level - 1].setBackgroundColor(Color.argb(100, 255, 255, 255));
                }
                break;
            case R.id.button_top_person:
                GameInit();
                break;
            case R.id.button_bottom_person:
                GameInit();
                break;
        }
    }

    private void GameInit() {
        mediaPlayer.pause();
        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].setBackgroundColor(Color.argb(100, 255, 255, 255));
        }

        Level = 7;
        imageViews[Level].setBackgroundColor(Color.argb(100, 0, 0, 0));
        buttonTopAttack.setVisibility(View.VISIBLE);
        buttonBottomAttack.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}

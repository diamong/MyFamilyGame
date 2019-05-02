package com.diamong.myfamilygame;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Dice2Activity extends AppCompatActivity {
    private ImageView imageViewTop, imageViewBottom;
    private Button buttonStart, buttonStop;
    private TextView textViewResult;
    private int[] imageViews;
    private Random random;
    private SoundPool soundPool, soundPool2;
    private int soundLoad, soundLoad2;
    private MediaPlayer mediaPlayer;


    private Animation rotate, rotateStop, rotate2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice2);

        random = new Random();

        rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        rotateStop = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotatestop);
        rotate2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate2);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundLoad = soundPool.load(getApplicationContext(), R.raw.movement, 1);

        soundPool2 = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundLoad2 = soundPool2.load(getApplicationContext(), R.raw.clicking, 1);
        mediaPlayer=new MediaPlayer();
        mediaPlayer=MediaPlayer.create(this,R.raw.onemore);


        buttonStart = findViewById(R.id.button_dice2_start);
        buttonStop = findViewById(R.id.button_dice2_stop);

        imageViewTop = findViewById(R.id.image_top);
        imageViewBottom = findViewById(R.id.image_bottom);
        textViewResult = findViewById(R.id.text_dice2_result);

        imageViews = new int[]
                {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};


    }

    public void onDice2Clicked(View view) {


        switch (view.getId()) {
            case R.id.button_dice2_start:
                imageViewTop.setImageResource(R.drawable.dice);
                imageViewBottom.setImageResource(R.drawable.dice);

                soundPool.play(soundLoad, 1, 1, 1, 0, 3);
                imageViewTop.startAnimation(rotate);
                imageViewBottom.startAnimation(rotate2);

                buttonStart.setVisibility(View.GONE);
                buttonStop.setVisibility(View.VISIBLE);
                textViewResult.setVisibility(View.INVISIBLE);


                break;
            case R.id.button_dice2_stop:

                InitDice();
                soundPool2.play(soundLoad2, 1, 1, 1, 0, 3);

                break;
            default:
                break;
        }
    }

    private void InitDice() {
        soundPool.stop(soundLoad);
        imageViewTop.startAnimation(rotateStop);
        imageViewBottom.startAnimation(rotateStop);
        buttonStart.setVisibility(View.VISIBLE);
        buttonStop.setVisibility(View.GONE);

        int x, y;

        x = MakeRandom();
        y = MakeRandom();
        if (x==y) mediaPlayer.start();
        imageViewTop.setImageResource(imageViews[x]);
        imageViewBottom.setImageResource(imageViews[y]);
        textViewResult.setText(String.valueOf((x + 1) + (y + 1)));
        textViewResult.setVisibility(View.VISIBLE);
    }

    private int MakeRandom() {
        int result = random.nextInt(6);
        return result;
    }
}

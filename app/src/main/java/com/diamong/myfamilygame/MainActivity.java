package com.diamong.myfamilygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.button_dice:
                intent = new Intent(getApplicationContext(), DiceActivity.class);
                startActivity(intent);
                break;
            case R.id.button_dice2:
                intent = new Intent(getApplicationContext(), Dice2Activity.class);
                startActivity(intent);
                break;
            case R.id.button_pull_game:
                intent = new Intent(getApplicationContext(), PullGameActivity.class);
                startActivity(intent);
                break;
            case R.id.button_memorization:
                intent = new Intent(getApplicationContext(), MemorizationActivity.class);
                startActivity(intent);
                break;
        }
    }
}

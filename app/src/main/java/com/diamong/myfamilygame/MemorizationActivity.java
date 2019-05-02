package com.diamong.myfamilygame;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MemorizationActivity extends AppCompatActivity {
    private TextView[] textViews;
    private TextView textViewCount;
    private EditText[] editTexts;
    private Button[] buttons;
    private Button button_Memorization_start;
    private Random random;
    private int[] mNumber;
    private int[] userNumber;
    private int jumsu, soundLoad;
    private CountDownTimer countDownTimer;
    private InputMethodManager immhide;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;


    private void InitVariable() {
        textViews = new TextView[6];
        textViews[0] = findViewById(R.id.text_1);
        textViews[1] = findViewById(R.id.text_2);
        textViews[2] = findViewById(R.id.text_3);
        textViews[3] = findViewById(R.id.text_4);
        textViews[4] = findViewById(R.id.text_5);
        textViews[5] = findViewById(R.id.text_6);

        editTexts = new EditText[6];
        editTexts[0] = findViewById(R.id.edittext_1);
        editTexts[1] = findViewById(R.id.edittext_2);
        editTexts[2] = findViewById(R.id.edittext_3);
        editTexts[3] = findViewById(R.id.edittext_4);
        editTexts[4] = findViewById(R.id.edittext_5);
        editTexts[5] = findViewById(R.id.edittext_6);

        buttons = new Button[6];
        buttons[0] = findViewById(R.id.button_1);
        buttons[1] = findViewById(R.id.button_2);
        buttons[2] = findViewById(R.id.button_3);
        buttons[3] = findViewById(R.id.button_4);
        buttons[4] = findViewById(R.id.button_5);
        buttons[5] = findViewById(R.id.button_6);

        button_Memorization_start = findViewById(R.id.btn_memorization_start);

        random = new Random();

        mNumber = new int[6];
        userNumber = new int[6];

        textViewCount = findViewById(R.id.text_count);

        immhide = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        ImmHide(true);

        jumsu = 0;
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.jazz);
        //mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.jazz);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundLoad = soundPool.load(getApplicationContext(), R.raw.ball, 1);


    }

    @Override
    protected void onStart() {
        super.onStart();
        ImmHide(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorization);

        InitVariable();
        mediaPlayer.start();


        editTexts[0].addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    Toast.makeText(MemorizationActivity.this, "다시 입력", Toast.LENGTH_SHORT).show();
                }else {
                CalcuMemo(0);
                editTexts[1].requestFocus();

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editTexts[1].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    Toast.makeText(MemorizationActivity.this, "다시 입력", Toast.LENGTH_SHORT).show();
                } else {
                    CalcuMemo(1);
                    editTexts[2].requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editTexts[2].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    Toast.makeText(MemorizationActivity.this, "다시 입력", Toast.LENGTH_SHORT).show();
                } else {
                    CalcuMemo(2);
                    editTexts[3].requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editTexts[3].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    Toast.makeText(MemorizationActivity.this, "다시 입력", Toast.LENGTH_SHORT).show();
                } else {

                    CalcuMemo(3);
                    editTexts[4].requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editTexts[4].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    Toast.makeText(MemorizationActivity.this, "다시 입력", Toast.LENGTH_SHORT).show();
                } else {

                    CalcuMemo(4);
                    editTexts[5].requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editTexts[5].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    Toast.makeText(MemorizationActivity.this, "다시 입력", Toast.LENGTH_SHORT).show();
                } else {

                    CalcuMemo(5);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

                if (jumsu == 6) {
                    textViewCount.setText("100점");
                    MStart();
                } else if (jumsu == 5) {
                    textViewCount.setText("90점");
                } else if (jumsu == 4) {
                    textViewCount.setText("80점");
                } else if (jumsu == 3) {
                    textViewCount.setText("70점");
                } else if (jumsu == 2) {
                    textViewCount.setText("60점");
                } else if (jumsu == 1) {
                    textViewCount.setText("50점");
                }
                ImmHide(true);
            }
        });


    }

    private void MStart() {
        mediaPlayer.start();

    }


    public void MakeNumber(View view) {
        switch (view.getId()) {
            case R.id.btn_memorization_start:
                ImmHide(true);
                jumsu = 0;
                mediaPlayer.pause();
                for (int i = 0; i < editTexts.length; i++) {
                    editTexts[i].setText("");
                }

                InputNumber();
                countDownTimer = new CountDownTimer(5000, 1000) {
                    @Override

                    public void onTick(long millisUntilFinished) {
                        textViewCount
                                .setText(String.format(Locale.getDefault(), "%d 초.", millisUntilFinished / 1000L));

                    }

                    @Override
                    public void onFinish() {
                        for (int i = 0; i < textViews.length; i++) {
                            textViews[i].setText("?");
                        }

                        textViewCount.setText("시작");
                        for (int i = 0; i < buttons.length; i++) {
                            buttons[i].setText("?");
                        }
                        ImmHide(false);

                    }
                }.start();
                editTexts[0].requestFocus();


                break;

        }
    }

    private void CalcuMemo(int i) {
        if (editTexts[i].getText().toString().isEmpty()) {
            ToastOutput(i + 1);
        } else {
            userNumber[i] = Integer.parseInt(editTexts[i].getText().toString());
            textViews[i].setText(String.valueOf(mNumber[i]));
            if (mNumber[i] == userNumber[i]) {
                buttons[i].setText("O");
                jumsu++;

            } else {
                buttons[i].setText("X");
            }
        }
    }

    private void ToastOutput(int id) {
        Toast.makeText(this, id + "번  칸을 입력하세요", Toast.LENGTH_SHORT).show();
    }

    private void InputNumber() {
        for (int i = 0; i < mNumber.length; i++) {
            mNumber[i] = MakeRandom();
        }
        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setText(String.valueOf(mNumber[i]));
        }


    }

    private int MakeRandom() {
        int result = random.nextInt(10);
        return result;
    }

    public void ImmHide(boolean istrue) {
        if (istrue) {
            immhide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        } else {
            immhide.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}

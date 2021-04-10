package com.example.singletone;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.singletone.MainActivity.gameManager;

public class Page3 extends AppCompatActivity {

    private Button skipStep, nextStep;
    private static boolean turn;
    private Timer timer;
    private static MediaPlayer isTrueButtonSound;
    private static MediaPlayer skipButtonSound;
    private static MediaPlayer timerEndSound;
    private int count = gameManager.getRoundDuration();
    private int dCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        getSinger();
        startTimer();

        isTrueButtonSound = MediaPlayer.create(this, R.raw.click_1);
        skipButtonSound = MediaPlayer.create(this, R.raw.click_2);
        timerEndSound = MediaPlayer.create(this, R.raw.click_3);

        TextView tv1 = findViewById(R.id.teamName);
        tv1.setText("Խաղում է՝    "+gameManager.getCurrentPlayer().getName());

        final TextView dynamicCountView = findViewById(R.id.countView);

        final TextView tv2 = findViewById(R.id.gameScoreInside);
         tv2.setText(gameManager.getScore());

        skipStep = findViewById(R.id.skipStep);
        skipStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipButtonSound.start();
                if(count>5){
                    count=count-5;
                } else {
                    count=0;
                }
                tv2.setText(gameManager.getScore());
                getSinger();
            }
        });

        nextStep = findViewById(R.id.nextStep);
        nextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTrueButtonSound.start();
                dCount++;
                dynamicCountView.setText(""+dCount);
                gameManager.plusScore();
                tv2.setText(gameManager.getScore());
                getSinger();
            }
        });
    }

    void endRound(){
        timer.cancel();
        timerEndSound.release();
        if(gameManager.isWinner()==2){
            turn=false;
            Intent intent = new Intent(this, WinnerPage.class);
            startActivity(intent);
        } else if(gameManager.isWinner()==1){
            if(turn){
                turn=false;
                gameManager.changeTurn();
                Intent intent = new Intent(this, WinnerPage.class);
                startActivity(intent);
            } else {
                turn=true;
                gameManager.changeTurn();
                Intent intent = new Intent(this, Page2.class);
                startActivity(intent);
            }
        } else {
            gameManager.changeTurn();
            Intent intent = new Intent(this, Page2.class);
            startActivity(intent);
        }
    }

    private void getSinger(){
        TextView tv1 = findViewById(R.id.gameWindow);
        tv1.setText(gameManager.getRandomSinger());
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Ավարտե՞լ ընթացիկ խաղափուլը։");
        builder.setPositiveButton("Այո", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                endRound();
            }
        });
        builder.setNegativeButton("Ոչ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void startTimer(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        TextView tv3 = findViewById(R.id.timerView);
                        tv3.setText(""+count);
                        count--;
                        if(count < 10){
                            timerEndSound.start();
                        }
                        if(count<0) {
                            endRound();
                        }
                    }
                });
            }
        }, 1000,1000);
    }

    public static boolean isTurn() {
        return turn;
    }
}

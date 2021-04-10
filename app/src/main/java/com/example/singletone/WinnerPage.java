package com.example.singletone;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.singletone.MainActivity.gameManager;

public class WinnerPage extends AppCompatActivity {

    private Button button;
    private MediaPlayer congrats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_page);
        TextView tv1 = findViewById(R.id.winnerName);
        tv1.setText("Շնորհավորում ենք \n Հաղթեց "+ gameManager.getCurrentPlayer().getName()+" -ը");
        congrats = MediaPlayer.create(this, R.raw.winner);
        congrats.start();

        Button button = findViewById(R.id.startNewGame);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endGame();
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Գնա՞նք և սկսենք նոր խաղ։");
        builder.setPositiveButton("Այո", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                endGame();
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

    private void endGame(){
        congrats.release();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

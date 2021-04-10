package com.example.singletone;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.singletone.MainActivity.gameManager;
import static com.example.singletone.Page3.isTurn;

public class Page2 extends AppCompatActivity {

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        if(isTurn()){
            TextView tv3 = findViewById(R.id.teamTurn);
            tv3.setText("Սա ձեր վերջին շանսն է հաղթելու \n"+gameManager.getCurrentPlayer().getName());
        } else {
            TextView tv1 = findViewById(R.id.teamTurn);
            tv1.setText(gameManager.getCurrentPlayer().getName());
        }



        TextView tv2 = findViewById(R.id.gameScore);
        tv2.setText(gameManager.getScore());

        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });
    }

    void startGame(){
        Intent intent = new Intent(this, Page3.class);
        startActivity(intent);
    }

    void endGame(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Ուզում եք դո՞ւրս գալ խաղից։");
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

}

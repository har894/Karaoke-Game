package com.example.singletone;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    private Button createButton;
    static GameManager gameManager;
    private NumberPicker npScore;
    private NumberPicker npDuration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        npScore = findViewById(R.id.numberPickerScore);
        npScore.setMinValue(20);
        npScore.setMaxValue(100);
        npScore.setValue(60);

        npDuration = findViewById(R.id.numberPickerDuration);
        npDuration.setMinValue(20);
        npDuration.setMaxValue(100);
        npDuration.setValue(40);


        createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createGameManager();
            }
        });
    }

    private void createGameManager(){

        TextInputLayout inputLayout1 = findViewById(R.id.team1Name);
        TextInputLayout inputLayout2 = findViewById(R.id.team2Name);
        /*TextInputLayout inputLayout3 = findViewById(R.id.roundDur);
        TextInputLayout inputLayout4 = findViewById(R.id.roundSc);*/

        EditText team1Name = inputLayout1.findViewById(R.id.team1NameInput);
        EditText team2Name = inputLayout2.findViewById(R.id.team2NameInput);
        /*EditText roundTime = inputLayout3.findViewById(R.id.roundDuration);
        EditText roundScore = inputLayout4.findViewById(R.id.roundScore);*/
        CheckBox checkBox = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);


        String t1 = "Թիմ 1", t2 = "Թիմ 2";
        int duration = npDuration.getValue(), mScore = npScore.getValue();
        boolean rusChecked = false, engChecked = false;

        if (checkBox.isChecked()){
            rusChecked = true;
        }

        if (checkBox2.isChecked()){
            engChecked = true;
        }

        if(!team1Name.getText().toString().equals("")){
            t1 = team1Name.getText().toString();
        }

        if(!team2Name.getText().toString().equals("")){
            t2 = team2Name.getText().toString();
        }

        /*if(!roundTime.getText().toString().equals("") && Integer.parseInt(roundTime.getText().toString())>10){
            sec = Integer.parseInt(roundTime.getText().toString());
        }
        if(np){
            mScore = Integer.parseInt(roundScore.getText().toString());
        }*/

        gameManager = new GameManager(t1,t2,mScore,duration,rusChecked,engChecked);

        Intent intent = new Intent(this, Page2.class);
        startActivity(intent);
    }

    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}

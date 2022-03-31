package com.confidenceb.connectgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 1;
    int[] gameStatus = {0,0,0,0,0,0,0,0,0};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{2,4,6},{0,4,8}};

    public void dropInCounter(View view){
        ImageView counter = (ImageView) view;
        Log.i("Tag", counter.getTag().toString());
        int clickedTag = Integer.parseInt(counter.getTag().toString());
        gameStatus[clickedTag] = activePlayer;
        counter.setTranslationY(-1500);
        if(activePlayer==1){
            counter.setImageResource(R.drawable.yellow);
            activePlayer= 2;
        }else{
            counter.setImageResource(R.drawable.red);
            activePlayer = 1;
        }
        for(int[] winningPosition:winningPositions) {
            if (gameStatus[winningPosition[0]]==gameStatus[winningPosition[1]]&& gameStatus[winningPosition[1]]==gameStatus[winningPosition[2]]&& gameStatus[winningPosition[0]]!=0) {
                String gameWinner = "";
                if(activePlayer==2){
                    gameWinner = "Yellow";
                }else{
                    gameWinner = "Red";
                }
                //Toast.makeText()
                //Billonaire_Confi1_$$    Billonaire_Confi1_$$
            }
        }
        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
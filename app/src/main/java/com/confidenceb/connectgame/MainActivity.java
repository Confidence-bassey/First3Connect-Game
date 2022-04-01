package com.confidenceb.connectgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    boolean gameState = true;
    int[] gameStatus = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{2,4,6},{0,4,8}};

    public void dropInCounter(View view) {
        ImageView counter = (ImageView) view;
        Log.i("Tag", counter.getTag().toString());
        int clickedTag = Integer.parseInt(counter.getTag().toString());
        if (gameStatus[clickedTag] == 2 && gameState) {
            gameStatus[clickedTag] = activePlayer;
            counter.setTranslationY(-1500);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            for (int[] winningPosition : winningPositions) {
                if (gameStatus[winningPosition[0]] == gameStatus[winningPosition[1]] && gameStatus[winningPosition[1]] == gameStatus[winningPosition[2]] && gameStatus[winningPosition[0]] != 2) {
                    String gameWinner = "";
                    if (activePlayer == 1) {
                        gameWinner = "Yellow";
                    } else {
                        gameWinner = "Red";
                    }
                    //Log.i("TAG", "gamewinner: called");
                    gameState = false;
                    Button Replaybtn = (Button)findViewById(R.id.ReplayBtn);
                    TextView showWinner = (TextView)findViewById(R.id.showWinner);
                    Log.i("INFO", gameWinner + " has won");
                    showWinner.setText(gameWinner + " has won");
                    showWinner.setVisibility(View.VISIBLE);
                    Log.i("TAG", "make reply button visible now");
                    Replaybtn.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
package com.samuelvialle.plusoumoins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Connect3 extends AppCompatActivity {
    /** Variables globales **/
    private static final String TAG = "Connect3";
    // 1 : StarWars  // 2 : StarTrek
    int activePlayer = 1;

    // Tableau en début de partie
    // 0 : Case vide // 1 : StarWars  // 2 : StarTrek
    int[] gameState = {0,0,0,0,0,0,0,0,0};

    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                                {0, 4, 8}, {2, 4, 6} };

    TextView tvWinner;
    Button btnPlayAgain;

    boolean stopGame = false;

    public void init(){
        btnPlayAgain = findViewById(R.id.btnPlayAgain);
        tvWinner = findViewById(R.id.tvWinner);
    }

    /** Méthode dropIn **/
    public void dropIn(View view) {
        ImageView square = (ImageView) view;

        Log.i(TAG, square.getTag().toString());

        int tappedSquare = Integer.parseInt(square.getTag().toString());

        if (gameState[tappedSquare] == 0 && !stopGame) {
            gameState[tappedSquare] = activePlayer;

            square.setTranslationY((-1000));
            // Ajout d'une vérification du player courant
            if (activePlayer == 1) {
                square.setImageResource(R.drawable.star_wars);
                activePlayer = 2;
            } else {
                square.setImageResource(R.drawable.star_trek);
                activePlayer = 1;
            }
            square.animate().translationYBy(1000).rotation(1800).setDuration(500);

            // Loop dans le tableau winningPositions
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                        && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                        && gameState[winningPosition[0]] != 0) {

                    stopGame = true;

                    String happyEnd;
                    String winner;

                    if (activePlayer == 2) {
                        winner = "StarWars";
                        happyEnd = "May the force be with you !";
                    } else {
                        winner = "StarTrek";
                        happyEnd = "Live long and prosper";
                    }
                    Toast.makeText(this, happyEnd, Toast.LENGTH_SHORT).show();

                    tvWinner.setText(winner + " has won !");
                    tvWinner.setVisibility(View.VISIBLE);
                    btnPlayAgain.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playAgain(View view){
        tvWinner.setVisibility(View.INVISIBLE);
        btnPlayAgain.setVisibility(View.INVISIBLE);

        androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.mGridLayout);
        for(int i=0; i < gridLayout.getChildCount(); i++){
            ImageView square = (ImageView) gridLayout.getChildAt(i);
            square.setImageDrawable(null);
        }

        for(int i=0; i<9; i++){
            gameState[i] = 0;
        }

        activePlayer = 1;
        stopGame = false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);

        init();
    }
}
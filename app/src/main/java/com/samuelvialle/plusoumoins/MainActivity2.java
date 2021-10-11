package com.samuelvialle.plusoumoins;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    // Déclaration des variables dîtes globales
    Button btnGuess;

    // Création d'une méthode contenant tous les liens design code
    public void init() {
        btnGuess = findViewById(R.id.btnGuess);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Appel de la méthode init()
        init();

        // Utilisation avec le setOnClickListener
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ici le code qui sera activé lors du clic sur l'élément
            }
        });

    }
}




package com.samuelvialle.plusoumoins.Accueil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.samuelvialle.plusoumoins.PlusOuMoins;
import com.samuelvialle.plusoumoins.R;

public class Accueil extends AppCompatActivity {

    /** 1 Variables globales **/
    Button btnPlusOuMoins;

    /** 2 Méthode init() **/
    public void init(){
        btnPlusOuMoins = findViewById(R.id.btnPlusOuMoins);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        /** 3 Appel de la méthode init **/
        init();

        btnPlusOuMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Création de l'Intent            Le départ          la destination
                Intent intent = new Intent(Accueil.this, PlusOuMoins.class);

                String titre = btnPlusOuMoins.getText().toString();

                intent.putExtra("TitrePage", titre);

                // lancement de l'activité PlusOuMoins
                startActivity(intent);
            }
        });
    }
}
package com.samuelvialle.plusoumoins;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    /** //1 Placer les composants dans le design **/

    /** //3.2 VAR globales **/
    int nbAleatoire;
    // logt ;)
    private static final String TAG = "MainActivity";

    /** //2 Créer une fonction dans laquelle on va utiliser les log pour vérifier le bon fonctionnement **/
    // Fonction pour deviner le nombre
    public void devine(View view){
        // Lien entre le composant et le code
        EditText etNumber = findViewById(R.id.etNumber);
        /** //3 Explication des logs et de ces raccourcis **/
        Log.i(TAG, "devine pressé");
        /** //4 Gestion de logs avec concaténation **/
        /** Google Java int to string **/
        Log.i(TAG, "Le nombre aléatoire est le " + Integer.toString(nbAleatoire));
        /** //4.1 Gestion de la récupération des données tapées par l'utilisateur **/
        Log.i(TAG, "L'utilisateur à proposé le " + etNumber.getText().toString().trim());

        /** //5.0 Gestion de l comparaison entre le nbAleatoire et le nombre donné par l'utilisateur **/
        /** //5.1 Commençons par transformer le String récupérer par l'user en integer **/
        int nbUser = Integer.parseInt(etNumber.getText().toString());
        /** //5.2 Vérification avec affichage d'un Toast **/
        String message; // A créer après les if
//        if(nbUser > nbAleatoire){
//            message = "Moins !";
//        } else if(nbUser < nbAleatoire){
//            message = "Plus !";
//        } else {
//            message = "Tu as deviné le nombre mystère !";
//        }
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        /** //6.0 Amélioration du script **/
        if (nbUser > nbAleatoire) {
            message = "Moins !";
            /** //6.1 Vidage de l'etNumber **/
            etNumber.setText("");
        } else if (nbUser < nbAleatoire) {
            message = "Plus !";
            etNumber.setText("");
        } else {
            message = "Tu as deviné le nombre mystère ! Essaye encore ;)";
            etNumber.setText("");
            /** //6.2 Nouveau nombre Random pour cela il faut déplacer la section //3 dans une méthode et l'appelée **/
            generateRandomNumber();
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /** //6.3 Ajout de la méthode Random Number **/
    public void generateRandomNumber(){
        Random rand = new Random();
        nbAleatoire = rand.nextInt(20) + 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        /** //3.0 Déclaration du nombre aléatoire google java random number **/
//        Random rand = new Random();
//        /** //3.1 la VAR nbAleatoire doit être accessible depuis la méthode devine donc elle doit être globale **/
//        nbAleatoire = rand.nextInt(20) + 1;
        /** //6.4 Ajout de l'appel de la méthode pour le démarrage du jeu **/
        generateRandomNumber();
    }
}
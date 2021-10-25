package com.samuelvialle.plusoumoins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.samuelvialle.plusoumoins.Accueil.Accueil;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = findViewById(R.id.ivLoading);

        imageView.animate()
                .alpha(1)
                .rotation(3600)
                .setDuration(2000)
                .withEndAction(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this, Accueil.class));
            }
        }).start();
//        But also you can set end action setting special listener like:
//
//        view.animate().translationY(0).setListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                // do something
//            }
    }
}
package com.example.mehmetyilmaz.demobraintrainer;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class GamesActivity extends AppCompatActivity {

    TextView textTitle, textWords, textMaths, textGame3, textGame4, textGame5, textGame6;
    ImageView imageBoss;
    Animation smallToBig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        smallToBig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

        textTitle      = (TextView) findViewById(R.id.textTitle);
        textWords      = (TextView) findViewById(R.id.textWords);
        textMaths      = (TextView) findViewById(R.id.textMaths);
        textGame3      = (TextView) findViewById(R.id.textGame3);
        textGame4      = (TextView) findViewById(R.id.textGame4);
        textGame5      = (TextView) findViewById(R.id.textGame5);
        textGame6      = (TextView) findViewById(R.id.textGame6);

        imageBoss       = (ImageView) findViewById(R.id.imageBoss);
        imageBoss.startAnimation(smallToBig);

        textTitle.setTypeface(typeface);
        textWords.setTypeface(typeface);
        textMaths.setTypeface(typeface);
        textGame3.setTypeface(typeface);
        textGame4.setTypeface(typeface);
        textGame5.setTypeface(typeface);
        textGame6.setTypeface(typeface);

        textWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(GamesActivity.this, Words1Activity.class);
                startActivity(a);
            }
        });

        textMaths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(GamesActivity.this, Maths1Activity.class);
                startActivity(a);
            }
        });
    }
}

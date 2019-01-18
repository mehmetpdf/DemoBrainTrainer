package com.example.mehmetyilmaz.demobraintrainer;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textWellcome, textTitle;
    ImageView imageBoss;
    Animation smallToBig;
    Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smallToBig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

        textWellcome    = (TextView) findViewById(R.id.textWellcome);
        textTitle      = (TextView) findViewById(R.id.textTitle);
        buttonStart  = (Button) findViewById(R.id.buttonStart);

        imageBoss       = (ImageView) findViewById(R.id.imageBoss);
        imageBoss.startAnimation(smallToBig);

        textWellcome.setTypeface(typeface);
        textTitle.setTypeface(typeface);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, GamesActivity.class);
                startActivity(a);
            }
        });

    }
}

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

public class ResultActivity extends AppCompatActivity {

    TextView textWellDone, textBtnBackHome, textTitle;
    ImageView imageBoss;
    Animation smallToBig;
    Button buttonContinue;
    String whichScreen;
    Class whichActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        smallToBig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

        textWellDone    = (TextView) findViewById(R.id.textWellDone);
        textBtnBackHome    = (TextView) findViewById(R.id.textBtnBackHome);
        textTitle    = (TextView) findViewById(R.id.textTitle);

        buttonContinue  = (Button) findViewById(R.id.buttonContinue);

        imageBoss       = (ImageView) findViewById(R.id.imageBoss);
        imageBoss.startAnimation(smallToBig);

        textWellDone.setTypeface(typeface);
        textBtnBackHome.setTypeface(typeface);
        textTitle.setTypeface(typeface);


        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                whichScreen = getIntent().getExtras().getString("whichScreen");
                if(whichScreen.equals(String.valueOf(R.layout.activity_words1)))
                    whichActivity = Words1Activity.class;
                else if (whichScreen.equals(String.valueOf(R.layout.activity_maths1)))
                    whichActivity = Maths1Activity.class;

                Intent a = new Intent(ResultActivity.this, whichActivity);
                startActivity(a);
            }
        });

        textBtnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(a);
            }
        });


    }
}

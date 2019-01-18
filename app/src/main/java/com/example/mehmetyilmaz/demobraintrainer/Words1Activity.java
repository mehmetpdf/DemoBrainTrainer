package com.example.mehmetyilmaz.demobraintrainer;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Words1Activity extends AppCompatActivity {

    private int pressCounter = 0;
    private int maxPressCounter = 4;
    private String[] keys = {"B", "R", "X", "D", "I"};
    private String answer = "BIRD";
    TextView textScreen, textQuestion, textTitle;
    Animation smallbigforth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words1);

        smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);

        keys = shuffleArray(keys);

        for(String key : keys){
            addView(((LinearLayout) findViewById(R.id.layoutParent)), key, ((EditText) findViewById(R.id.editText)));
        }

        maxPressCounter = 4;
    }

    private String[] shuffleArray(String ar[]){
        Random random = new Random();

        for(int i = ar.length-1; i > 0; i-- ){
            int index = random.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }


    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        layoutParams.rightMargin = 30;

        final TextView textView = new TextView(this);
        textView.setLayoutParams(layoutParams);
        textView.setBackground(this.getResources().getDrawable(R.drawable.bgpink));
        textView.setTextColor(this.getResources().getColor(R.color.colorPurple));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(32);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

        textQuestion    = (TextView) findViewById(R.id.textWellcome);
        textScreen      = (TextView) findViewById(R.id.textTitle);
        textTitle       = (TextView) findViewById(R.id.buttonStart);

        textQuestion.setTypeface(typeface);
        textScreen.setTypeface(typeface);
        textTitle.setTypeface(typeface);
        editText.setTypeface(typeface);
        textView.setTypeface(typeface);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pressCounter < maxPressCounter){
                    if(pressCounter == 0)
                        editText.setText("");

                    editText.setText(editText.getText().toString() + text);
                    textView.startAnimation(smallbigforth);
                    textView.animate().alpha(0).setDuration(300);
                    pressCounter++;

                    if(pressCounter == maxPressCounter)
                        doValidate();
                }
            }
        });

        viewParent.addView(textView);
    }

    private void doValidate(){
        pressCounter = 0;

        EditText editText = (EditText) findViewById(R.id.editText);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutParent);

        if(editText.getText().toString().equals(answer)){
//            Toast.makeText(MainActivity.this, "Correct!!", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(Words1Activity.this, ResultActivity.class);
            a.putExtra("whichScreen", String.valueOf(R.layout.activity_words1));
            startActivity(a);
            editText.setText("");
        } else {
            Toast.makeText(Words1Activity.this, "Wrong!!", Toast.LENGTH_SHORT).show();
            editText.setText("");
        }

        keys = shuffleArray(keys);
        linearLayout.removeAllViews();
        for(String key : keys){
            addView(linearLayout, key, editText);
        }
    }
}

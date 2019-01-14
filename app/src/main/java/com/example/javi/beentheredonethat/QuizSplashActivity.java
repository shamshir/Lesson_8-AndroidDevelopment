package com.example.javi.beentheredonethat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class QuizSplashActivity extends QuizActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_splash);

        animacionTextoTop();

        animacionImagenes();

        animacionTextoBottom();
    }

    @Override
    protected void onPause() {
        super.onPause();

        stopAnimations();
    }

    protected void animacionTextoTop() {
        TextView logo = (TextView) findViewById(R.id.TextViewTopTitle);
        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo.startAnimation(fade);
    }

    protected void animacionImagenes() {
        Animation spinin = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        LayoutAnimationController controller = new LayoutAnimationController(spinin);
        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            row.setLayoutAnimation(controller);
        }
    }

    protected void animacionTextoBottom() {
        TextView logo = (TextView) findViewById(R.id.TextViewBottomTitle);
        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        listenerTransicionActividad(fade);
        logo.startAnimation(fade);
    }

    protected void listenerTransicionActividad(Animation fade) {

        fade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(QuizSplashActivity.this, QuizMenuActivity.class));
                QuizSplashActivity.this.finish();
            }
        });
    }

    protected void stopAnimations() {
        TextView logoTop = (TextView) findViewById(R.id.TextViewTopTitle);
        logoTop.clearAnimation();

        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            row.clearAnimation();
        }

        TextView logoBottom = (TextView) findViewById(R.id.TextViewBottomTitle);
        logoBottom.clearAnimation();
    }
}

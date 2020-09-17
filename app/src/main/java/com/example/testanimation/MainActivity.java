package com.example.testanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.aghajari.zoomhelper.ZoomHelper;
import com.github.chrisbanes.photoview.PhotoView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    ImageView imgFirst;
    RelativeLayout r1;
    ImageView img3;


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return ZoomHelper.Companion.getInstance().dispatchTouchEvent(ev,this) || super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.image);
        imgFirst = (ImageView) findViewById(R.id.image2);
        r1 = (RelativeLayout) findViewById(R.id.r1);

        img3 = (ImageView) findViewById(R.id.image3);
        ZoomHelper.Companion.addZoomableView(img3);

        imgFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgFirst.setEnabled(false);
                r1.setEnabled(false);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate);

                r1.setVisibility(View.VISIBLE);
                r1.startAnimation(animation);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                imgFirst.setEnabled(true);
                r1.setEnabled(true);
            }
        });

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgFirst.setEnabled(false);
                r1.setEnabled(false);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_hide);
                r1.startAnimation(animation);
                r1.setVisibility(View.INVISIBLE);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r1.setEnabled(true);
                imgFirst.setEnabled(true);

            }
        });
    }
}
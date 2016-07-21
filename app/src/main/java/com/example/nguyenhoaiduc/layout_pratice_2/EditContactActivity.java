package com.example.nguyenhoaiduc.layout_pratice_2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import adapter.ImageGridAdapter;

/**
 * Created by nguyen.hoai.duc on 7/14/2016.
 */
public class EditContactActivity extends Activity  {
    private ImageView mImageViewFirst;
    private ImageView mImageViewSecond;
    private ImageView mImageViewThird;
    private ImageView mImageViewFouth;
    private ImageView mImageViewFifth;
    private ImageView mImageViewBack;

    private ObjectAnimator mImageViewSecondAnimator;
    private ObjectAnimator mImageViewThirdAnimator;
    private ObjectAnimator mImageViewFouthAnimator;
    private ObjectAnimator mImageViewFifthAnimator;

    private Animation animRotate;
    private Animation animRotateBack;

    private int flag = 1;

    private int mTranslate1;
    private int mTranslate2;
    private int mTranslate3;
    private int mTranslate4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        initData();
        checkScreen();
        setOnClick();
    }

    public void initData(){
        animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        animRotateBack = AnimationUtils.loadAnimation(this, R.anim.anim_rotate_back);
        mImageViewBack = (ImageView) findViewById(R.id.image_back);
        mImageViewBack.setVisibility(View.VISIBLE);

        mImageViewFirst = (ImageView) findViewById(R.id.image_first);

        mImageViewSecond = (ImageView) findViewById(R.id.image_second);

        mImageViewThird = (ImageView) findViewById(R.id.image_third);

        mImageViewFouth = (ImageView) findViewById(R.id.image_fouth);

        mImageViewFifth = (ImageView) findViewById(R.id.image_fifth);
    }
    public void checkScreen() {

        Display mDisplay = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        mDisplay.getSize(size);
        int mWidth = size.x;
        int mHeight = size.y;

        if (mHeight <= 1280) {
            mTranslate1 = 70;
            mTranslate2 = 140;
            mTranslate3 = 210;
            mTranslate4 = 280;
        } else {
            mTranslate1 = 100;
            mTranslate2 = 200;
            mTranslate3 = 300;
            mTranslate4 = 400;
        }


    }

    public void setOnClick() {

        mImageViewFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animRotate.setFillAfter(true);

                if (flag == 1) {
                    view.startAnimation(animRotate);
                    setObjectAnimatorExpand();
                    flag = 0;

                } else if (flag == 0) {
                    view.startAnimation(animRotateBack);
                    setObjectAnimatorCollapse();
                    flag = 1;
                }
            }
        });

        mImageViewSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), InputContactActivity.class);
                startActivity(intent);
            }
        });

        mImageViewThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), InputContactActivity.class);
                startActivity(intent);
            }
        });

        mImageViewFouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), InputContactActivity.class);
                startActivity(intent);
            }
        });

        mImageViewFifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), InputContactActivity.class);
                startActivity(intent);
            }
        });

        mImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void setObjectAnimatorExpand() {
        mImageViewSecond.setVisibility(View.VISIBLE);
        mImageViewThird.setVisibility(View.VISIBLE);
        mImageViewFouth.setVisibility(View.VISIBLE);
        mImageViewFifth.setVisibility(View.VISIBLE);
        mImageViewSecondAnimator = ObjectAnimator.ofFloat(mImageViewSecond, View.TRANSLATION_Y, mTranslate1).setDuration(300);
        mImageViewSecondAnimator.setRepeatCount(0);

        mImageViewThirdAnimator = ObjectAnimator.ofFloat(mImageViewThird, View.TRANSLATION_Y, mTranslate2).setDuration(300);
        mImageViewThirdAnimator.setRepeatCount(0);

        mImageViewFouthAnimator = ObjectAnimator.ofFloat(mImageViewFouth, View.TRANSLATION_Y, mTranslate3).setDuration(300);
        mImageViewFouthAnimator.setRepeatCount(0);

        mImageViewFifthAnimator = ObjectAnimator.ofFloat(mImageViewFifth, View.TRANSLATION_Y, mTranslate4).setDuration(300);
        mImageViewFifthAnimator.setRepeatCount(0);

        mImageViewSecondAnimator.start();
        mImageViewThirdAnimator.start();
        mImageViewFouthAnimator.start();
        mImageViewFifthAnimator.start();

    }

    public void setObjectAnimatorCollapse() {
        mImageViewSecondAnimator = ObjectAnimator.ofFloat(mImageViewSecond, View.TRANSLATION_Y, 0).setDuration(300);
        mImageViewSecondAnimator.setRepeatCount(0);


        mImageViewThirdAnimator = ObjectAnimator.ofFloat(mImageViewThird, View.TRANSLATION_Y, 0).setDuration(300);
        mImageViewThirdAnimator.setRepeatCount(0);


        mImageViewFouthAnimator = ObjectAnimator.ofFloat(mImageViewFouth, View.TRANSLATION_Y, 0).setDuration(300);
        mImageViewFouthAnimator.setRepeatCount(0);


        mImageViewFifthAnimator = ObjectAnimator.ofFloat(mImageViewFifth, View.TRANSLATION_Y, 0).setDuration(300);
        mImageViewFifthAnimator.setRepeatCount(0);


        mImageViewSecondAnimator.start();
        mImageViewThirdAnimator.start();
        mImageViewFouthAnimator.start();
        mImageViewFifthAnimator.start();

    }

}

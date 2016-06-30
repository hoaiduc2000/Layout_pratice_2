package com.example.nguyenhoaiduc.layout_pratice_2;

import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import view.CircleImageView;

/**
 * Created by nguyen.hoai.duc on 6/30/2016.
 */
public class InputContactActivity extends AppCompatActivity {


    private ImageView mImageViewChoose;
    private ImageView mImageViewProfile;

    private ImageView mImageViewExpand1;
    private LinearLayout mLinearLayoutOption1;
    private LinearLayout mLinearLayoutEdit1;

    private ImageView mImageViewExpand2;
    private LinearLayout mLinearLayoutOption2;
    private LinearLayout mLinearLayoutEdit2;

    private ImageView mImageViewExpand3;
    private LinearLayout mLinearLayoutOption3;
    private LinearLayout mLinearLayoutEdit3;

    private ImageView mImageViewExpand4;
    private LinearLayout mLinearLayoutOption4;
    private LinearLayout mLinearLayoutEdit4;

    private ImageView mImageViewExpand5;
    private LinearLayout mLinearLayoutOption5;
    private LinearLayout mLinearLayoutEdit5;

    private ImageView mImageViewExpand6;
    private LinearLayout mLinearLayoutOption6;
    private LinearLayout mLinearLayoutEdit6;

    private ImageView mImageViewOption1;
    private ImageView mImageViewOption2;
    private ImageView mImageViewOption3;
    private ImageView mImageViewOption4;
    private ImageView mImageViewOption5;
    private ImageView mImageViewOption6;
    private ImageView mImageViewOption7;
    private ImageView mImageViewOption8;
    private ImageView mImageViewSearch1;

    private int mWidthIcon;
    private int mHeightIcon;

    private int mWidthAvatar;
    private int mHeightAvatar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_contact);
        initData();
    }

    public void checkScreen() {
        Display mDisplay = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        mDisplay.getSize(size);
        int mWidth = size.x;
        int mHeight = size.y;

        if (mHeight < 1280) {
            mWidthIcon = 50;
            mHeightIcon = 50;

            mWidthAvatar = 200;
            mHeightAvatar = 200;
        } else {
            mWidthIcon = 80;
            mHeightIcon = 80;

            mWidthAvatar = 200;
            mHeightAvatar = 200;
        }

        int screenSize = getResources().getConfiguration().screenLayout & Configuration
                .SCREENLAYOUT_SIZE_MASK;
        switch (screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                Toast.makeText(this, "SCREENLAYOUT_SIZE_LARGE" + " " + "Width: " + mWidth + " Height: " + mHeight + "", Toast.LENGTH_LONG).show();
                break;
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                Toast.makeText(this, "SCREENLAYOUT_SIZE_NORMAL" + " " + "Width: " + mWidth + " Height: " + mHeight + "", Toast.LENGTH_LONG).show();
                break;
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                Toast.makeText(this, "SCREENLAYOUT_SIZE_SMALL" + " " + "Width: " + mWidth + " Height: " + mHeight + "", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void initData() {
        checkScreen();
        mImageViewChoose = (ImageView) findViewById(R.id.imagge_view_choose);
        mImageViewProfile = (ImageView) findViewById(R.id.image_view_profile);
        mImageViewChoose.setImageBitmap(new CircleImageView(this, mWidthIcon, mHeightIcon).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_expand)));
        mImageViewProfile.setImageBitmap(new CircleImageView(this, mWidthAvatar, mHeightAvatar).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_tom_cruise)));

        mImageViewExpand1 = (ImageView) findViewById(R.id.imagge_view_expand_1);
        mLinearLayoutEdit1 = (LinearLayout) findViewById(R.id.layout_edit_1);
        mLinearLayoutOption1 = (LinearLayout) findViewById(R.id.layout_option_1);

        mImageViewExpand2 = (ImageView) findViewById(R.id.imagge_view_expand_2);
        mLinearLayoutEdit2 = (LinearLayout) findViewById(R.id.layout_edit_2);
        mLinearLayoutOption2 = (LinearLayout) findViewById(R.id.layout_option_2);

        mImageViewExpand3 = (ImageView) findViewById(R.id.imagge_view_expand_3);
        mLinearLayoutEdit3 = (LinearLayout) findViewById(R.id.layout_edit_3);
        mLinearLayoutOption3 = (LinearLayout) findViewById(R.id.layout_option_3);

        mImageViewExpand4 = (ImageView) findViewById(R.id.imagge_view_expand_4);
        mLinearLayoutEdit4 = (LinearLayout) findViewById(R.id.layout_edit_4);
        mLinearLayoutOption4 = (LinearLayout) findViewById(R.id.layout_option_4);

        mImageViewExpand5 = (ImageView) findViewById(R.id.imagge_view_expand_5);
        mLinearLayoutEdit5 = (LinearLayout) findViewById(R.id.layout_edit_5);
        mLinearLayoutOption5 = (LinearLayout) findViewById(R.id.layout_option_5);

        mImageViewExpand6 = (ImageView) findViewById(R.id.imagge_view_expand_6);
        mLinearLayoutEdit6 = (LinearLayout) findViewById(R.id.layout_edit_6);
        mLinearLayoutOption6 = (LinearLayout) findViewById(R.id.layout_option_6);

        mImageViewOption1 = (ImageView) findViewById(R.id.image_view_option_1);
        mImageViewOption2 = (ImageView) findViewById(R.id.image_view_option_2);
        mImageViewOption3 = (ImageView) findViewById(R.id.image_view_option_3);
        mImageViewOption4 = (ImageView) findViewById(R.id.image_view_option_4);
        mImageViewOption5 = (ImageView) findViewById(R.id.image_view_option_5);
        mImageViewOption6 = (ImageView) findViewById(R.id.image_view_option_6);
        mImageViewOption7 = (ImageView) findViewById(R.id.image_view_option_7);
        mImageViewOption8 = (ImageView) findViewById(R.id.image_view_option_8);
        mImageViewSearch1 = (ImageView) findViewById(R.id.image_view_search_1);

        mImageViewOption1.setImageBitmap(new CircleImageView(this, mWidthIcon, mHeightIcon).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_expand)));
        mImageViewOption2.setImageBitmap(new CircleImageView(this, mWidthIcon, mHeightIcon).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_expand)));
        mImageViewOption3.setImageBitmap(new CircleImageView(this, mWidthIcon, mHeightIcon).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_expand)));
        mImageViewOption4.setImageBitmap(new CircleImageView(this, mWidthIcon, mHeightIcon).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_expand)));
        mImageViewOption5.setImageBitmap(new CircleImageView(this, mWidthIcon, mHeightIcon).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_expand)));
        mImageViewOption6.setImageBitmap(new CircleImageView(this, mWidthIcon, mHeightIcon).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_expand)));
        mImageViewOption7.setImageBitmap(new CircleImageView(this, mWidthIcon, mHeightIcon).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_expand)));
        mImageViewOption8.setImageBitmap(new CircleImageView(this, mWidthIcon, mHeightIcon).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_expand)));
        mImageViewSearch1.setImageBitmap(new CircleImageView(this, mWidthIcon, mHeightIcon).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_search)));

        setOnClick();

    }

    public void setOnClick() {
        mImageViewExpand1.setImageBitmap(new CircleImageView(this, 80, 80).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_plus)));
        mImageViewExpand1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLinearLayoutEdit1.getVisibility() == v.GONE) {
                    mLinearLayoutEdit1.setVisibility(View.VISIBLE);
                    mLinearLayoutOption1.setBackgroundColor(0x00000000);
                } else {
                    mLinearLayoutEdit1.setVisibility(View.GONE);
                    mLinearLayoutOption1.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                }
            }
        });


        mImageViewExpand2.setImageBitmap(new CircleImageView(this, 80, 80).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_plus)));
        mImageViewExpand2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLinearLayoutEdit2.getVisibility() == v.GONE) {
                    mLinearLayoutEdit2.setVisibility(View.VISIBLE);
                    mLinearLayoutOption2.setBackgroundColor(0x00000000);
                } else {
                    mLinearLayoutEdit2.setVisibility(View.GONE);
                    mLinearLayoutOption2.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                }
            }
        });


        mImageViewExpand3.setImageBitmap(new CircleImageView(this, 80, 80).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_plus)));
        mImageViewExpand3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLinearLayoutEdit3.getVisibility() == v.GONE) {
                    mLinearLayoutEdit3.setVisibility(View.VISIBLE);
                    mLinearLayoutOption3.setBackgroundColor(0x00000000);
                } else {
                    mLinearLayoutEdit3.setVisibility(View.GONE);
                    mLinearLayoutOption3.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                }
            }
        });


        mImageViewExpand4.setImageBitmap(new CircleImageView(this, 80, 80).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_plus)));
        mImageViewExpand4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLinearLayoutEdit4.getVisibility() == v.GONE) {
                    mLinearLayoutEdit4.setVisibility(View.VISIBLE);
                    mLinearLayoutOption4.setBackgroundColor(0x00000000);
                } else {
                    mLinearLayoutEdit4.setVisibility(View.GONE);
                    mLinearLayoutOption4.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                }
            }
        });


        mImageViewExpand5.setImageBitmap(new CircleImageView(this, 80, 80).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_plus)));
        mImageViewExpand5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLinearLayoutEdit5.getVisibility() == v.GONE) {
                    mLinearLayoutEdit5.setVisibility(View.VISIBLE);
                    mLinearLayoutOption5.setBackgroundColor(0x00000000);
                } else {
                    mLinearLayoutEdit5.setVisibility(View.GONE);
                    mLinearLayoutOption5.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                }
            }
        });


        mImageViewExpand6.setImageBitmap(new CircleImageView(this, 80, 80).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_plus)));
        mImageViewExpand6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLinearLayoutEdit6.getVisibility() == v.GONE) {
                    mLinearLayoutEdit6.setVisibility(View.VISIBLE);
                    mLinearLayoutOption6.setBackgroundColor(0x00000000);
                } else {
                    mLinearLayoutEdit6.setVisibility(View.GONE);
                    mLinearLayoutOption6.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                }
            }
        });


        mImageViewExpand1.setImageBitmap(new CircleImageView(this, 80, 80).getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_action_plus)));
        mImageViewExpand1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLinearLayoutEdit1.getVisibility() == v.GONE) {
                    mLinearLayoutEdit1.setVisibility(View.VISIBLE);
                    mLinearLayoutOption1.setBackgroundColor(0x00000000);
                } else {
                    mLinearLayoutEdit1.setVisibility(View.GONE);
                    mLinearLayoutOption1.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                }
            }
        });
    }
}

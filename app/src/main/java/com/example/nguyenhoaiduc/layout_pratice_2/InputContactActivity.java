package com.example.nguyenhoaiduc.layout_pratice_2;

import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import view.CircleImageView;

/**
 * Created by nguyen.hoai.duc on 6/30/2016.
 */
public class InputContactActivity extends AppCompatActivity implements View.OnClickListener {


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

    private int mWidthAvatar;
    private int mHeightAvatar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_contact);
        initData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imagge_view_expand_1:
                if (mLinearLayoutEdit1.getVisibility() == View.GONE) {
                    mLinearLayoutEdit1.setVisibility(View.VISIBLE);
                    mLinearLayoutOption1.setBackgroundColor(0x00000000);
                    mImageViewExpand1.setImageResource(R.drawable.ic_plus_circle_red_48dp);

                } else {

                    mLinearLayoutEdit1.setVisibility(View.GONE);
                    mLinearLayoutOption1.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                    mImageViewExpand1.setImageResource(R.drawable.ic_plus_circle_black_48dp);
                }
                break;
            case R.id.imagge_view_expand_2:
                if (mLinearLayoutEdit2.getVisibility() == View.GONE) {
                    mLinearLayoutEdit2.setVisibility(View.VISIBLE);
                    mLinearLayoutOption2.setBackgroundColor(0x00000000);
                    mImageViewExpand2.setImageResource(R.drawable.ic_plus_circle_red_48dp);
                } else {
                    mLinearLayoutEdit2.setVisibility(View.GONE);
                    mLinearLayoutOption2.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                    mImageViewExpand2.setImageResource(R.drawable.ic_plus_circle_black_48dp);
                }
                break;
            case R.id.imagge_view_expand_3:
                if (mLinearLayoutEdit3.getVisibility() == View.GONE) {
                    mLinearLayoutEdit3.setVisibility(View.VISIBLE);
                    mLinearLayoutOption3.setBackgroundColor(0x00000000);
                    mImageViewExpand3.setImageResource(R.drawable.ic_plus_circle_red_48dp);
                } else {
                    mLinearLayoutEdit3.setVisibility(View.GONE);
                    mLinearLayoutOption3.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                    mImageViewExpand3.setImageResource(R.drawable.ic_plus_circle_black_48dp);
                }
                break;
            case R.id.imagge_view_expand_4:
                if (mLinearLayoutEdit4.getVisibility() == View.GONE) {
                    mLinearLayoutEdit4.setVisibility(View.VISIBLE);
                    mLinearLayoutOption4.setBackgroundColor(0x00000000);
                    mImageViewExpand4.setImageResource(R.drawable.ic_plus_circle_red_48dp);
                } else {
                    mLinearLayoutEdit4.setVisibility(View.GONE);
                    mLinearLayoutOption4.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                    mImageViewExpand4.setImageResource(R.drawable.ic_plus_circle_black_48dp);
                }
                break;
            case R.id.imagge_view_expand_5:
                if (mLinearLayoutEdit5.getVisibility() == View.GONE) {
                    mLinearLayoutEdit5.setVisibility(View.VISIBLE);
                    mLinearLayoutOption5.setBackgroundColor(0x00000000);
                    mImageViewExpand5.setImageResource(R.drawable.ic_plus_circle_red_48dp);
                } else {
                    mLinearLayoutEdit5.setVisibility(View.GONE);
                    mLinearLayoutOption5.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                    mImageViewExpand5.setImageResource(R.drawable.ic_plus_circle_black_48dp);
                }
                break;
            case R.id.imagge_view_expand_6:
                if (mLinearLayoutEdit6.getVisibility() == View.GONE) {
                    mLinearLayoutEdit6.setVisibility(View.VISIBLE);
                    mLinearLayoutOption6.setBackgroundColor(0x00000000);
                    mImageViewExpand6.setImageResource(R.drawable.ic_plus_circle_red_48dp);
                } else {
                    mLinearLayoutEdit6.setVisibility(View.GONE);
                    mLinearLayoutOption6.setBackgroundColor(getResources().getColor(R.color.color_Blank));
                    mImageViewExpand6.setImageResource(R.drawable.ic_plus_circle_black_48dp);
                }
                break;
        }
    }

    public void initData() {
        mWidthAvatar = 200;
        mHeightAvatar = 200;
        mImageViewChoose = (ImageView) findViewById(R.id.imagge_view_choose);
        mImageViewProfile = (ImageView) findViewById(R.id.image_view_profile);
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

        mImageViewExpand1.setOnClickListener(this);
        mImageViewExpand2.setOnClickListener(this);
        mImageViewExpand3.setOnClickListener(this);
        mImageViewExpand4.setOnClickListener(this);
        mImageViewExpand5.setOnClickListener(this);
        mImageViewExpand6.setOnClickListener(this);

        mImageViewOption1 = (ImageView) findViewById(R.id.image_view_option_1);
        mImageViewOption2 = (ImageView) findViewById(R.id.image_view_option_2);
        mImageViewOption3 = (ImageView) findViewById(R.id.image_view_option_3);
        mImageViewOption4 = (ImageView) findViewById(R.id.image_view_option_4);
        mImageViewOption5 = (ImageView) findViewById(R.id.image_view_option_5);
        mImageViewOption6 = (ImageView) findViewById(R.id.image_view_option_6);
        mImageViewOption7 = (ImageView) findViewById(R.id.image_view_option_7);
        mImageViewOption8 = (ImageView) findViewById(R.id.image_view_option_8);
        mImageViewSearch1 = (ImageView) findViewById(R.id.image_view_search_1);

    }


}

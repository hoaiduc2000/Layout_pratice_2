package com.example.nguyenhoaiduc.layout_pratice_2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import fragment.PreviewFragment;
import utils.ZoomOutPageTransformer;

/**
 * Created by nguyen.hoai.duc on 7/20/2016.
 */
public class PrintPreviewActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    public PreviewFragment mPreviewFragment;

    private TextView mTextView;

    private ImageView mImageViewRotate;
    private ImageView mImageViewPerson;
    private ImageView mImageViewFont;
    private ImageView mImageViewPrint;

    private ArrayList<android.support.v4.app.Fragment> mListFragments;

    private int mCount;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_preview);
        getData();
        initData();
    }

    public void getData() {
        Bundle bundle = getIntent().getExtras();
        mCount = bundle.getInt("count");

        mListFragments = new ArrayList<>();

        for (int i = 0; i < mCount; i++) {
            mPreviewFragment = new PreviewFragment();
            mListFragments.add(mPreviewFragment);
        }
    }

    public void initData() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTextView = (TextView) findViewById(R.id.text_paper);
        mImageViewRotate = (ImageView) findViewById(R.id.image_rotate);
        mImageViewPerson = (ImageView) findViewById(R.id.image_person);
        mImageViewFont = (ImageView) findViewById(R.id.image_font);
        mImageViewPrint = (ImageView) findViewById(R.id.image_print);

        mImageViewRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence items[] = new CharSequence[]{"First", "Second", "Third","Fouth"};
                showDialog(items);
            }
        });

        mImageViewPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Person_Send_Activity.class);
                startActivity(intent);
            }
        });

        mImageViewFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence items[] = new CharSequence[]{"First", "Second"};
                showDialog(items);
            }
        });

        mImageViewPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mTextView.setText(position + 1 + "/" + mListFragments.size());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mListFragments.get(position);
        }

        @Override
        public int getCount() {
            return mListFragments.size();
        }
    }

    public void showDialog(CharSequence items[]) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface d, int n) {
            }

        });
        adb.setNegativeButton("Cancel", null);
        adb.setPositiveButton("OK", null);
        adb.setTitle("Choose direction");
        adb.show();
    }
}

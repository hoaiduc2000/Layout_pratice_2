package com.example.nguyenhoaiduc.layout_pratice_2;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.NavDrawerListAdapter;
import model.NavDrawerItem;
import view.CircleImageView;

/**
 * Created by nguyen.hoai.duc on 6/28/2016.
 */
public class MainActivity extends AppCompatActivity {
    private String[] mTitles;
    private ArrayList<NavDrawerItem> mNavDrawerItemArrayList;
    private NavDrawerListAdapter mNavDrawerListAdapter;
    private ListView mListView;
    private ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        initData();
    }

    public void initData() {
        mNavDrawerItemArrayList = new ArrayList();
        mTitles = getResources().getStringArray(R.array.nav_drawer_items);
        View mHeader = getLayoutInflater().inflate(R.layout.header_drawer, null);
        mImageView = (ImageView) mHeader.findViewById(R.id.image_view_circle);
        CircleImageView mCircleImageView = new CircleImageView(this,200,200);
        mImageView.setImageBitmap(mCircleImageView.getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_tom_cruise)));
        mListView = (ListView) findViewById(R.id.left_drawer);
        mListView.addHeaderView(mHeader, null, false);
        for (int i = 0; i < mTitles.length; i++)
            mNavDrawerItemArrayList.add(new NavDrawerItem(i, mTitles[i]));
        mNavDrawerListAdapter = new NavDrawerListAdapter(this, R.layout.list_item_drawer,
                mNavDrawerItemArrayList);
        mListView.setAdapter(mNavDrawerListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 1:
                        break;

                    case 2:
                        break;

                    case 3:
                        break;

                    case 4:
                        break;

                    case 5:
                        break;

                    case 6:
                        break;

                    case 7:
                        break;

                    case 8:
                        break;
                }
            }
        });
    }

}

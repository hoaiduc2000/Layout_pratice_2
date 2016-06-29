package com.example.nguyenhoaiduc.layout_pratice_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import adapter.NavDrawerListAdapter;
import model.NavDrawerItem;

/**
 * Created by nguyen.hoai.duc on 6/28/2016.
 */
public class MainActivity extends AppCompatActivity {
    private String[] mTitles;
    private ArrayList<NavDrawerItem> mNavDrawerItemArrayList;
    private DrawerLayout mDrawerLayout;
    private NavDrawerListAdapter mNavDrawerListAdapter;
    private ListView mListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        initData();
    }
    public void initData(){
        mNavDrawerItemArrayList = new ArrayList();
        mTitles = getResources().getStringArray(R.array.nav_drawer_items);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mListView = (ListView) findViewById(R.id.left_drawer);

        for(int i = 0; i < mTitles.length;i++)
        mNavDrawerItemArrayList.add(new NavDrawerItem(i,mTitles[i]));
        mNavDrawerListAdapter =  new NavDrawerListAdapter(this,R.layout.list_item_drawer,mNavDrawerItemArrayList);
        mListView.setAdapter(mNavDrawerListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}

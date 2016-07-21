package com.example.nguyenhoaiduc.layout_pratice_2;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import adapter.IndexableRecyclerViewAdapter;
import adapter.NavDrawerListAdapter;
import custom.CircleImageView;
import model.ItemModel;
import model.NavDrawerItem;
import utils.Divider;
import view.IndexableRecyclerView;

public class MainActivity extends Activity implements SearchView.OnQueryTextListener, IndexableRecyclerViewAdapter.OnClickListener {

    private IndexableRecyclerView mIndexableRecyclerView;
    private RecyclerView mRecyclerView;
    private SearchView mSearchView;
    private List<ItemModel> models;
    private IndexableRecyclerViewAdapter indexableRecyclerViewAdapter;

    private String[] mTitles;
    private ArrayList<NavDrawerItem> mNavDrawerItemArrayList;
    private NavDrawerListAdapter mNavDrawerListAdapter;
    private ListView mListView;
    private ImageView mImageView;

    private ImageView mImageViewMenu;
    private ImageView mImageViewFloat;
    private DrawerLayout mDrawerLayout;
    private TextView mTextViewNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDataNav();
        initViews();
        initData();
    }

    public void initDataNav() {
        mNavDrawerItemArrayList = new ArrayList();
        mTitles = getResources().getStringArray(R.array.nav_drawer_items);
        View mHeader = getLayoutInflater().inflate(R.layout.header_drawer, null);
        mImageView = (ImageView) mHeader.findViewById(R.id.image_view_circle);
        CircleImageView mCircleImageView = new CircleImageView(this, 200, 200);
        mImageView.setImageBitmap(mCircleImageView.getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_tom_cruise)));
        mListView = (ListView) findViewById(R.id.left_drawer);
        mListView.addHeaderView(mHeader, null, false);
        for (int i = 0; i < mTitles.length; i++)
            mNavDrawerItemArrayList.add(new NavDrawerItem(i, mTitles[i]));
        mNavDrawerListAdapter = new NavDrawerListAdapter(this, R.layout.list_item_drawer,
                mNavDrawerItemArrayList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
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

    public void openDraw() {
        mDrawerLayout.openDrawer(Gravity.LEFT);
    }

    private void initViews() {
        mIndexableRecyclerView = (IndexableRecyclerView) findViewById(R.id.indexable_recyclerview);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mSearchView = (SearchView) findViewById(R.id.search_view);
        mImageViewMenu = (ImageView) findViewById(R.id.image_menu);
        mImageViewFloat = (ImageView) findViewById(R.id.image_float);
        mImageViewMenu.setVisibility(View.VISIBLE);
        mImageViewFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customSnackBar(v);

            }
        });
        mImageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDraw();
            }
        });
        mTextViewNext = (TextView) findViewById(R.id.text_next);
        mTextViewNext.setVisibility(View.VISIBLE);
        mTextViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), PrintPreviewActivity.class);
                intent.putExtra("count",150);
                startActivity(intent);
            }
        });
    }

    public void customSnackBar(View v) {
        Snackbar mSnackbar = Snackbar.make(v, "",
                Snackbar.LENGTH_LONG);
        LayoutInflater mInflater = (LayoutInflater) this.getLayoutInflater();
        Snackbar.SnackbarLayout mLayout = (Snackbar.SnackbarLayout) mSnackbar.getView();
        View mSnackView = mInflater.inflate(R.layout.snackbar_layout, null);
        mLayout.addView(mSnackView, 0);
        mSnackbar.show();
    }

    private void initData() {

        models = new ArrayList<>();
        ItemModel itemModel1 = new ItemModel();
        itemModel1.setName("AAAA");
        ItemModel itemModel2 = new ItemModel();
        itemModel2.setName("BAAA");
        ItemModel itemModel3 = new ItemModel();
        itemModel3.setName("CAAA");
        ItemModel itemModel4 = new ItemModel();
        itemModel4.setName("DAAA");
        ItemModel itemModel5 = new ItemModel();
        itemModel5.setName("EAAA");
        ItemModel itemModel6 = new ItemModel();
        itemModel6.setName("FAAA");
        ItemModel itemModel7 = new ItemModel();
        itemModel7.setName("GAAA");
        ItemModel itemModel8 = new ItemModel();
        itemModel8.setName("HAAA");
        ItemModel itemModel10 = new ItemModel();
        itemModel10.setName("12");

        ItemModel itemModel9 = new ItemModel();
        itemModel9.setName("BBB");

        ItemModel itemModel11 = new ItemModel();
        itemModel11.setName("あ AAA");
        ItemModel itemModel12 = new ItemModel();
        itemModel12.setName("か BBB");
        ItemModel itemModel13 = new ItemModel();
        itemModel13.setName("はCCC");
        ItemModel itemModel14 = new ItemModel();
        itemModel14.setName("は DDD");

        models.add(itemModel1);
        models.add(itemModel2);
        models.add(itemModel3);
        models.add(itemModel4);
        models.add(itemModel5);
        models.add(itemModel6);
        models.add(itemModel7);
        models.add(itemModel8);
        models.add(itemModel10);
        models.add(itemModel11);
        models.add(itemModel9);

        models.add(itemModel12);
        models.add(itemModel13);
        models.add(itemModel14);


//        models.add(new ItemModel("BACD",""));
//        models.add(new ItemModel("GGGG",""));
//        models.add(new ItemModel("HHHH",""));
//        models.add(new ItemModel("AAAA",""));
//        models.add(new ItemModel("KKKK",""));
//        models.add(new ItemModel("LLLL",""));
//        models.add(new ItemModel("13", ""));
//        models.add(new ItemModel("MMMM",""));
//        models.add(new ItemModel("NNNN",""));
//        models.add(new ItemModel("QQAT",""));
//        models.add(new ItemModel("PPPR",""));
//        models.add(new ItemModel("OOOO",""));
//        models.add(new ItemModel("14",""));
//
//        models.add(new ItemModel("BBBB",""));
//        models.add(new ItemModel("AAAA",""));
//        models.add(new ItemModel("CCCC",""));
//        models.add(new ItemModel("DDDD",""));
//        models.add(new ItemModel("EEEE",""));
//        models.add(new ItemModel("FFFF",""));
//        models.add(new ItemModel("GGGG",""));
//        models.add(new ItemModel("BCDE",""));
//        models.add(new ItemModel("BACD",""));
//        models.add(new ItemModel("GGGG",""));
//        models.add(new ItemModel("HHHH",""));
//        models.add(new ItemModel("AAAA",""));
//        models.add(new ItemModel("KKKK",""));
//        models.add(new ItemModel("LLLL",""));
//        models.add(new ItemModel("13", ""));
//        models.add(new ItemModel("MMMM", ""));
//        models.add(new ItemModel("NNNN", ""));
//        models.add(new ItemModel("QQAT", ""));
//        models.add(new ItemModel("PPPR", ""));
//        models.add(new ItemModel("OOOO",""));
//        models.add(new ItemModel("14", ""));
//
//        models.add(new ItemModel("BACD",""));
//        models.add(new ItemModel("GGGG",""));
//        models.add(new ItemModel("HHHH",""));
//        models.add(new ItemModel("AAAA",""));
//        models.add(new ItemModel("KKKK", ""));
//        models.add(new ItemModel("ZZZZ", ""));
//        models.add(new ItemModel("13", ""));
//        models.add(new ItemModel("MMMM",""));
//        models.add(new ItemModel("NNNN",""));
//        models.add(new ItemModel("QQAT",""));
//        models.add(new ItemModel("PPPR",""));
//        models.add(new ItemModel("OOOO",""));
//        models.add(new ItemModel("14", ""));
//
//        models.add(new ItemModel("ZZZ", ""));
//        models.add(new ItemModel("MMMM",""));
//        models.add(new ItemModel("NNNN",""));
//        models.add(new ItemModel("QQAT",""));

        mSearchView.setOnQueryTextListener(this);
        mRecyclerView.addItemDecoration(new Divider(this));
        indexableRecyclerViewAdapter = new IndexableRecyclerViewAdapter(this, models, mTextViewNext);
        mIndexableRecyclerView.setAdapter(indexableRecyclerViewAdapter);
        indexableRecyclerViewAdapter.setOnclick(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        List<ItemModel> mFilterList = filter(models, newText);
        indexableRecyclerViewAdapter.animateTo(mFilterList);
        mRecyclerView.scrollToPosition(0);
        return false;
    }

    public List<ItemModel> filter(List<ItemModel> mList, String query) {
        query = query.toLowerCase();

        List<ItemModel> mFilterList = new ArrayList<>();
        for (ItemModel item : mList) {
            String text = item.getName().toLowerCase();
            if (text.contains(query)) {
                mFilterList.add(item);
            }
        }
        return mFilterList;
    }

    @Override
    public void OnClickContact(int id) {
        Intent intent = new Intent(this, EditContactActivity.class);
        startActivity(intent);
    }
}
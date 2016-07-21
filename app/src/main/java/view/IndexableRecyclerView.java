package view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nguyenhoaiduc.layout_pratice_2.R;

import adapter.IndexableRecyclerViewAdapter;
import adapter.SectionedRecyclerAdapter;
import model.LetterBar;

public class IndexableRecyclerView extends RelativeLayout {
    public static final int DEFAULT_COLUMN_NUMBER = 3;
    private RecyclerView mRecyclerView;
    private FrameLayout mFrameLayout;
    private TextView mTipText;
    private LetterBar mLetterBar;
    private Context mContext;
    public int mColumnNumber = DEFAULT_COLUMN_NUMBER;
    private SectionedRecyclerAdapter mRecyclerAdapter;

    public IndexableRecyclerView(Context context) {
        this(context, null);
    }

    public IndexableRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IndexableRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initViews(context);
        init(attrs, defStyleAttr);
    }

    private void initViews(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_indexable, this);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mLetterBar = (LetterBar) view.findViewById(R.id.letter_bar);
        mTipText = (TextView) view.findViewById(R.id.tip_text);
        mFrameLayout = (FrameLayout) view.findViewById(R.id.frame_tip);
    }

    public void setAdapter(IndexableRecyclerViewAdapter adapter) {
        mRecyclerAdapter = new SectionedRecyclerAdapter(mContext, R.layout.contact_title_name, R.id.text_view_title, adapter);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {


        final LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mLetterBar.setOnLetterSelectListener(new LetterBar.OnLetterSelectListener() {
            @Override
            public void onLetterSelect(int position, String letter, boolean confirmed) {
                if (confirmed) {
                    mTipText.setVisibility(View.GONE);
                    mFrameLayout.setVisibility(View.GONE);
                } else {
                    mTipText.setVisibility(View.VISIBLE);
                    mFrameLayout.setVisibility(View.VISIBLE);
                    mTipText.setText(letter);
                }
                Integer sectionPosition = mRecyclerAdapter.getSectionPosition(position);
                if (sectionPosition != null)
                    mLinearLayoutManager.scrollToPositionWithOffset(sectionPosition, 0);
            }
        });
    }


}

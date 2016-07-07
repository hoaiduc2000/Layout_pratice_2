package view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nguyenhoaiduc.layout_pratice_2.R;

/**
 * Created by nguyen.hoai.duc on 7/4/2016.
 */
public class TitleView extends LinearLayout {
    public TextView mTextView;
    public ImageView mImageView;
    public LinearLayout mLinearLayout;

    public TitleView(Context context, ViewGroup viewGroup) {
        super(context);
        setInitView(context, viewGroup);
        this.addView(mLinearLayout);
    }

    public void setInitView(Context context,ViewGroup viewGroup) {
        mLinearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.title_layout, viewGroup, false);
        mTextView = (TextView) mLinearLayout.findViewById(R.id.text_view_title);
        mImageView = (ImageView) mLinearLayout.findViewById(R.id.imagge_view_expand);

    }
}

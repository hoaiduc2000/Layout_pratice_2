package view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.nguyenhoaiduc.layout_pratice_2.R;

/**
 * Created by nguyen.hoai.duc on 7/4/2016.
 */
public class AddressView extends OcrView {
    private LinearLayout mLinearLayout;
    public ImageView mImageView;
    public ImageView mImageViewSearch;

    public AddressView(Context context, ViewGroup viewGroup) {
        super(context);
        setInitView(context, viewGroup);
        this.addView(mLinearLayout);
    }


    protected void setInitView(Context context, ViewGroup viewGroup) {
        mLinearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.address_layout, viewGroup, false);
        mImageView = (ImageView) mLinearLayout.findViewById(R.id.image_view_remove2);
        mImageViewSearch = (ImageView) mLinearLayout.findViewById(R.id.image_view_address_search);
        mImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnRemoveLisnener.OnRemove(mView);
            }
        });
    }
}

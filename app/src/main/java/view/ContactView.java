package view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.nguyenhoaiduc.layout_pratice_2.R;

/**
 * Created by nguyen.hoai.duc on 7/1/2016.
 */
public class ContactView extends LinearLayout {
    private LinearLayout mLinearLayout;
    public ImageView mImageView;
    public ImageView mImageViewOption;
    public EditText mEditText;

    public ContactView(Context context, ViewGroup viewGroup) {
        super(context);
        setInitView(context, viewGroup);
        this.addView(mLinearLayout);
    }

    protected void setInitView(Context context, ViewGroup viewGroup) {
        mLinearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.contact_layout, viewGroup, false);
        mImageView = (ImageView) mLinearLayout.findViewById(R.id.image_view_profile);
        mImageViewOption = (ImageView) mLinearLayout.findViewById(R.id.image_view_option_1);
        mEditText = (EditText) mLinearLayout.findViewById(R.id.edit_text_suffix);

    }
}

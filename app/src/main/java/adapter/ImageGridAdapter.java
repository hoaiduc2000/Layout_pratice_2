package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.nguyenhoaiduc.layout_pratice_2.R;

import java.util.ArrayList;

import custom.ExpandableHeightGridView;
import model.ImageItem;

/**
 * Created by nguyen.hoai.duc on 7/6/2016.
 */
public class ImageGridAdapter extends ArrayAdapter<ImageItem> {

    private Activity mContext;
    private int mLayoutId;
    private ArrayList<ImageItem> mImageItems;
    private OnClickListenner mOnClickListenner;
    public ImageGridAdapter(Activity context, int resource, ArrayList<ImageItem> list) {
        super(context, resource, list);
        this.mContext = context;
        this.mLayoutId = resource;
        this.mImageItems = list;
    }

    @Override
    public int getCount() {
        return mImageItems.size();
    }

    public void setOnClickListener(OnClickListenner mOnClickListenner){
        this.mOnClickListenner = mOnClickListenner;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getLayoutInflater();
            convertView = mInflater.inflate(mLayoutId, null);
        }
        final ImageView mImageView = (ImageView) convertView.findViewById(R.id.image_view_item);
        mImageView.setImageBitmap(mImageItems.get(position).getResizeBitmap());
        mImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mOnClickListenner.setOnClick(position);
                return true;
            }
        });

        return convertView;
    }

    public interface OnClickListenner{
        void setOnClick(int position);
    }
}

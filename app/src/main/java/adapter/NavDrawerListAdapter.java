package adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenhoaiduc.layout_pratice_2.R;

import java.util.ArrayList;

import model.NavDrawerItem;

/**
 * Created by nguyen.hoai.duc on 6/29/2016.
 */
public class NavDrawerListAdapter extends ArrayAdapter<NavDrawerItem> {
    private Activity mContext;
    private int mLayoutId;
    private ArrayList<NavDrawerItem> navDrawerItems;

    public NavDrawerListAdapter(Activity context, int resource, ArrayList<NavDrawerItem> navDrawerItemArrayList) {
        super(context, resource, navDrawerItemArrayList);
        this.mContext = context;
        this.mLayoutId = resource;
        this.navDrawerItems = navDrawerItemArrayList;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getLayoutInflater();
            convertView = mInflater.inflate(mLayoutId, null);
        }
        final TextView mTextView = (TextView) convertView.findViewById(R.id.text_view_item);
        final ImageView mImageView = (ImageView) convertView.findViewById(R.id.image_view_next);
        mTextView.setText(navDrawerItems.get(position).getTitle());
        if (position == 0 || position == 3) {
            convertView.setBackgroundResource(R.color.colorItem);
            mTextView.setTextColor(ContextCompat.getColor(mContext,R.color.colorTextTitle));
            mTextView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        if (position == 1 || position == 4 || position == 5)
        mTextView.setTextColor(ContextCompat.getColor(mContext,R.color.colorTextBlur));
        if (position == 1 || position == 2 || position == 4 || position == 7)
            mImageView.setBackgroundResource(R.drawable.ic_action_next_item);
        return convertView;
    }
}

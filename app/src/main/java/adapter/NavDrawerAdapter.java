package adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenhoaiduc.layout_pratice_2.R;

import java.util.ArrayList;

import model.NavDrawerItem;

/**
 * Created by nguyen.hoai.duc on 6/29/2016.
 */
public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.MyViewHolder> {
    private Activity mContext;
    private ArrayList<NavDrawerItem> navDrawerItems;

    public NavDrawerAdapter(Activity context, ArrayList<NavDrawerItem> navDrawerItemArrayList) {
        this.mContext = context;
        this.navDrawerItems = navDrawerItemArrayList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_drawer, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NavDrawerAdapter.MyViewHolder holder, int position) {

        holder.mTextView.setText(navDrawerItems.get(position).getTitle());
        if (position == 0 || position == 3) {
            holder.itemView.setBackgroundResource(R.color.colorItem);
            holder.mTextView.setTextColor(ContextCompat.getColor(mContext,R.color.colorTextTitle));
            holder.mTextView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        if (position == 1 || position == 4 || position == 5)
            holder.mTextView.setTextColor(ContextCompat.getColor(mContext,R.color.colorTextBlur));
        if (position == 1 || position == 2 || position == 4 || position == 7)
            holder.mImageView.setBackgroundResource(R.drawable.ic_action_next_item);
    }

    @Override
    public int getItemCount() {
        return navDrawerItems.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
         TextView mTextView;
         ImageView mImageView;


        public MyViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.text_view_item);
            mImageView = (ImageView) view.findViewById(R.id.image_view_next);
        }
    }
}

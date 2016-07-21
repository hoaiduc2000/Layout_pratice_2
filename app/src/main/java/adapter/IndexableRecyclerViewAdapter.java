package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenhoaiduc.layout_pratice_2.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import custom.CustomCheckBox;
import model.ItemModel;

public class IndexableRecyclerViewAdapter extends RecyclerView.Adapter implements SectionedRecyclerAdapter.SectionedRecyclerDelegate {
    public static final String TAG = "IndexableRecyclerViewAdapter";
    private static String strLetterBars = "あかさたなはまやらわA1#";
    public static final int TYPE_BANNER = 0;
    private final LayoutInflater mLayoutInflater;
    private OnClickListener mOnClickListener;
    private List<ItemModel> mItemModels;
    private int mLineNumber = 0;
    private ItemModel miItemModel;
    private TextView mTextViewNext;
    LinkedHashMap<String, List<ItemModel>> mSectionedHashMap;

    public IndexableRecyclerViewAdapter(Context context, List<ItemModel> models, TextView mTextView) {
        mItemModels = models;
        mLayoutInflater = LayoutInflater.from(context);
        mTextViewNext = mTextView;
        init();
        initModel();
    }

    public void initModel() {
        for (int i = 0; i < mItemModels.size(); i++)
            mItemModels.get(i).setCheck(false);
    }

    private void init() {
        mSectionedHashMap = new LinkedHashMap<>();
        mSections.clear();
        sortItemList();
        for (int i = 0; i < mItemModels.size(); i++) {
            String contact = mItemModels.get(i).getName().trim();
            boolean check = checkLetter(contact);
            if (contact == null || contact.isEmpty() || check == false)
                contact = "#";
            String c = String.valueOf(contact.charAt(0));
            List<ItemModel> itemModels = mSectionedHashMap.get(c);
            if (itemModels == null) {
                itemModels = new ArrayList<>();
            }
            itemModels.add(mItemModels.get(i));
            mSectionedHashMap.put(String.valueOf(contact.charAt(0)), itemModels);
        }
        calculateSectionPosition();
    }

    public boolean checkLetter(String ch) {
        char[] c = strLetterBars.toCharArray();
        int count = 0;
        for (int i = 0; i < c.length; i++)
            if (ch.toCharArray()[0] != c[i])
                count++;
        if (count == c.length)
            return false;
        return true;
    }

    public void sortItemList() {
        Collections.sort(mItemModels, new Comparator<ItemModel>() {
            @Override
            public int compare(ItemModel lhs, ItemModel rhs) {
                return String.valueOf(lhs.getName().charAt(0)).compareTo(String.valueOf(rhs.getName().charAt(0)));
            }
        });
        List<ItemModel> modelList = new ArrayList<>();
        for (int i = 0; i < mItemModels.size(); i++) {
            String ch = mItemModels.get(i).getName();
            boolean check = checkLetter(ch);
            if (ch == null || ch.isEmpty() || check == false)
                modelList.add(mItemModels.get(i));
        }
        List<ItemModel> modelListTemp = new ArrayList<>();

        for (int i = 0; i < mItemModels.size(); i++) {
            int count = 0;
            for (int j = 0; j < modelList.size(); j++)
                if (mItemModels.get(i).getName().equals(modelList.get(j).getName()) == false)
                    count++;
            if (count == modelList.size())
                modelListTemp.add(mItemModels.get(i));
        }

        mItemModels.clear();
        mItemModels.addAll(modelListTemp);
        mItemModels.addAll(modelList);


    }

    private void calculateSectionPosition() {
        Set<String> keySet = mSectionedHashMap.keySet();
        String strings[] = new String[keySet.size()];
        ArrayList<String> mString = new ArrayList<>();
        keySet.toArray(strings);
        Arrays.sort(strings);
//        if (strings[0].equals("#") && strings[1].equals("1") && strings[2].equals("A")) {
//            for (int i = 3; i < strings.length; i++)
//                mString.add(strings[i]);
//            mString.add(strings[2]);
//            mString.add(strings[1]);
//            mString.add(strings[0]);
//        } else if (strings[0].equals("#") && strings[1].equals("1")) {
//            for (int i = 2; i < strings.length; i++)
//                mString.add(strings[i]);
//            mString.add(strings[1]);
//            mString.add(strings[0]);
//        } else if (strings[0].equals("#") && strings[1].equals("A")) {
//            for (int i = 2; i < strings.length; i++)
//                mString.add(strings[i]);
//            mString.add(strings[1]);
//            mString.add(strings[0]);
//        } else
        if (strings[0].equals("#")) {
            for (int i = 1; i < strings.length; i++)
                mString.add(strings[i]);
            mString.add(strings[0]);
        } else {
            for (int i = 0; i < strings.length; i++)
                mString.add(strings[i]);
        }
        int pos = 0;
        for (int i = 0; i < mString.size(); i++) {
            SectionedRecyclerAdapter.Section section = new SectionedRecyclerAdapter.Section(pos, mString.get(i));
            mSections.add(section);
            pos += mSectionedHashMap.get(mString.get(i)).size();
        }

        mLineNumber = pos;
    }

    @Override
    public List<SectionedRecyclerAdapter.Section> getSections() {
        return mSections;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BannerViewHolder(mLayoutInflater.inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        miItemModel = mItemModels.get(position);

        ((BannerViewHolder) holder).mTextView.setText(mItemModels.get(position).getName());
        final BannerViewHolder myViewHolder = (BannerViewHolder) holder;

        ((BannerViewHolder) holder).mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miItemModel.setCheck(myViewHolder.mCheckBox.isSelected());

            }
        });
        if (miItemModel.isCheck()) {
            myViewHolder.mCheckBox.setSelect(true);

        } else
            myViewHolder.mCheckBox.setSelect(false);
        ((BannerViewHolder) holder).mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewNext.setVisibility(View.VISIBLE);
                mOnClickListener.OnClickContact(1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLineNumber;
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_BANNER;
    }

    public static class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;
        CustomCheckBox mCheckBox;

        public BannerViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_view_item);
            mTextView = (TextView) itemView.findViewById(R.id.text_view_contact);
            mCheckBox = (CustomCheckBox) itemView.findViewById(R.id.checkbox_contact);

        }
    }

    public ItemModel removeItem(int position) {
        final ItemModel model = mItemModels.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, ItemModel model) {
        mItemModels.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final ItemModel model = mItemModels.remove(fromPosition);
        mItemModels.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

    public void animateTo(List<ItemModel> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<ItemModel> newModels) {
        for (int i = mItemModels.size() - 1; i >= 0; i--) {
            final ItemModel model = mItemModels.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<ItemModel> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final ItemModel model = newModels.get(i);
            if (!mItemModels.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<ItemModel> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final ItemModel model = newModels.get(toPosition);
            final int fromPosition = mItemModels.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void setOnclick(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    public interface OnClickListener {
        void OnClickContact(int id);
    }
}



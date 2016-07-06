package com.example.nguyenhoaiduc.layout_pratice_2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.renderscript.Sampler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import adapter.ImageGridAdapter;
import custom.CircleImageView;
import custom.ExpandableHeightGridView;
import dialog.ListItemDialog;
import model.ImageItem;
import utils.Constrans;
import view.AddressView;
import view.BottomView;
import view.ContactView;
import view.EmailView;
import view.JointlyView;
import view.PhoneView;
import view.TitleView;
import view.OcrView;
import view.WebView;
import view.WorkView;

/**
 * Created by nguyen.hoai.duc on 7/4/2016.
 */
public class InputContactActivity extends AppCompatActivity implements OcrView.OnRemoveLisnener {


    public LinearLayout mLinearLayout;
    private ContactView mContactView;
    private BottomView mBottomView;
    private TitleView mTitleWorkView;
    private TitleView mTitlePhoneView;
    private TitleView mTitleEmailView;
    private TitleView mTitleWebView;
    private TitleView mTitleAddressView;
    private TitleView mTitleJointlyView;

    private String dir = "";
    private int count = 0;
    private int flag = 0;
    private Uri outputFileUri;
    private CharSequence action[] = new CharSequence[]{"Capture Picture", "Open Gallery"};
    private Constrans mConstrans;

    private ArrayList<WorkView> mList = new ArrayList<>();
    private ArrayList<ImageItem> mImageItems = new ArrayList<>();

    public Context mContext;
    private View mView;

    private ExpandableHeightGridView mHeightGridView;
    private ImageGridAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_input_contact);
        initData();

    }

    public void initData() {
        mLinearLayout = (LinearLayout) findViewById(R.id.linear_layout_parent);

        mContactView = new ContactView(mContext, mLinearLayout);
        mBottomView = new BottomView(mContext, mLinearLayout);
        mTitleWorkView = new TitleView(mContext, mLinearLayout);
        mTitleAddressView = new TitleView(mContext, mLinearLayout);
        mTitleEmailView = new TitleView(mContext, mLinearLayout);
        mTitlePhoneView = new TitleView(mContext, mLinearLayout);
        mTitleJointlyView = new TitleView(mContext, mLinearLayout);
        mTitleWebView = new TitleView(mContext, mLinearLayout);

        mLinearLayout.addView(mContactView);
        mLinearLayout.addView(mTitleWorkView);
        mLinearLayout.addView(mTitleAddressView);
        mLinearLayout.addView(mTitlePhoneView);
        mLinearLayout.addView(mTitleEmailView);
        mLinearLayout.addView(mTitleWebView);
        mLinearLayout.addView(mTitleJointlyView);
        mLinearLayout.addView(mBottomView);

        mTitleWorkView.mTextView.setText(getResources().getText(R.string.work));
        mTitleJointlyView.mTextView.setText(getResources().getText(R.string.Join));
        mTitleWebView.mTextView.setText(getResources().getText(R.string.title_website));
        mTitleEmailView.mTextView.setText(getResources().getText(R.string.title_email));
        mTitlePhoneView.mTextView.setText(getResources().getText(R.string.title_phone));
        mTitleAddressView.mTextView.setText(getResources().getText(R.string.title_address));
        setOnClick();

    }

    public void setOnClick() {
        createFolder();

        mTitleWorkView.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkView mWorkView = new WorkView(getBaseContext(), mLinearLayout);
                mWorkView.setOnclick((OcrView.OnRemoveLisnener) mContext);
                mList.add(mWorkView);
                mLinearLayout.addView(mWorkView, mLinearLayout.indexOfChild(mTitleWorkView));
            }
        });

        mTitleAddressView.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddressView mAddressView = new AddressView(getBaseContext(), mLinearLayout);
                mAddressView.setOnclick((OcrView.OnRemoveLisnener) mContext);
                mAddressView.mImageViewSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ListItemDialog mListItemDialog = new ListItemDialog(getBaseContext());
                        mListItemDialog.show();
                    }
                });
                mLinearLayout.addView(mAddressView, mLinearLayout.indexOfChild(mTitleAddressView));
            }
        });

        mTitlePhoneView.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneView mPhoneView = new PhoneView(getBaseContext(), mLinearLayout);
                mPhoneView.setOnclick((OcrView.OnRemoveLisnener) mContext);
                mLinearLayout.addView(mPhoneView, mLinearLayout.indexOfChild(mTitlePhoneView));
            }
        });

        mTitleEmailView.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmailView mEmailView = new EmailView(getBaseContext(), mLinearLayout);
                mEmailView.setOnclick((OcrView.OnRemoveLisnener) mContext);
                mLinearLayout.addView(mEmailView, mLinearLayout.indexOfChild(mTitleEmailView));
            }
        });

        mTitleWebView.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView mWebView = new WebView(getBaseContext(), mLinearLayout);
                mWebView.setOnclick((OcrView.OnRemoveLisnener) mContext);
                mLinearLayout.addView(mWebView, mLinearLayout.indexOfChild(mTitleWebView));
            }
        });

        mTitleJointlyView.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JointlyView mJointlyView = new JointlyView(getBaseContext(), mLinearLayout);
                mJointlyView.setOnclick((OcrView.OnRemoveLisnener) mContext);
                mLinearLayout.addView(mJointlyView, mLinearLayout.indexOfChild(mTitleJointlyView));
            }
        });

        mBottomView.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 1;
                dialogBuilder();
            }
        });
        mContactView.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 0;
                dialogBuilder();
            }
        });

        mAdapter = new ImageGridAdapter(this, R.layout.image_layout, mImageItems);
        mHeightGridView = (ExpandableHeightGridView) findViewById(R.id.expandable_grid_view);
        mHeightGridView.setNumColumns(3);
        mHeightGridView.setExpanded(true);
        mHeightGridView.setAdapter(mAdapter);

    }


    public void createFolder() {

        dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/picFolder/";
        File newdir = new File(dir);
        newdir.mkdirs();

    }

    public void capturePic() {
        count++;
        String file = dir + count + ".jpg";
        File newfile = new File(file);
        try {
            newfile.createNewFile();
        } catch (IOException e) {
        }
        outputFileUri = Uri.fromFile(newfile);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        startActivityForResult(intent, 1);

    }

    public void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
            if (resultCode == RESULT_OK) {
                Bitmap photo = null;
                try {
                    photo = MediaStore.Images.Media.getBitmap(this.getContentResolver(), outputFileUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (flag == 1) {
                    mImageItems.add(new ImageItem(photo));
                    mAdapter.notifyDataSetChanged();
                } else
                    mContactView.mImageView.setImageBitmap((new CircleImageView(this, mConstrans.mWidth, mConstrans.mHeight).getRoundedShape(photo)));
            }

        if (requestCode == 0)
            if (resultCode == RESULT_OK) {
                Bitmap photo = null;
                try {
                    photo = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (flag == 1) {
                    mImageItems.add(new ImageItem(photo));
                    mAdapter.notifyDataSetChanged();
                } else
                    mContactView.mImageView.setImageBitmap((new CircleImageView(this, 300, 300).getRoundedShape(photo)));
            }
    }

    @Override
    public void OnRemove(View view) {
        mView = view;
        new AlertDialog.Builder(this)
                .setTitle("Remove field")
                .setMessage("Are you sure you want to remove this field ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        mLinearLayout.removeView(mView);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    public void dialogBuilder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose action");
        builder.setItems(action, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        capturePic();
                        break;
                    case 1:
                        openGallery();
                        break;
                }
            }
        });
        builder.show();
    }
}

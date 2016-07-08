package com.example.nguyenhoaiduc.layout_pratice_2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import adapter.ImageGridAdapter;
import adapter.NavDrawerListAdapter;
import custom.CircleImageView;
import custom.ExpandableHeightGridView;
import model.ImageItem;
import model.NavDrawerItem;
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
    private String mDialogText = "";
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

    private String[] mTitles;
    private ArrayList<NavDrawerItem> mNavDrawerItemArrayList;
    private NavDrawerListAdapter mNavDrawerListAdapter;
    private ListView mListView;
    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_input_contact);
        initDataNav();
        initData();

    }

    public void initDataNav() {
        mNavDrawerItemArrayList = new ArrayList();
        mTitles = getResources().getStringArray(R.array.nav_drawer_items);
        View mHeader = getLayoutInflater().inflate(R.layout.header_drawer, null);
        mImageView = (ImageView) mHeader.findViewById(R.id.image_view_circle);
        CircleImageView mCircleImageView = new CircleImageView(this,200,200);
        mImageView.setImageBitmap(mCircleImageView.getRoundedShape(BitmapFactory
                .decodeResource(getResources(), R.drawable.ic_tom_cruise)));
        mListView = (ListView) findViewById(R.id.left_drawer);
        mListView.addHeaderView(mHeader, null, false);
        for (int i = 0; i < mTitles.length; i++)
            mNavDrawerItemArrayList.add(new NavDrawerItem(i, mTitles[i]));
        mNavDrawerListAdapter = new NavDrawerListAdapter(this, R.layout.list_item_drawer,
                mNavDrawerItemArrayList);
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

    public void initData() {
        mLinearLayout = (LinearLayout) findViewById(R.id.linear_layout_parent);
        mConstrans = new Constrans();
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

        mContactView.mImageViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog(mContactView.mEditText);
            }
        });
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
                final AddressView mAddressView = new AddressView(getBaseContext(), mLinearLayout);
                mAddressView.setOnclick((OcrView.OnRemoveLisnener) mContext);
                mAddressView.mImageViewOption.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customDialog(mAddressView.mEditText);
                    }
                });
                mLinearLayout.addView(mAddressView, mLinearLayout.indexOfChild(mTitleAddressView));
            }
        });

        mTitlePhoneView.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PhoneView mPhoneView = new PhoneView(getBaseContext(), mLinearLayout);
                mPhoneView.setOnclick((OcrView.OnRemoveLisnener) mContext);
                mPhoneView.mImageViewOption.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customDialog(mPhoneView.mEditText);
                    }
                });
                mLinearLayout.addView(mPhoneView, mLinearLayout.indexOfChild(mTitlePhoneView));
            }
        });

        mTitleEmailView.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EmailView mEmailView = new EmailView(getBaseContext(), mLinearLayout);
                mEmailView.setOnclick((OcrView.OnRemoveLisnener) mContext);
                mEmailView.mImageViewOption.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customDialog(mEmailView.mEditText);
                    }
                });
                mLinearLayout.addView(mEmailView, mLinearLayout.indexOfChild(mTitleEmailView));
            }
        });

        mTitleWebView.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final WebView mWebView = new WebView(getBaseContext(), mLinearLayout);
                mWebView.setOnclick((OcrView.OnRemoveLisnener) mContext);
                mWebView.mImageViewOption.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customDialog(mWebView.mEditText);
                    }
                });
                mLinearLayout.addView(mWebView, mLinearLayout.indexOfChild(mTitleWebView));
            }
        });

        mTitleJointlyView.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final JointlyView mJointlyView = new JointlyView(getBaseContext(), mLinearLayout);
                mJointlyView.setOnclick((OcrView.OnRemoveLisnener) mContext);
                mJointlyView.mImageViewOption1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customDialog(mJointlyView.mEditText1);
                    }
                });
                mJointlyView.mImageViewOption2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customDialog(mJointlyView.mEditText2);
                    }
                });
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

        mBottomView.mImageViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog(mBottomView.mEditText);
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

    public void customDialog(final EditText mEditText) {
        final ArrayList<String> mStringArrayList = new ArrayList<>();
        mStringArrayList.add("abcd1");
        mStringArrayList.add("abcd2");
        mStringArrayList.add("abcd3");
        mStringArrayList.add("abcd4");
        mStringArrayList.add("abcd5");
        mStringArrayList.add("abcd6");
        final Dialog mDialog = new Dialog(this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.setContentView(R.layout.dialog_list_item);
        ListView mListView = (ListView) mDialog.findViewById(R.id.list_view_item);
        TextView mTextView = (TextView) mDialog.findViewById(R.id.image_view_cancel);
        LinearLayout mLinearLayout = (LinearLayout) mDialog.findViewById(R.id.cancel_layout);
        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mStringArrayList));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mEditText.setText(mStringArrayList.get(position));
                mDialog.dismiss();
            }
        });
        mDialog.show();
    }
}

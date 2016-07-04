package ocr;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by nguyen.hoai.duc on 7/1/2016.
 */
public class OcrContactView extends OcrView {
    private ImageView imgAvatar;
    private Bitmap bmpAvatar;
    private boolean isAvatarNew = false,isDeleteAvatar = false;
    private EditText txtLastName,txtLastKana,txtFirstName,txtFirstKana,txtSuffix;
    @Override
    public ViewGroup makeControllerView(Context context, ViewGroup viewGroup) {
        return super.makeControllerView(context, viewGroup);
    }

    @Override
    protected void setInitView(Context context, ViewGroup view) {
        super.setInitView(context, view);
        mRoot = (ViewGroup) LayoutInflater.from(context).inflate(
                R.layout.ocr_contact_layout, view, false);
        view.addView(mRoot);
        imgAvatar = (ImageView)mRoot.findViewById(R.id.img_avatar);

        txtLastName = (EditText)mRoot.findViewById(R.id.txt_lastname);
        txtLastKana = (EditText)mRoot.findViewById(R.id.txt_last_kana);
        txtFirstName = (EditText)mRoot.findViewById(R.id.txt_firstname);
        txtFirstKana = (EditText)mRoot.findViewById(R.id.txt_first_kana);
        if(imgAvatar != null)
            imgAvatar.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if(objClickKinof!= null)
                        objClickKinof.onClickObject(OcrContactsView.this, 0);
                }
            });
        txtSuffix = (OcrEditText)mRoot.findViewById(R.id.txt_suffix);
        View btnClickKinof = (View)mRoot.findViewById(R.id.btn_suffix_kinof);
        btnClickKinof.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                KinofSet.getInstall().showHonorificKinof(mContext, new KinofSet.OnListenerResultData() {
                    @Override
                    public void onResultData(Object paramView) {
                        txtSuffix.setTextOcr((String) paramView);
                    }
                });
            }
        });

    }

    public OcrContactView(Context context) {
        super(context);
        makeControllerView(context,null);
    }
}

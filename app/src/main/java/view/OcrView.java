package view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by nguyen.hoai.duc on 7/6/2016.
 */
public class OcrView extends LinearLayout {
    protected OnRemoveLisnener mOnRemoveLisnener;
    protected View mView;

    public OcrView(Context context) {
        super(context);
        mView = this;
    }

    public void setOnclick(OnRemoveLisnener context) {
        this.mOnRemoveLisnener = context;
    }

    public static abstract interface OnRemoveLisnener {
        public void OnRemove(View view);
    }
}

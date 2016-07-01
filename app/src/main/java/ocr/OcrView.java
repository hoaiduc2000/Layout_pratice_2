package ocr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by nguyen.hoai.duc on 7/1/2016.
 */
public class OcrView extends LinearLayout {
    protected Context mContext;
    protected ViewGroup mRoot;

    public OcrView(Context context) {
        super(context);
        this.mContext = context;
    }

    protected ViewGroup makeControllerView(final Context context, ViewGroup viewGroup){
        if(viewGroup == null){
            LinearLayout ln = new LinearLayout(context);
            ln.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                    ,LayoutParams.WRAP_CONTENT));
            addView(ln);
            viewGroup = ln;
        }
        return mRoot;
    }
    protected void setInitView(Context context, ViewGroup view){
    }
}

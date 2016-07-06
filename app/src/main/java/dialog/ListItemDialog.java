package dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.example.nguyenhoaiduc.layout_pratice_2.R;

/**
 * Created by nguyen.hoai.duc on 7/1/2016.
 */
public class ListItemDialog extends Dialog {


    public ListItemDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_list_item);
    }
}

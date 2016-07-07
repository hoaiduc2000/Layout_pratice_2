package model;

import android.graphics.Bitmap;
import android.widget.ImageView;

import utils.Constrans;

/**
 * Created by nguyen.hoai.duc on 7/6/2016.
 */
public class ImageItem {
    private Bitmap imageBitmap;

    public ImageItem(){

    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setImageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }

    public Bitmap getResizeBitmap(){
        Bitmap mBitmap = Bitmap.createScaledBitmap(this.imageBitmap,new Constrans().mWidth,new Constrans().mHeight,true);
        return mBitmap;
    }

    public ImageItem(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }
}

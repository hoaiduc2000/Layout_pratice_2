package view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.widget.ImageView;

import com.example.nguyenhoaiduc.layout_pratice_2.R;

/**
 * Created by nguyen.hoai.duc on 6/29/2016.
 */
public class CircleImageView {
    private Context mContext;
    private int mHeight;
    private int mWidth;

    public CircleImageView(Context context, int width, int height) {
        this.mContext = context;
        this.mWidth = width;
        this.mHeight = height;
    }

    public Bitmap getRoundedShape(Bitmap scaleBitmapImage) {
        Bitmap targetBitmap = Bitmap.createBitmap(mWidth,
                mHeight, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) mWidth - 1) / 2,
                ((float) mHeight - 1) / 2,
                (Math.min(((float) mWidth),
                        ((float) mHeight)) / 2),
                Path.Direction.CCW);

        canvas.clipPath(path);
        Bitmap sourceBitmap = scaleBitmapImage;
        canvas.drawBitmap(sourceBitmap,
                new Rect(0, 0, sourceBitmap.getWidth(),
                        sourceBitmap.getHeight()),
                new Rect(0, 0, mWidth, mHeight), null);
        return targetBitmap;
    }
}

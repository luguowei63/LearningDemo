package com.lgw.android.testmodule.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.bumptech.glide.load.engine.Resource;
import com.lgw.android.testmodule.R;

/**
 * Created by lgw on 2020/12/23
 */
class ClipView extends View {
    private Bitmap bitmap;
    private RectF rectF = new RectF(100f, 100f, 500f, 500f);

    private Paint paint = new Paint();
    private Resources resource;

    public ClipView(Context context) {
        this(context, null);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        resource=context.getResources();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(resource, R.mipmap.icon_test_clip_pic);
            canvas.drawBitmap(bitmap, 0f, 0f, paint);
            canvas.translate(0f, 500f);
            canvas.clipRect(rectF);
            canvas.drawBitmap(bitmap, 0f, 0f, paint);

            Path path=new Path();
            path.addCircle(500,350,200,Path.Direction.CCW);
            canvas.clipPath(path, Region.Op.UNION);
            canvas.drawBitmap(bitmap,0,0,null);


        }
    }
}

package com.lgw.android.testmodule.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.lgw.android.testmodule.R;

/**
 * Created by lgw on 1/14/21
 */
class CirclePhotoView extends View {


    private Bitmap bmp;
    private Bitmap bmpMask;
    private Paint paint;

    private  int OFF_SET=100;



    public CirclePhotoView(Context context) {
        this(context, null);
    }

    public CirclePhotoView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CirclePhotoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        bmp= BitmapFactory.decodeResource(getResources(), R.mipmap.test);
        bmpMask=BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int id=canvas.saveLayer(OFF_SET,OFF_SET,bmpMask.getWidth()+OFF_SET,bmpMask.getHeight()+OFF_SET,null);
        canvas.drawBitmap(bmp,0,0,null);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawBitmap(bmpMask,OFF_SET,OFF_SET,paint);
        canvas.restoreToCount(id);
    }
}

package com.lgw.android.testmodule.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by lgw on 1/15/21
 */
public class MainView extends View {
    public MainView(Context context) {
        this(context, null);
    }

    public MainView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 文字图片
     */
    private Bitmap mTextBitmap = null;

    /**
     * 文字canvas
     */
    private Canvas mTextCanvas = null;

    /**
     * 光效图片
     */
    private Bitmap mLightBitmap = null;
    /**
     * 光效Canvas
     */
    private Canvas mLightCanvas = null;


    private boolean mHasCreated = false;
    private Paint mTextPaint = null;
    private Paint mLightPaint = null;
    private Paint mPaint = null;
    private Xfermode mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    private void init() {
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(40);
        mTextPaint.setColor(Color.BLACK);

        mLightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLightPaint.setColor(Color.RED);


        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (!mHasCreated) {
            // 为了简单，这里创建的图片都是整个屏幕那么大
            mTextBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mTextCanvas = new Canvas(mTextBitmap);
            // 在中间画一段文字
            String text = "红红火火恍恍惚惚";
            float textSize = mTextPaint.measureText(text);
            mTextCanvas.drawText(text, (w - textSize) / 2, h / 2, mTextPaint);
            mLightBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mLightCanvas = new Canvas(mLightBitmap);
            // 画光效，其实就是一个红色的圆
            mLightCanvas.drawCircle(w / 2, h / 2, 70, mLightPaint);
            mHasCreated = true;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 先画一次原文字
        canvas.drawBitmap(mTextBitmap, 0, 0, mPaint);
//         保存画布
        int sc = canvas.saveLayer(0, 0, getWidth(), getHeight(), null);

        // 画光效的文字
        canvas.drawBitmap(mTextBitmap, 0, 0, mPaint);
          mPaint.setXfermode(mXfermode);
        canvas.drawBitmap(mLightBitmap, 0, 0, mPaint);
          mPaint.setXfermode(null);

        canvas.restoreToCount(sc);
    }




}

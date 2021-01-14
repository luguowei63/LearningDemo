package com.lgw.android.testmodule.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by lgw on 1/14/21
 */
class SampleView extends View {

    private Paint mPaint;

    public SampleView(Context context) {
        this(context, null);
    }

    public SampleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SampleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFocusable(true);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);
        canvas.translate(10, 10);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(75, 75, 75, mPaint);
        canvas.saveLayerAlpha(80, 80, 500, 500, 0x88);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(175, 175, 75, mPaint);
        canvas.restore();


    }
}
package com.example.debugdemo.Wight;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/3/15 0015.
 */
public class CircleProgressView extends View {


    private Paint pt_circle;
    private Paint pt_arc;
    private Paint pt_text;
    private float strokwidth=20;
    private float x=200+strokwidth/2;
    private  float y=200+strokwidth/2;
    private float radius=200;
    private RectF rectf;

    public CircleProgressView(Context context) {
        super(context);
        init();
    }


    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    @Override
    protected void onDraw(Canvas canvas) {
       // super.onDraw(canvas);
        //每一次调用会调用onDraw方法
        canvas.drawCircle(x,y,radius,pt_circle);
        //canvas.drawCircle(2*x,2*x,radius,pt_circle);
        canvas.drawArc(rectf,-90,270,true,pt_arc);
        canvas.drawRect(rectf, pt_arc);

        invalidate();

    }

    private void init() {
        pt_circle=new Paint();
        pt_circle.setColor(0xFFFF1111);
        pt_circle.setAntiAlias(true);
        pt_circle.setStyle(Paint.Style.STROKE);
        pt_circle.setStrokeWidth(strokwidth);

        pt_arc=new Paint();
        pt_arc.setColor(0xFF31B2E2);
        pt_arc.setAntiAlias(true);
        pt_arc.setStyle(Paint.Style.STROKE);
        pt_arc.setStrokeWidth(strokwidth);
        rectf=new RectF(strokwidth/2,strokwidth/2,2*x-strokwidth/2,2*y-strokwidth/2);

    }

}

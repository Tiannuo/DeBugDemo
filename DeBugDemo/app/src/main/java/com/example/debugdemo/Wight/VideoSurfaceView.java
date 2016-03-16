package com.example.debugdemo.Wight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2016/1/26 0026.
 */
public class VideoSurfaceView extends SurfaceView {

    private static final float MAX_ASPECT_RATIO_DEFORMATION_PERCENT = 0.01f;

    private float videoAspectRatio;

    public VideoSurfaceView(Context context) {
        super(context);
    }

    public VideoSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Set the aspect ratio that this {@link VideoSurfaceView} should satisfy.
     *
     * @param widthHeightRatio The width to height ratio.
     */
    public void setVideoWidthHeightRatio(float widthHeightRatio) {
        if (this.videoAspectRatio != widthHeightRatio) {
            this.videoAspectRatio = widthHeightRatio;
            requestLayout();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        if (videoAspectRatio != 0) {
            float viewAspectRatio = (float) width / height;
            float aspectDeformation = videoAspectRatio / viewAspectRatio - 1;
            if (aspectDeformation > MAX_ASPECT_RATIO_DEFORMATION_PERCENT) {
                height = (int) (width / videoAspectRatio);
            } else if (aspectDeformation < -MAX_ASPECT_RATIO_DEFORMATION_PERCENT) {
                width = (int) (height * videoAspectRatio);
            }
        }
        setMeasuredDimension(width, height);
    }




}

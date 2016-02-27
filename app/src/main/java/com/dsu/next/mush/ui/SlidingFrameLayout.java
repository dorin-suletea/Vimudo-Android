package com.dsu.next.mush.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;


public class SlidingFrameLayout extends FrameLayout {

    public SlidingFrameLayout(Context context) {
        super(context);
    }

    public SlidingFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlidingFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setYFraction(final float fraction) {
        float translationY = getHeight() * fraction;
        setTranslationY(translationY);
    }

    public float getYFraction() {
        if (getHeight() == 0) {
            return 0;
        }
        return getTranslationY() / getHeight();
    }

    public void setXFraction(final float fraction) {
        float translationX = getWidth() * fraction;
        setTranslationX(translationX);
    }

    public float getXFraction() {
        if (getWidth() == 0) {
            return 0;
        }
        return getTranslationX() / getWidth();
    }

}

package com.chyrta.onboarder.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.view.View;

import com.chyrta.onboarder.R;

public class CircleIndicatorView extends View {

    private Paint activeIndicatorPaint;
    private Paint inactiveIndicatorPaint;
    private int radius;
    private int size;
    private int position;
    private int indicatorsCount;

    public CircleIndicatorView(Context context) {
        super(context);
        init();
    }

    public CircleIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleIndicatorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        activeIndicatorPaint = new Paint();
        activeIndicatorPaint.setColor(getResources().getColor(R.color.active_indicator, null));
        activeIndicatorPaint.setAntiAlias(true);
        inactiveIndicatorPaint = new Paint();
        inactiveIndicatorPaint.setColor(getResources().getColor(R.color.inactive_indicator, null));
        inactiveIndicatorPaint.setAntiAlias(true);
        radius = getResources().getDimensionPixelSize(R.dimen.indicator_size);
        size = radius * 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < indicatorsCount; i++) {
            canvas.drawCircle(radius + (size * i), radius, radius / 2, inactiveIndicatorPaint);
        }
        canvas.drawCircle(radius + (size * position), radius, radius / 2, activeIndicatorPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    public void setCurrentPage(int position) {
        this.position = position;
        invalidate();
    }

    public void setPageIndicators(int size) {
        this.indicatorsCount = size;
        invalidate();
    }

    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = size * indicatorsCount;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 2 * radius + getPaddingTop() + getPaddingBottom();
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    public void setInactiveIndicatorColor(@ColorRes int color) {
        inactiveIndicatorPaint.setColor(getResources().getColor(color, null));
        invalidate();
    }

    public void setActiveIndicatorColor(@ColorRes int color) {
        activeIndicatorPaint.setColor(getResources().getColor(color, null));
        invalidate();
    }

}

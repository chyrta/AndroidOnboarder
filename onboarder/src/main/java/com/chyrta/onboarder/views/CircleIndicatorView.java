package com.chyrta.onboarder.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.view.ViewGroup;

public class CircleIndicatorView extends View {

    OvalShape oval;

    public CircleIndicatorView(Context context) {
        super(context);
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        oval = new OvalShape();
        oval.draw(canvas, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        params.height = 8;
        params.width = 8;
    }


}

package com.example.mysketchbook;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PaintArea extends View implements View.OnTouchListener {

    Paint paint = new Paint();
    ArrayList<Point> pointArrayList = new ArrayList<>();

    public PaintArea(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);

        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        Point dot = new Point();
        dot.x = event.getX();
        dot.y = event.getY();
        pointArrayList.add(dot);
        invalidate();
        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        for (Point point: pointArrayList) {
            canvas.drawCircle(point.x, point.y, 10, paint);
        }
    }

    private class Point {
        float x, y;
    }

    public void cleanPaintArea() {
        pointArrayList.clear();
        invalidate();
    }
}

package cn.aft.sample.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.facebook.drawee.drawable.ProgressBarDrawable;

import cn.aft.tools.Predictor;

/**
 * 16/1/29 by congtaowang.
 * Version 1.0
 */
public class DigitalProgressDrawable extends ProgressBarDrawable {

    static final int maxLevel = 10000;
    private int currentLevel;

    private Paint circleBarPaint;

    @Override
    public void draw(Canvas canvas) {
        init();
        Rect bounds = getBounds();
        RectF rectF = new RectF((float) (bounds.right * .4), (float) (bounds.bottom * .4),
                (float) (bounds.right * .6), (float) (bounds.bottom * .6));
        if (currentLevel != 0) {
            canvas.drawArc(rectF, 0, (float) (currentLevel * 360 / maxLevel), false, circleBarPaint);
        }

    }

    private void init() {
        if (Predictor.isNull(circleBarPaint)) {
            circleBarPaint = new Paint();
            circleBarPaint.setStrokeWidth(6f);
            circleBarPaint.setColor(Color.WHITE);
            circleBarPaint.setStyle(Paint.Style.STROKE);
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }

    @Override
    protected boolean onLevelChange(int level) {
        currentLevel = level;
        invalidateSelf();
        return super.onLevelChange(level);
    }


}

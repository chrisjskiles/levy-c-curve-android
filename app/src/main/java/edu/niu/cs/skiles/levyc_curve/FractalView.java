package edu.niu.cs.skiles.levyc_curve;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

/**
 * Created by z1638506 on 4/5/2016.
 */
public class FractalView extends View {
    private float x1, y1, x2, y2;
    private int level, fractalColor;
    private Fractal fractal;

    public FractalView(Context context) {
        super(context);
        setLevel(1);
        setFractalColor(Color.rgb(0, 255, 0));
        fractal = new Fractal();
    }

    public void setLevel(int newLevel) {
        level = newLevel;
    }

    public void setFractalColor(int newColor) {
        fractalColor = newColor;
    }

    protected void onDraw(Canvas canvas) {

        //start coordinates
        x1 = canvas.getWidth() / 3;
        y1 = canvas.getHeight() / 4;

        //end coordinates
        x2 = canvas.getWidth() - x1;
        y2 = y1;

        //fill canvas with white
        canvas.drawRGB(255, 255, 255);

        //draw curve
        fractal.drawCCurve(canvas, x1, y1, x2, y2, level, fractalColor);
    }//onDraw
}

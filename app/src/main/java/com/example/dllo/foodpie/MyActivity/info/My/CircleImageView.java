package com.example.dllo.foodpie.MyActivity.info.My;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.dllo.foodpie.R;

/**
 * Created by dllo on 16/9/27.
 */
public class CircleImageView extends ImageView {

    private  boolean isCircle;

    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.CircleImageView);
        isCircle = array.getBoolean(R.styleable.CircleImageView_isCircle,false);

    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {


        if(isCircle){
            BitmapDrawable drawable = (BitmapDrawable) getDrawable();

            if(drawable != null){

                Bitmap bitmap =drawable.getBitmap();
                Bitmap circleBitmap = getCircleBitmap(bitmap);

                Paint paint = new Paint();
                paint.setAntiAlias(true);

                Rect rect = new Rect(0,0,circleBitmap.getWidth(),circleBitmap.getHeight());

                canvas.drawBitmap(circleBitmap,rect,rect,paint);


            }

        }else{
            super.onDraw(canvas);
        }


    }

    private Bitmap getCircleBitmap(Bitmap bitmap) {

        Bitmap  outBitmap = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig().ARGB_8888);

        Canvas canvas = new Canvas(outBitmap);

        Paint paint = new Paint();
        paint.setAntiAlias(true);

        canvas.drawCircle(bitmap.getWidth()/2,bitmap.getHeight()/2,bitmap.getWidth()/2,paint);


        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Rect rect = new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
        canvas.drawBitmap(bitmap,rect,rect,paint);
        return  outBitmap;
    }
}

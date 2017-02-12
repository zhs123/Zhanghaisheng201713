package costomview.zhanghaisheng201713;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 1.类的用途
 * 2.@author:zhanghaisheng
 * 3.@2017/1/3
 */


public class RingView extends View{
    private final Paint paint;
    private final Context context;
    private  String str;

    public RingView(Context context) {

        // TODO Auto-generated constructor stub
        this(context, null);
    }

    public RingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.paint = new Paint();
        this.paint.setAntiAlias(true); //消除锯齿
        this.paint.setStyle(Paint.Style.STROKE); //绘制空心圆
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        int center = getWidth()/2;
        int innerCircle = dip2px(context, 83); //设置内圆半径
        int ringWidth = dip2px(context, 5); //设置圆环宽度

        //绘制内圆
        this.paint.setARGB(155, 167, 190, 206);
        this.paint.setStrokeWidth(40);
        this.paint.setColor(Color.GRAY);
        String str="1234";

        canvas.drawCircle(center,center, innerCircle, this.paint);

        //绘制圆环ringWidth
        this.paint.setARGB(255, 212 ,225, 233);
        this.paint.setStrokeWidth(25);
        this.paint.setColor(Color.BLACK);
        canvas.drawCircle(center,center, innerCircle+1+ringWidth/2, this.paint);

        //绘制外圆
        this.paint.setARGB(155, 167, 190, 206);
        this.paint.setStrokeWidth(20);
        this.paint.setColor(Color.YELLOW);

        canvas.drawCircle(center,center, innerCircle+ringWidth, this.paint);


        super.onDraw(canvas);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

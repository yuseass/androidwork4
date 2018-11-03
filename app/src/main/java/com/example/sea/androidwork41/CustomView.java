package com.example.sea.androidwork41;

import android.content.Context;
import android.graphics.*;
import android.graphics.Paint.Style;
import android.graphics.Path.Direction;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class CustomView extends View {

    public Canvas canvas;

    private Context context;

    public Canvas getCanvas() {
        return canvas;
    }

    //画矩形和圆的画笔和颜色
    public Paint paint1;
    int color1;
    //画Path1的画笔和颜色
    Paint paint2;
    int color2;
    //画Path2的画笔和颜色
    Paint paint3;
    int color3;

    //组合图形
    Path path1,path2;

    //需要在程序中绘制的图形
    Bitmap bitmap;


    public void refresh(){
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);



    };



    //如果不用在布局文件中定义View,则实现此构造函数就足够了---在此处准备好绘图使用的所有对象和数据
    public CustomView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub



        //设置白底
        //setBackgroundColor(Color.GREEN);

        //初始化画笔和颜色;
        color1=Color.BLUE;
        paint1=new Paint();
        paint1.setStyle(Style.FILL);

        paint1.setStrokeWidth(5);    //实芯画笔的宽度无效
        paint1.setColor(color1);
        //paint1.setAlpha(255);



        //建立组合图形对象，画三角形
        path1=new Path();
        path1.moveTo(250, 210); //画图起始位置
        path1.lineTo(180, 300);
        path1.lineTo(310, 300);
        path1.lineTo(250, 210);


        //建立组合图形对象，画椭圆和线段
        path2=new Path();
        RectF rec=new RectF();
        rec.set(450, 50, 300, 100);
        path2.addOval(rec, Direction.CW);

    }

    //所有的绘图操作均在此进行
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);


        this.canvas=canvas;

     //   canvas.drawLine(10,10,110,10,paint1);
        //画出矩形和圆形
        paint1.setStyle(Paint.Style.STROKE);//
        canvas.drawRect(10, 10, 500, 500, paint1); //左上角坐标，右下角坐标

        paint1.setStyle(Style.FILL);//描边
        paint1.setColor(Color.BLACK);//黑色
        canvas.drawCircle(100, 100, 50, paint1); //圆心坐标，半径

        canvas.drawPath(path2, paint1);//椭圆



        paint1.setColor(Color.BLUE);//蓝色
        paint1.setStyle(Paint.Style.STROKE);//
        canvas.drawPath(path1, paint1);




        RectF oval = new RectF(130, 130, 400, 400);
        canvas.drawArc(oval,30,120,false,paint1);


        paint1.setStyle(Style.FILL);//描边
        paint1.setColor(Color.RED);//红色
        canvas.drawRect(150, 450, 350, 400, paint1); //左上角坐标，右下角坐标

    }





}

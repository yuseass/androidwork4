package com.example.sea.androidwork41;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CustomView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建自定义的View对象
         view=new CustomView(this);


        //设置Activity的显示内容为刚创建的View对象
        setContentView(view);


        view.setOnTouchListener(listener1);

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {



                flag=1;//1为移动
                return false;


            }
        });



    }



    private int startX;
    private int startY;
    int flag=0;
    float a=2;
    View.OnTouchListener listener1=new View.OnTouchListener(){


        @Override
        public boolean onTouch(View v, MotionEvent event) {




            int action=event.getAction();




            if(flag==0) {//放缩


                view.invalidate();


                if (action == 0) {

                    // 获取手指按下的坐标
                    startX = (int) event.getRawX();
                    startY = (int) event.getRawY();
                }
                if (action == 1) {
                    if (event.getY() - startY < 0) {//上划


                        v.setScaleX(2);
                        v.setScaleY(2);
                        Toast.makeText(MainActivity.this, "上划", Toast.LENGTH_LONG).show();
                        v.invalidate();

                    } else if (event.getY() - startY > 0) {//下划

                        v.setScaleX(1 / 2);
                        v.setScaleY(1 / 2);
                        Toast.makeText(MainActivity.this, "下划", Toast.LENGTH_LONG).show();
                        v.invalidate();
                    }


                }
            }










            else if(flag==1){//移动
            if (action==0){

             //   v.setAlpha(9/10);
                // 获取手指按下的坐标
                startX = (int) event.getRawX();
                startY = (int) event.getRawY();

                v.setAlpha(0.5f);
                v.invalidate();

            }
            if (action==1){


                v.setAlpha(1);

                flag=0;
            }

            if(action==2) {//移动

               // CustomView v1=(CustomView)v;

              //  v1.paint1.setAlpha(100);

              //  v1.invalidate();

                v.setAlpha(0.5f);


                // 获取手指移动到了哪个点的坐标
                int movingX = (int) event.getRawX();
                int movingY = (int) event.getRawY();
                // 相对于上一个点，手指在X和Y方向分别移动的距离
                int dx = movingX - startX;
                int dy = movingY - startY;
                // 获取View上一次上 下 左 右各边与父控件的距离
                int left = v.getLeft();
                int right = v.getRight();
                int top = v.getTop();
                int bottom = v.getBottom();
                // 设置本次View的上 下 左 右各边与父控件的距离
                v.layout(left + dx, top + dy, right + dx, bottom + dy);
                // 本次移动的结尾作为下一次移动的开始
                startX = (int) event.getRawX();
                startY = (int) event.getRawY();

                v.invalidate();
                Toast.makeText(MainActivity.this, "移动", Toast.LENGTH_LONG).show();
            }


            }













            return false;
        }
    };




}

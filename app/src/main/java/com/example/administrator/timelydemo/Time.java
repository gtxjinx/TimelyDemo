package com.example.administrator.timelydemo;

import android.content.Context;
import android.opengl.Visibility;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Set;

import static android.R.attr.height;
import static android.R.attr.width;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by Jinx on 2017/3/26 15:56.
 */

public class Time extends LinearLayout
{
    private int height;
    private int width;

    private static final float fulltime_height=(float) 2/25;
    private static final float onlyhours_height1=(float) 3/50;
    private static final float onlyhours_height2=(float) 2/50;
    private static final float onlyhours_height3=(float) 3/100;

    ////////定义三种类型的高度比例
    private static final float height_weight0=(float) 1/20/12;
    private static final float height_weight1=(float) 3/100/12;
    private static final float height_weight2=(float) 1/50/12;


    ///////定义每个控件的宽度比
    private static final float width_weight1=3/4;
    private static final float width_weight2=7/12;
    private static final float width_weight3=1/3;

    private static final float line_weight=1/19;
    private static final float hours_weight=1/19;
    private static final float time_weight=16/95;

    private static final float hour_position=8/95;
    private static final float time_position=23/95;

    private static final int full_time=0;
    private static final int only_hours1=1;
    private static final int only_hours2=2;
    private static final int only_hours3=3;
    private static final int no_time1=4;
    private static final int no_time2=5;
    private static final int no_time3=6;
    private static final int no_line=7;


    private TextView line_tv;
    private TextView hours_tv;
    private TextView time_tv;

    public void setType(int Type)
    {
        switch (Type)
        {
            case full_time: //如果是全时间显示
                Log.d("Jinx",height+"");
                Log.d("Jinx",fulltime_height+"");
                Log.d("Jinx",fulltime_height*height+"");
                SetSize(fulltime_height*height);
                break;
            case only_hours1:
                SetSize(onlyhours_height1*height);
                time_tv.setVisibility(View.GONE);
                break;
            case only_hours2:
                SetSize(onlyhours_height2*height);
                time_tv.setVisibility(View.GONE);
                break;
            case only_hours3:
                SetSize(onlyhours_height3*height);
                time_tv.setVisibility(View.GONE);
                break;
            case no_time1:
                SetSize(height_weight0*height);
                line_tv.setVisibility(View.GONE);
                hours_tv.setVisibility(View.GONE);
                time_tv.setVisibility(View.GONE);
                break;
            case no_time2:
                SetSize(height_weight1*height);
                line_tv.setVisibility(View.GONE);
                hours_tv.setVisibility(View.GONE);
                time_tv.setVisibility(View.GONE);
                break;
            case no_time3:
                SetSize(height_weight2*height);
                hours_tv.setVisibility(View.GONE);
                time_tv.setVisibility(View.GONE);
                break;
            case no_line:
                SetSize(height_weight2*height);
                line_tv.setVisibility(View.GONE);
                hours_tv.setVisibility(View.GONE);
                time_tv.setVisibility(View.GONE);
        }
    }

    private void SetSize(float size)
    {
        line_tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,size);
        hours_tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,size);
        time_tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,size);
    }

    public Time(Context context)
    {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.item_time,this,true);
        init();
        initsize();
    }

    public Time(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.item_time,this,true);
        init();
        initsize();
    }

    public Time(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.item_time,this,false);
        init();
        initsize();
    }

    private void init()
    {
        line_tv= (TextView) findViewById(R.id.line);
        hours_tv= (TextView) findViewById(R.id.hours);
        time_tv= (TextView) findViewById(R.id.time);
    }

    private void initsize()
    {
        DisplayMetrics dm=getResources().getDisplayMetrics();
        height=dm.heightPixels;
        //Log.i("Jinx",height+"");
        width=dm.widthPixels;
    }

    public void setHours(int hours)
    {
        hours_tv.setText(hours+"");
    }

    public void setTime(String time)
    {
        time_tv.setText(time);
    }
}

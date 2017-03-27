package com.example.administrator.timelydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ListView;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity
{
    private ListView listView;
    private ArrayList<Data> datalist;

    private static final int full_time=0;
    private static final int only_hours1=1;
    private static final int only_hours2=2;
    private static final int only_hours3=3;
    private static final int no_time1=4;
    private static final int no_time2=5;
    private static final int no_time3=6;
    private static final int no_line=7;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.listview);
        initlist();
    }

    private void initlist()
    {
        datalist=new ArrayList<>();
        for(int hours=0;hours<=24;hours++)
        {
            for(int i=0;i<=12;i++)
            {
                Data data=new Data();
                data.time=i>1?hours+":"+i*5:hours+":0"+i*5;
                data.hours=hours;
                if(i==0&&(hours==0||hours==6||hours==18||hours==24))    //type=3
                {
                        data.Type=3;
                }
                else if (hours==10)
                {
                    if (i==0)   //type=2
                    {
                        data.Type=2;
                    }
                    else    //type=5
                    {
                        data.Type=5;
                    }
                }
                else if(hours==11)
                {
                    if (i==0)   //type=1
                    {
                        data.Type=1;
                    }
                    else    //type=4
                    {
                        data.Type=4;
                    }
                }
                else if(hours==12)
                {
                    if (i==0)   //type=0
                    {
                        data.Type=0;
                    }
                    else    //type=4
                    {
                        data.Type=4;
                    }
                }
                else if(hours==13)
                {
                    if (i==0)   //type=1
                    {
                        data.Type=1;
                    }
                    else    //type=5
                    {
                        data.Type=5;
                    }
                }
                else if(hours==14&&i==0)    //type=2
                {
                    data.Type=2;
                }
                else if(i==0)    //type=6
                {
                    data.Type=6;
                }
                else
                {
                    data.Type=7;
                }
                datalist.add(data);
            }
        }

        MyAdapter adapter=new MyAdapter(datalist,this);
        Log.i("Jinx",datalist.size()+"");
        listView.setAdapter(adapter);
    }
}

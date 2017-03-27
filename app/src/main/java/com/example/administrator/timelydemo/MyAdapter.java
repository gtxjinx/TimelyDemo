package com.example.administrator.timelydemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Jinx on 2017/3/27 11:52.
 */

public class MyAdapter extends BaseAdapter
{
    private ArrayList<Data> datalist;
    private LayoutInflater inflater;


    public MyAdapter(ArrayList<Data> datalist, Context context)
    {
        this.datalist = datalist;
        inflater= LayoutInflater.from(context);
    }
    @Override
    public int getCount()
    {
        return datalist.size();
    }

    @Override
    public Object getItem(int position)
    {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            viewHolder=new ViewHolder();
            convertView =inflater.inflate(R.layout.item,null);
            viewHolder.time= (Time) convertView.findViewById(R.id.item_time);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Data data=datalist.get(position);
        viewHolder.time.setType(data.Type);
        viewHolder.time.setTime(data.time);
        viewHolder.time.setHours(data.hours);
        return convertView;
    }

    class ViewHolder
    {
        public Time time;
    }
}

package com.example.nm.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.DragAndDropPermissions;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 爱新觉罗璎汉 on 2017/11/28.
 */

public class Adapter extends BaseAdapter{
    Context context;
    List<com.example.nm.myapplication.bean.DataBean> data;

    int m=0,y=1;

    public Adapter(Context context, List<com.example.nm.myapplication.bean.DataBean> data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==0){
            return y;
        }else{
            return m;
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       int type = getItemViewType(position);
       if(type==m){

            ViweHolder holder;
            if(convertView==null){
                convertView=View.inflate(context,R.layout.bj,null);
                holder=new ViweHolder();
                holder.image=(ImageView) convertView.findViewById(R.id.image);
                holder.text=(TextView) convertView.findViewById(R.id.text);
                holder.price=(TextView) convertView.findViewById(R.id.price);
                convertView.setTag(holder);
            }else{
                holder=(ViweHolder) convertView.getTag();
            }
            holder.text.setText(data.get(position).getTitle());

            holder.price.setText(data.get(position).getPrice()+"");
            String[] split = data.get(position).getImages().split("\\|");
            Glide.with(context).load(split[0]).into(holder.image);
       }else{
           ViewHolder1 holder1;
           if(convertView==null){
               convertView=View.inflate(context,R.layout.bj1,null);
               holder1=new ViewHolder1();
               holder1.text1=(TextView) convertView.findViewById(R.id.text1);
               holder1.price1=(TextView) convertView.findViewById(R.id.price1);
               convertView.setTag(holder1);
           }else{
               holder1=(ViewHolder1) convertView.getTag();
           }
           holder1.text1.setText(data.get(position).getTitle());
           holder1.price1.setText(data.get(position).getPrice()+"");
       }
        return convertView;
    }
    class ViweHolder{
        ImageView image;
        TextView text;
        TextView price;
    }

    class ViewHolder1{
        TextView text1,price1;
    }
}

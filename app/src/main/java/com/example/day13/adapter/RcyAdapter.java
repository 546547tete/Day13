package com.example.day13.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.day13.R;
import com.example.day13.bean.JavaBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RcyAdapter extends RecyclerView.Adapter {
    private ArrayList<JavaBean.DataBean.DatasBean> list;
    private Context context;

    public RcyAdapter(ArrayList<JavaBean.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rcy, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        JavaBean.DataBean.DatasBean bean = list.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        Glide.with(context).load(bean.getEnvelopePic()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder1.iv_rcy);
        holder1.tv_rcy.setText(bean.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_rcy;
        public TextView tv_rcy;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_rcy = (ImageView) rootView.findViewById(R.id.iv_rcy);
            this.tv_rcy = (TextView) rootView.findViewById(R.id.tv_rcy);
        }

    }
}

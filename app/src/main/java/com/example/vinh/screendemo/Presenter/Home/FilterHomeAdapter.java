package com.example.vinh.screendemo.Presenter.Home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.vinh.screendemo.Data.FilterUiModel;
import com.example.vinh.screendemo.R;

import java.util.ArrayList;
import java.util.logging.Filter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vinh on 9/23/2018.
 */

public class FilterHomeAdapter extends RecyclerView.Adapter<FilterHomeAdapter.MyHolder> {
    public ArrayList<FilterUiModel> list;
    public Context context;

    public FilterHomeAdapter(  ArrayList<FilterUiModel> mList,
             Context mContext){
        list = mList;
        context = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_filter_home,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        FilterUiModel item = list.get(position);
        holder.tvName.setText(item.getName());
        if(item.getIcon() != 0){
            int srcImage;
           if(item.isSelect()){
               srcImage = R.drawable.ic_more_white;
           }else {
               srcImage = R.drawable.ic_more_black;
           }
            Glide.with(context).load(srcImage)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.img_not_available))
                    .into(holder.imgFilter);
            holder.imgFilter.setVisibility(View.VISIBLE);
        }else {
            holder.imgFilter.setVisibility(View.GONE);
        }
        if(item.isSelect()){
            holder.tvName.setTextColor(context.getColor(R.color.white));
        }else {
            holder.tvName.setTextColor(context.getColor(R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.img_filter)
        ImageView imgFilter;
        @BindView(R.id.layout_filter)
        LinearLayout layoutFilter;
        @BindView(R.id.layout_image_filter)
        RelativeLayout layoutImageFilter;
        public MyHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            layoutFilter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(list.get(getAdapterPosition()).isSelect()){
                        list.get(getAdapterPosition()).setSelect(false);
                    }else {
                        list.get(getAdapterPosition()).setSelect(true);
                    }
                    notifyDataSetChanged();
                }
            });
        }
    }
}

package com.example.vinh.screendemo.Presenter.Home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.vinh.screendemo.Data.FoodInfoUiModel;
import com.example.vinh.screendemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vinh on 9/23/2018.
 */

public class FoodInfoAdapter extends RecyclerView.Adapter<FoodInfoAdapter.MyHolder> {
    ArrayList<FoodInfoUiModel> list;
    Context context;

    public FoodInfoAdapter(ArrayList<FoodInfoUiModel> mList,
                           Context mContext) {
        list = mList;
        context = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food_info, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        FoodInfoUiModel item = list.get(position);
        holder.tvName.setText(item.getFoodName());
        holder.tvAddress.setText(item.getAddress());
        String price = item.getPrice() == 0 ? "":String.valueOf(item.getPrice());
        holder.tvDesc.setText(String.format(context.getString(R.string.item_review),item.getDescription(),price));
        if (item.getReview() == 0 || item.getReview() == 1) {
            holder.tvReview.setText(context.getString(R.string.review_food_info, item.getReview()));
        } else {
            holder.tvReview.setText(context.getString(R.string.reviews_food_info, item.getReview()));
        }
        Glide.with(context).load(item.getLinkImage())
                .apply(new RequestOptions()
                .placeholder(R.drawable.img_not_available))
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_food_info)
        ImageView img;
        @BindView(R.id.img_btn_download)
        ImageButton imgBtnDowload;
        @BindView(R.id.img_btn_love)
        ImageButton imgBtnLove;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_review)
        TextView tvReview;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.tv_address)
        TextView tvAddress;

        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

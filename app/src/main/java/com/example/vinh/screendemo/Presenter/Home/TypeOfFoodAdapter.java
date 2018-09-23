package com.example.vinh.screendemo.Presenter.Home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vinh.screendemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vinh on 9/23/2018.
 */

public class TypeOfFoodAdapter extends RecyclerView.Adapter<TypeOfFoodAdapter.MyHolder> {
    ArrayList<String> list;
    Context context;
    int SelectedIndex = -1;

    public TypeOfFoodAdapter(ArrayList<String> mList,
                             Context mContext) {
        list = mList;
        context = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_type_of_food, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvType.setText(list.get(position));
        if(SelectedIndex == position){
            holder.linearLayout.setBackgroundColor(context.getColor(R.color.blue_light));
        }else{
            holder.linearLayout.setBackgroundColor(context.getColor(R.color.trans));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_type_of_food)
        TextView tvType;
        @BindView(R.id.layout_item_type_of_food)
        LinearLayout linearLayout;
        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SelectedIndex = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }
    }
}

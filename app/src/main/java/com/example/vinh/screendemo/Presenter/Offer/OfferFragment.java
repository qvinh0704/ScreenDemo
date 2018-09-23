package com.example.vinh.screendemo.Presenter.Offer;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vinh.screendemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vinh on 9/22/2018.
 */

public class OfferFragment extends Fragment implements ViewOffer {
    PresenterOffer presenterOffer;
    @BindView(R.id.rcl_food_info)
    RecyclerView rclFoodInfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offer, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenterOffer.initViewFoodInfo();
        presenterOffer.initFoodInfo();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterOffer = new PresenterOffer(this, getActivity());
    }

    @Override
    public void initViewFoodInfo() {
        rclFoodInfo.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rclFoodInfo.setAdapter(presenterOffer.getFoodInfoAdapter());
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rclFoodInfo);
    }
}

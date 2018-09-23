package com.example.vinh.screendemo.Presenter.Offer;

import android.app.Activity;

import com.example.vinh.screendemo.Data.FoodInfoUiModel;
import com.example.vinh.screendemo.Presenter.Home.FoodInfoAdapter;
import com.example.vinh.screendemo.Presenter.Home.ViewHome;
import com.example.vinh.screendemo.Utils.Config;

import java.util.ArrayList;

/**
 * Created by Vinh on 9/22/2018.
 */

public class PresenterOffer implements PresenterOfferImp {
    private Activity offerContext;
    private ViewOffer viewOffer;
    private ArrayList<FoodInfoUiModel> listFood;
    private FoodInfoAdapter foodInfoAdapter;

    public PresenterOffer(ViewOffer mViewOffer,Activity mActivity) {
        offerContext = mActivity;
        viewOffer =  mViewOffer;
        listFood = new ArrayList<>();
        foodInfoAdapter = new FoodInfoAdapter(listFood, offerContext);

    }

    @Override
    public FoodInfoAdapter getFoodInfoAdapter() {
        return foodInfoAdapter;
    }

    @Override
    public void initViewFoodInfo() {
        viewOffer.initViewFoodInfo();
    }

    @Override
    public void initFoodInfo() {
        listFood.add(new FoodInfoUiModel("F1", "Andrew's Kampung", 4, 201, "Vegetarian",
                0.0, "Singapore", Config.URL_IMAGE_SAMPLE));
        listFood.add(new FoodInfoUiModel("F2", "Andrew's Kampung", 5, 3, "Vegetarian",
                0.0, "Singapore", Config.URL_IMAGE_SAMPLE));
        listFood.add(new FoodInfoUiModel("F3", "Andrew's Kampung", 3, 58, "Vegetarian",
                0.0, "Singapore", Config.URL_IMAGE_SAMPLE));
        listFood.add(new FoodInfoUiModel("F3", "Andrew's Kampung", 3, 122, "Vegetarian",
                0.0, "Singapore", Config.URL_IMAGE_SAMPLE));
        listFood.add(new FoodInfoUiModel("F3", "Andrew's Kampung", 3, 23, "Vegetarian",
                0.0, "Singapore", Config.URL_IMAGE_SAMPLE));
        listFood.add(new FoodInfoUiModel("F3", "Andrew's Kampung", 3, 998, "Vegetarian",
                0.0, "Singapore", Config.URL_IMAGE_SAMPLE));

        foodInfoAdapter.notifyDataSetChanged();
    }
}

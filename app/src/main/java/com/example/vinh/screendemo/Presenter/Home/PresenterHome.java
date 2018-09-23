package com.example.vinh.screendemo.Presenter.Home;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.example.vinh.screendemo.Data.FilterUiModel;
import com.example.vinh.screendemo.Data.FoodInfoUiModel;
import com.example.vinh.screendemo.FragmentA;
import com.example.vinh.screendemo.FragmentB;
import com.example.vinh.screendemo.FragmentC;
import com.example.vinh.screendemo.Presenter.Offer.OfferFragment;
import com.example.vinh.screendemo.R;
import com.example.vinh.screendemo.Utils.Config;

import java.util.ArrayList;

/**
 * Created by Vinh on 9/22/2018.
 */

public class PresenterHome implements PresenterHomeImp {
    private Activity homeActivity;
    private ViewHome viewHome;
    private HomePagerAdaper homePagerAdapter;
    private TypeOfFoodAdapter typeOfFoodAdapter;
    private FilterHomeAdapter filterHomeAdapter;
    private String[] tabLayoutTitles;
    private int[] tabLayoutIcons;
    private ArrayList<String> listTypeOfFood;
    private ArrayList<FilterUiModel> listFilter;


    public PresenterHome(Activity activity) {
        homeActivity = activity;
        viewHome = (ViewHome) activity;
        homePagerAdapter = new HomePagerAdaper(((FragmentActivity) activity).getSupportFragmentManager());
        listTypeOfFood = new ArrayList<>();
        listFilter = new ArrayList<>();
        typeOfFoodAdapter = new TypeOfFoodAdapter(listTypeOfFood, homeActivity);
        filterHomeAdapter = new FilterHomeAdapter(listFilter, homeActivity);
    }

    public void initTabLayoutTitles() {
        tabLayoutTitles = new String[]{
                homeActivity.getString(R.string.wallet_title),
                homeActivity.getString(R.string.offer_title),
                homeActivity.getString(R.string.scan_title),
                homeActivity.getString(R.string.pay_title),
                homeActivity.getString(R.string.profile_title)
        };
    }

    public void initTabLayoutIcons() {
        tabLayoutIcons = new int[]{
                R.drawable.ic_wallet,
                R.drawable.offer,
                R.drawable.blank,
                R.drawable.pay,
                R.drawable.profile
        };
    }


    public void initTabLayout() {
        initTabLayoutTitles();
        initTabLayoutIcons();
        initTabLayoutFragment();
        viewHome.initTabLayout();
    }

    @Override
    public void initTabLayoutFragment() {
        for (int i = 0; i < tabLayoutIcons.length; i++) {
            switch (tabLayoutIcons[i]) {
                case R.drawable.ic_wallet:
                    homePagerAdapter.addFragment(new OfferFragment(), tabLayoutTitles[i]);
                    break;
                case R.drawable.offer:
                    homePagerAdapter.addFragment(new OfferFragment(), tabLayoutTitles[i]);
                    break;
                case R.drawable.blank:
                    homePagerAdapter.addFragment(new OfferFragment(), tabLayoutTitles[i]);
                    break;
                case R.drawable.pay:
                    homePagerAdapter.addFragment(new OfferFragment(), tabLayoutTitles[i]);
                    break;
                case R.drawable.profile:
                    homePagerAdapter.addFragment(new OfferFragment(), tabLayoutTitles[i]);
                    break;
                default:
                    break;
            }
        }
    }


    public int[] getTabLayoutIcons() {
        return tabLayoutIcons;
    }

    @Override
    public HomePagerAdaper getHomePagerAdaper() {
        return homePagerAdapter;
    }

    @Override
    public void initTypeOfFood() {
        listTypeOfFood.add("Vegetarian");
        listTypeOfFood.add("Asian");
        listTypeOfFood.add("Malaysian");
        listTypeOfFood.add("Indian");
        listTypeOfFood.add("Thai");
        listTypeOfFood.add("Vietnamese");
        typeOfFoodAdapter.notifyDataSetChanged();
    }

    @Override
    public void initFilter() {
        listFilter.add(new FilterUiModel("Price", R.drawable.ic_more_black));
        listFilter.add(new FilterUiModel("Ratings", R.drawable.ic_more_black));
        listFilter.add(new FilterUiModel("Open Now", R.drawable.ic_more_black));
        listFilter.add(new FilterUiModel("Price", R.drawable.ic_more_black));
        filterHomeAdapter.notifyDataSetChanged();
    }

    @Override
    public TypeOfFoodAdapter getTypeOfFoodAdapter() {
        return typeOfFoodAdapter;
    }


    @Override
    public FilterHomeAdapter getFilterAdapter() {
        return filterHomeAdapter;
    }

    @Override
    public void initView() {
        initViewTypeOfFood();
        initViewFilter();
    }

    @Override
    public void initViewTypeOfFood() {
        viewHome.initViewTypeOfFood();
    }


    @Override
    public void initViewFilter() {
        viewHome.initViewFilter();
    }


}

package com.example.vinh.screendemo.Presenter.Home;

/**
 * Created by Vinh on 9/22/2018.
 */

public interface PresenterHomeImp {
    public void initTabLayoutTitles();

    public void initTabLayoutIcons();

    public void initTabLayoutFragment();

    public void initTabLayout();

    public void initView();

    public void initViewTypeOfFood();

    public void initViewFilter();

    public int[] getTabLayoutIcons();

    public HomePagerAdaper getHomePagerAdaper();

    public void initTypeOfFood();

    public void initFilter();

    public TypeOfFoodAdapter getTypeOfFoodAdapter();

    public FilterHomeAdapter getFilterAdapter();
}

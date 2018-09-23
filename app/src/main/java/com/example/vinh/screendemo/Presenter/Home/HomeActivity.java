package com.example.vinh.screendemo.Presenter.Home;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;


import com.example.vinh.screendemo.Presenter.Offer.PresenterOffer;
import com.example.vinh.screendemo.R;


import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements ViewHome {
    @BindView(R.id.tab_layout_home)
    TabLayout tabLayout;
    @BindView(R.id.view_pager_home)
    ViewPager viewPager;
    @BindView(R.id.rcl_type_of_food)
    RecyclerView rclTyeOFFood;
    @BindView(R.id.rcl_filter)
    RecyclerView rclFilterHome;

    PresenterHome presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        presenter = new PresenterHome(this);
        presenter.initTabLayout();
        presenter.initView();
        presenter.initTypeOfFood();
        presenter.initFilter();

    }

    @Override
    public void initViewTypeOfFood() {
        rclTyeOFFood.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rclTyeOFFood.setAdapter(presenter.getTypeOfFoodAdapter());
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rclTyeOFFood);
    }


    @Override
    public void initViewFilter() {
        rclFilterHome.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rclFilterHome.setAdapter(presenter.getFilterAdapter());
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rclFilterHome);
    }

    @Override
    public void initTabLayout() {
        viewPager.setAdapter(presenter.getHomePagerAdaper());
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < presenter.getTabLayoutIcons().length; i++) {
            tabLayout.getTabAt(i).setIcon(presenter.getTabLayoutIcons()[i]);
        }
    }
}

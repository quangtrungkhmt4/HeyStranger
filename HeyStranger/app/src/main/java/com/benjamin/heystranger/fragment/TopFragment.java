package com.benjamin.heystranger.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.benjamin.heystranger.MainActivity;
import com.benjamin.heystranger.R;
import com.benjamin.heystranger.TopActivity;
import com.benjamin.heystranger.adapter.BannerAdapter;
import com.benjamin.heystranger.model.Banner;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {

    private List<Banner> banners;
    private ViewPager viewPagerBanner;
    private BannerAdapter bannerAdapter;
    private TopActivity topActivity;
    private int currentItem = 0;
    private Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.

    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        findId(view);
        initViews(view);
        return view;
    }

    private void findId(View view) {
        viewPagerBanner = view.findViewById(R.id.viewPagerBanner);
    }

    private void initViews(View view) {
        banners = Arrays.asList(
          new Banner("https://lions5m-6.org/wp-content/uploads/2017/06/banner-bg.jpg"),
                new Banner("https://lions5m-6.org/wp-content/uploads/2017/06/banner-bg.jpg"),
                new Banner("https://lions5m-6.org/wp-content/uploads/2017/06/banner-bg.jpg")
        );
        topActivity = (TopActivity) getActivity();
        bannerAdapter = new BannerAdapter(getContext(), banners);
        viewPagerBanner.setAdapter(bannerAdapter);

        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentItem == banners.size()-1) {
                    currentItem = 0;
                }
                viewPagerBanner.setCurrentItem(currentItem++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }
}

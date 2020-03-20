package com.benjamin.heystranger.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.benjamin.heystranger.LoadMore;
import com.benjamin.heystranger.R;
import com.benjamin.heystranger.TopActivity;
import com.benjamin.heystranger.adapter.BannerAdapter;
import com.benjamin.heystranger.adapter.StrangerAdapter;
import com.benjamin.heystranger.model.Banner;
import com.benjamin.heystranger.model.Stranger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TopFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private List<Banner> banners;
    private ViewPager viewPagerBanner;
    private BannerAdapter bannerAdapter;
    private TopActivity topActivity;
    private int currentItem = 0;
    private Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.
    private RecyclerView recyclerStranger;
    private List<Stranger> strangers = new ArrayList<>();
    private StrangerAdapter strangerAdapter;
    private SwipeRefreshLayout refreshStranger;
    private int allStranger = 36;
    private int currentPage = 1;

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
        recyclerStranger = view.findViewById(R.id.recyclerStranger);
        refreshStranger = view.findViewById(R.id.swipeStrangerList);
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
                if (currentItem == banners.size() - 1) {
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

        refreshStranger.setOnRefreshListener(this);

        initStranger();


        //Set Load more event
        strangerAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if (strangers.size() <= allStranger) // Change max size
                {
                    strangers.add(null);
                    strangerAdapter.notifyItemInserted(strangers.size() - 1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            strangers.remove(strangers.size() - 1);
                            strangerAdapter.notifyItemRemoved(strangers.size());
                            currentPage++;
                            loadMoreData(currentPage);

                        }
                    }, 3000); // Time to load
                } else {
                    Toast.makeText(topActivity, "Load data completed !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadMoreData(int page) {
        //todo
        strangers.addAll(addStranger());
        strangerAdapter.notifyDataSetChanged();
        strangerAdapter.setLoaded();
    }

    private List<Stranger> addStranger() {
        return Arrays.asList(
                new Stranger("Trung"),
                new Stranger("Quang"),
                new Stranger("Le"),
                new Stranger("asdasd"),
                new Stranger("cxcc"),
                new Stranger("trtrt"),
                new Stranger("ghggg"),
                new Stranger("fffffffff"),
                new Stranger("ddddddd"),
                new Stranger("ccccccc"),
                new Stranger("eeeeeeeeee"),
                new Stranger("dfdfdf"),
                new Stranger("vcvfhg"),
                new Stranger("cbvcbvbcvbcv"),
                new Stranger("xf"),
                new Stranger("dddd"),
                new Stranger("eeee"),
                new Stranger("Truwwwwng")
        );
    }

    private void initStranger() {

        strangers.addAll(addStranger());
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        recyclerStranger.setLayoutManager(manager);
        strangerAdapter = new StrangerAdapter(recyclerStranger, topActivity, strangers);
        recyclerStranger.setAdapter(strangerAdapter);
    }

    private void refeshStrangers() {
        strangers.addAll(addStranger());
        strangerAdapter.notifyDataSetChanged();
    }


    @Override
    public void onRefresh() {
        refeshStrangers();
        refreshStranger.setRefreshing(false);
    }
}

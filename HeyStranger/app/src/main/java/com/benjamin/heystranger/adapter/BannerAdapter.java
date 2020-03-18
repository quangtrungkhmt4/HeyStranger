package com.benjamin.heystranger.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.benjamin.heystranger.R;
import com.benjamin.heystranger.model.Banner;

import java.util.List;

public class BannerAdapter extends PagerAdapter {

    private Activity context;
    private List<Banner> banners;

    public BannerAdapter(Activity context, List<Banner> banners) {
        this.context = context;
        this.banners = banners;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = context.getLayoutInflater();
        View viewItem = inflater.inflate(R.layout.banner_layout, container, false);
        ImageView imageView = viewItem.findViewById(R.id.imgBanner);

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}

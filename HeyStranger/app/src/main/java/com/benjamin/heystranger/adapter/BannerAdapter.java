package com.benjamin.heystranger.adapter;

import android.annotation.SuppressLint;
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
import com.bumptech.glide.Glide;

import java.util.List;

public class BannerAdapter extends PagerAdapter {

    private Context context;
    private List<Banner> banners;
    private LayoutInflater inflate;

    public BannerAdapter(Context context, List<Banner> banners) {
        this.context = context;
        this.banners = banners;
        inflate = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View imageLayout = inflate.inflate(R.layout.banner_layout, container, false);
        ImageView imageView = imageLayout.findViewById(R.id.imgBanner);
//        imageView.setImageResource(R.drawable.select_image);
        Glide.with(context).load(banners.get(position).getUrl()).into(imageView);
        container.addView(imageLayout, 0);
        return imageLayout;
    }

    @Override
    public int getCount() {
        return banners.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

package com.benjamin.heystranger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.benjamin.heystranger.adapter.PageAdapter;
import com.benjamin.heystranger.fragment.ConversationFragment;
import com.benjamin.heystranger.fragment.LoginFragment;
import com.benjamin.heystranger.fragment.PostFragment;
import com.benjamin.heystranger.fragment.ProfileFragment;
import com.benjamin.heystranger.fragment.RegisterFragment;
import com.benjamin.heystranger.fragment.TopFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.TextScale;

import java.util.Arrays;
import java.util.List;

public class TopActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private BottomNavigationView bottomNavigationView;
    private BadgeDrawable badgeDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        findId();
        initViews();
    }

    private void findId() {
        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private void initViews() {
        pagerAdapter = new PageAdapter(getSupportFragmentManager(), 4, initFragment());
        viewPager.setAdapter(pagerAdapter);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        viewPager.addOnPageChangeListener(this);

        setBadge(R.id.itemPost, 10);
        setBadge(R.id.itemConversation, 1000000);
        removeBadge(R.id.itemPost);
    }

    private List<? extends Fragment> initFragment(){
        return Arrays.asList(
                new TopFragment(),
                new ConversationFragment(),
                new PostFragment(),
                new ProfileFragment()
        );
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemTop:
                viewPager.setCurrentItem(0);
                break;
            case R.id.itemConversation:
                viewPager.setCurrentItem(1);
                break;
            case R.id.itemPost:
                viewPager.setCurrentItem(2);
                break;
            case R.id.itemProfile:
                viewPager.setCurrentItem(3);
                break;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomNavigationView.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void setBadge(int id, int noti){
        badgeDrawable = bottomNavigationView.getOrCreateBadge(id);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(noti);
    }

    private void removeBadge(int id){
        bottomNavigationView.removeBadge(id);
    }
}

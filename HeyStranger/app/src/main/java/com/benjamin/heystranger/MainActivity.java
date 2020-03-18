package com.benjamin.heystranger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.benjamin.heystranger.adapter.PageAdapter;
import com.benjamin.heystranger.fragment.LoginFragment;
import com.benjamin.heystranger.fragment.RegisterFragment;
import com.rd.PageIndicatorView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private PageIndicatorView pageIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findId();
        initViews();
    }

    private void findId() {
        viewPager = findViewById(R.id.viewPager);
        pageIndicatorView = findViewById(R.id.pageIndicatorView);
    }

    private List<? extends Fragment> initFragment(){
        return Arrays.asList(
                new LoginFragment(),
                new RegisterFragment()
        );
    }

    private void initViews() {

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), 2, initFragment());
        viewPager.setAdapter(pagerAdapter);

        pageIndicatorView.setCount(2);
        pageIndicatorView.setSelection(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageIndicatorView.setSelection(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private int INDEX_FRAGMENT_LOGIN = 0;
    public void switchFragment(){
        viewPager.setAdapter(pagerAdapter);
    }

    public void switchToRegister(){
        viewPager.setCurrentItem(1);
    }

}

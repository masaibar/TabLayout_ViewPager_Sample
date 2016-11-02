package com.masaibar.tablayoutsample;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        FragmentPagerAdapter adapter =
                new FragmentPagerAdapter(getSupportFragmentManager()) {
                    @Override
                    public Fragment getItem(int position) {
                        if (position == 1) {
                            return ListViewFragment.newInstance();
                        }
                        return ItemFragment.newInstance(position + 1);
                        //todo ココで個別に定義したFragmentをswtich文で渡すことも出来る
                    }

                    @Override
                    public CharSequence getPageTitle(int position) {
                        return "tab " + position;
                    }

                    @Override
                    public int getCount() {
                        return 4;
                    }
                };

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("!!!!!", "onPageSelected @ " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    public static class ItemFragment extends Fragment {

        public ItemFragment() {
        }

        public static ItemFragment newInstance(int page) {
            Bundle args = new Bundle();
            args.putInt("page", page);

            ItemFragment fragment = new ItemFragment();
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            int page = getArguments().getInt("page", 0);
            View view = inflater.inflate(R.layout.page_item, container, false);
            ((TextView) view.findViewById(R.id.text_content)).setText("Content : " + page);
            return view;
        }
    }
}

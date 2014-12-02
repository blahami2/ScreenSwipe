package cz.blahami2.training_swipeview;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;


public class MusicActivityRoot extends FragmentActivity {

    public static final int NUM_PAGES = 2;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_activity_root);

        ColorDrawable colorDrawable = (ColorDrawable) getResources().getDrawable(R.color.music_color_dark);
        getActionBar().setBackgroundDrawable(colorDrawable);

        mPager = (ViewPager) findViewById(R.id.music_pager);
        mPagerAdapter = new MusicPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(0);
    }

    private class MusicPagerAdapter extends FragmentStatePagerAdapter {
        public MusicPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return MusicMainFragment.newInstance();
                case 1:
                    return MusicPlaylistFragment.newInstance();
                case 2:
                    return MusicSettingsFragment.newInstance();
                default:
                    return MusicMainFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return (NUM_PAGES);
        }
    }
}
